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
import pl.pwn.reaktor.pracownicy.model.TabPracownikDzial;
import pl.pwn.reaktor.pracownicy.model.TabPracownikDzialFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabPracownikDzialService;

public class AdminTabPracownikDzialController extends ControllerTemplate{

    @FXML
    private TableView<TabPracownikDzial> table_pracownik_dzial;

    @FXML
    private TableColumn<TabPracownikDzial, Long> col_id;

    @FXML
    private TableColumn<TabPracownikDzial, String> col_dzial;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_dzial;

    @FXML
    private Button btn_filtruj;

    @FXML
    private Button btn_usun;
   
    public boolean condition1() {
    	return Objects.isNull(table_pracownik_dzial.getSelectionModel())
				|| Objects.isNull(table_pracownik_dzial.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long id = table_pracownik_dzial.getSelectionModel().getSelectedItem().getId();
		adminTabPracownikDzialService.delete(id);
	}
    
    private AdminTabPracownikDzialService adminTabPracownikDzialService;
    
    public TableView<TabPracownikDzial> init(){
    	return table_pracownik_dzial;
    }
   	
    public void fillTableData() {
   		adminTabPracownikDzialService = new AdminTabPracownikDzialService();
   		List<TabPracownikDzial> kryteria = (List<TabPracownikDzial>) adminTabPracownikDzialService.getAll();

   		ObservableList<TabPracownikDzial> data = FXCollections.observableArrayList(kryteria);
   		table_pracownik_dzial.setItems(null);
   		table_pracownik_dzial.setItems(data);
   	}

    public void setCellValue() {

   		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
   		col_dzial.setCellValueFactory(new PropertyValueFactory<>("dzial"));
   		}
    @FXML
    void select(MouseEvent event) {
    	String dzialValue = tf_filter_dzial.getText();
    			
		TabPracownikDzialFilter filter = new TabPracownikDzialFilter(dzialValue);
		List<TabPracownikDzial> list = adminTabPracownikDzialService.filter(filter);

		ObservableList<TabPracownikDzial> data = FXCollections.observableArrayList(list);
		table_pracownik_dzial.setItems(null);
		table_pracownik_dzial.setItems(data);
    }
    public void editCells() {
		editDzialCell();
		}

	private void editDzialCell() {
		col_dzial.setCellFactory(TextFieldTableCell.forTableColumn());
		col_dzial.setOnEditCommit(new EventHandler<CellEditEvent<TabPracownikDzial, String>>() {
			@Override
			public void handle(CellEditEvent<TabPracownikDzial, String> t) {
				((TabPracownikDzial) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDzial(t.getNewValue());
				TabPracownikDzial selectedItem = table_pracownik_dzial.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
		private void updateCell(TabPracownikDzial selectedItem) {
			adminTabPracownikDzialService.update(selectedItem);
				}
	}

