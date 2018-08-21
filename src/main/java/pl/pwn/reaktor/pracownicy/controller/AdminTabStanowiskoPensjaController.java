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
import pl.pwn.reaktor.pracownicy.model.TabStanowiskoPensja;
import pl.pwn.reaktor.pracownicy.model.TabStanowiskoPensjaFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabStanowiskoPensjaService;

public class AdminTabStanowiskoPensjaController extends ControllerTemplate{

    @FXML
    private TableView<TabStanowiskoPensja> table_stanowisko_pensja;

    @FXML
    private TableColumn<TabStanowiskoPensja, String> col_stanowisko;

    @FXML
    private TableColumn<TabStanowiskoPensja, String> col_pensja;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_pensja;

    @FXML
    private Button btn_filtruj;

    @FXML
    private Button btn_usun;

    public boolean condition1() {
    	return Objects.isNull(table_stanowisko_pensja.getSelectionModel())
				|| Objects.isNull(table_stanowisko_pensja.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		String stanowisko = table_stanowisko_pensja.getSelectionModel().getSelectedItem().getStanowisko();
		adminTabStanowiskoPensjaService.delete(stanowisko);
	}

    private AdminTabStanowiskoPensjaService adminTabStanowiskoPensjaService;

    public TableView<TabStanowiskoPensja> init(){
    	return table_stanowisko_pensja;
    }
	
    public void fillTableData() {
		adminTabStanowiskoPensjaService = new AdminTabStanowiskoPensjaService();
		List<TabStanowiskoPensja> kryteria = (List<TabStanowiskoPensja>) adminTabStanowiskoPensjaService.getAll();

		ObservableList<TabStanowiskoPensja> data = FXCollections.observableArrayList(kryteria);
		table_stanowisko_pensja.setItems(null);
		table_stanowisko_pensja.setItems(data);
	}

    public void setCellValue() {

		col_stanowisko.setCellValueFactory(new PropertyValueFactory<>("stanowisko"));
		col_pensja.setCellValueFactory(new PropertyValueFactory<>("pensja"));
		}
    @FXML
    void select(MouseEvent event) {
    	String pensjaValue = tf_filter_pensja.getText();
								
		TabStanowiskoPensjaFilter filter = new TabStanowiskoPensjaFilter(pensjaValue);
		List<TabStanowiskoPensja> list = (List<TabStanowiskoPensja>) adminTabStanowiskoPensjaService.filter(filter);

		ObservableList<TabStanowiskoPensja> data = FXCollections.observableArrayList(list);
		table_stanowisko_pensja.setItems(null);
		table_stanowisko_pensja.setItems(data);
    }
    public void editCells() {
		
		editPensjaCell();
	}

	private void editPensjaCell() {
		col_pensja.setCellFactory(TextFieldTableCell.forTableColumn());
		col_pensja.setOnEditCommit(new EventHandler<CellEditEvent<TabStanowiskoPensja, String>>() {
			@Override
			public void handle(CellEditEvent<TabStanowiskoPensja, String> t) {
				((TabStanowiskoPensja) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPensja(t.getNewValue());
				TabStanowiskoPensja selectedItem = table_stanowisko_pensja.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}
	private void updateCell(TabStanowiskoPensja selectedItem) {
		adminTabStanowiskoPensjaService.update(selectedItem);
	}
}
