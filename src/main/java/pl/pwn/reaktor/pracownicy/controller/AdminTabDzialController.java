package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.pracownicy.Main;
import pl.pwn.reaktor.pracownicy.model.TabDyrektorzy;
import pl.pwn.reaktor.pracownicy.model.TabDyrektorzyFilter;
import pl.pwn.reaktor.pracownicy.model.TabDzial;
import pl.pwn.reaktor.pracownicy.model.TabDzialFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabDyrektorzyService;
import pl.pwn.reaktor.pracownicy.service.AdminTabDzialService;

public class AdminTabDzialController extends ControllerTemplate{

    @FXML
    private TableView<TabDzial> table_dzial;

    @FXML
    private TableColumn<TabDzial, String> col_dzial;

    @FXML
    private TableColumn<TabDzial, String> col_budzet;

    @FXML
    private TableColumn<TabDzial, String> col_liczba_prac;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_budzet;

    @FXML
    private TextField tf_filter_dzial;

    @FXML
    private Button btn_filtruj;

    @FXML
    private Button btn_usun;

    @FXML
    private TextField tf_filter_liczba_prac;
   
    public boolean condition1() {
    	return Objects.isNull(table_dzial.getSelectionModel())
				|| Objects.isNull(table_dzial.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		String dzial = table_dzial.getSelectionModel().getSelectedItem().getDzial();
		adminTabDzialService.delete(dzial);
	}
	
    private AdminTabDzialService adminTabDzialService;
    
	public TableView<TabDzial> init(){
    	return table_dzial;
    }

    public void fillTableData() {
		adminTabDzialService = new AdminTabDzialService();
		List<TabDzial> kryteria = (List<TabDzial>) adminTabDzialService.getAll();

		ObservableList<TabDzial> data = FXCollections.observableArrayList(kryteria);
		table_dzial.setItems(null);
		table_dzial.setItems(data);
	}

    public void setCellValue() {

		col_dzial.setCellValueFactory(new PropertyValueFactory<>("dzial"));
		col_budzet.setCellValueFactory(new PropertyValueFactory<>("budzet"));
		col_liczba_prac.setCellValueFactory(new PropertyValueFactory<>("liczbaPrac"));
		}
    @FXML
    void select(MouseEvent event) {
    	String dzialValue = tf_filter_dzial.getText();
    	String budzetValue = tf_filter_budzet.getText();
    	String liczbaPracValue = tf_filter_liczba_prac.getText();
						
		TabDzialFilter filter = new TabDzialFilter(dzialValue,budzetValue,liczbaPracValue);
		List<TabDzial> list = (List<TabDzial>) adminTabDzialService.filter(filter);

		ObservableList<TabDzial> data = FXCollections.observableArrayList(list);
		table_dzial.setItems(null);
		table_dzial.setItems(data);
    }
    public void editCells() {
		
		editBudzetCell();
		editLiczbaPracCell();
	}

	private void editBudzetCell() {
		col_budzet.setCellFactory(TextFieldTableCell.forTableColumn());
		col_budzet.setOnEditCommit(new EventHandler<CellEditEvent<TabDzial, String>>() {
			@Override
			public void handle(CellEditEvent<TabDzial, String> t) {
				((TabDzial) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBudzet(t.getNewValue());
				TabDzial selectedItem = table_dzial.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void editLiczbaPracCell() {
		col_liczba_prac.setCellFactory(TextFieldTableCell.forTableColumn());
		col_liczba_prac.setOnEditCommit(new EventHandler<CellEditEvent<TabDzial, String>>() {
			@Override
			public void handle(CellEditEvent<TabDzial, String> t) {
				((TabDzial) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLiczbaPrac(t.getNewValue());
				TabDzial selectedItem = table_dzial.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void updateCell(TabDzial selectedItem) {
adminTabDzialService.update(selectedItem);
	}
}
