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
import pl.pwn.reaktor.pracownicy.model.TabPracownikStanowisko;
import pl.pwn.reaktor.pracownicy.model.TabPracownikStanowiskoFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabPracownikStanowiskoService;

public class AdminTabPracownikStanowiskoController extends ControllerTemplate{

    @FXML
    private TableView<TabPracownikStanowisko> table_pracownik_stanowisko;

    @FXML
    private TableColumn<TabPracownikStanowisko, Long> col_id;

    @FXML
    private TableColumn<TabPracownikStanowisko, String> col_stanowisko;

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
    	return Objects.isNull(table_pracownik_stanowisko.getSelectionModel())
				|| Objects.isNull(table_pracownik_stanowisko.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long id = table_pracownik_stanowisko.getSelectionModel().getSelectedItem().getId();
		adminTabPracownikStanowiskoService.delete(id);
	}
    
    private AdminTabPracownikStanowiskoService adminTabPracownikStanowiskoService;
    
    public TableView<TabPracownikStanowisko> init(){
    	return table_pracownik_stanowisko;
    }   	

    public void fillTableData() {
   		adminTabPracownikStanowiskoService = new AdminTabPracownikStanowiskoService();
   		List<TabPracownikStanowisko> kryteria = (List<TabPracownikStanowisko>) adminTabPracownikStanowiskoService.getAll();

   		ObservableList<TabPracownikStanowisko> data = FXCollections.observableArrayList(kryteria);
   		table_pracownik_stanowisko.setItems(null);
   		table_pracownik_stanowisko.setItems(data);
   	}

    public void setCellValue() {

   		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
   		col_stanowisko.setCellValueFactory(new PropertyValueFactory<>("stanowisko"));
   		}
    @FXML
    void select(MouseEvent event) {
    	String dzialValue = tf_filter_dzial.getText();
		
		TabPracownikStanowiskoFilter filter = new TabPracownikStanowiskoFilter(dzialValue);
		List<TabPracownikStanowisko> list = (List<TabPracownikStanowisko>) adminTabPracownikStanowiskoService.filter(filter);

		ObservableList<TabPracownikStanowisko> data = FXCollections.observableArrayList(list);
		table_pracownik_stanowisko.setItems(null);
		table_pracownik_stanowisko.setItems(data);
    }
    public void editCells() {
		editDzialCell();
		}

	private void editDzialCell() {
		col_stanowisko.setCellFactory(TextFieldTableCell.forTableColumn());
		col_stanowisko.setOnEditCommit(new EventHandler<CellEditEvent<TabPracownikStanowisko, String>>() {
			@Override
			public void handle(CellEditEvent<TabPracownikStanowisko, String> t) {
				((TabPracownikStanowisko) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStanowisko(t.getNewValue());
				TabPracownikStanowisko selectedItem = table_pracownik_stanowisko.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
		private void updateCell(TabPracownikStanowisko selectedItem) {
			adminTabPracownikStanowiskoService.update(selectedItem);
		}
}
