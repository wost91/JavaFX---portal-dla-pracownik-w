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
import pl.pwn.reaktor.pracownicy.model.TabLogowanie;
import pl.pwn.reaktor.pracownicy.model.TabLogowanieFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabLogowanieService;

public class AdminTabLogowanieController extends ControllerTemplate{

    @FXML
    private TableView<TabLogowanie> table_logowanie;

    @FXML
    private TableColumn<TabLogowanie, Long> col_id;

    @FXML
    private TableColumn<TabLogowanie, String> col_login;

    @FXML
    private TableColumn<TabLogowanie, String> col_haslo;

    @FXML
    private TableColumn<TabLogowanie, String> col_dostep;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private Button btn_filtruj;

    @FXML
    private TextField tf_filter_dostep;

    @FXML
    private TextField tf_filter_login;

    @FXML
    private TextField tf_filter_haslo;

    @FXML
    private Button btn_usun;

    public boolean condition1() {
    	return Objects.isNull(table_logowanie.getSelectionModel())
				|| Objects.isNull(table_logowanie.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long id = table_logowanie.getSelectionModel().getSelectedItem().getId();
		adminTabLogowanieService.delete(id);
	}
    
    private AdminTabLogowanieService adminTabLogowanieService;
    
    public TableView<TabLogowanie> init(){
    	return table_logowanie;
    }

    public void fillTableData() {
		adminTabLogowanieService = new AdminTabLogowanieService();
		List<TabLogowanie> kryteria = (List<TabLogowanie>) adminTabLogowanieService.getAll();

		ObservableList<TabLogowanie> data = FXCollections.observableArrayList(kryteria);
		table_logowanie.setItems(null);
		table_logowanie.setItems(data);
	}

    public void setCellValue() {

		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_login.setCellValueFactory(new PropertyValueFactory<>("login"));
		col_haslo.setCellValueFactory(new PropertyValueFactory<>("haslo"));
		col_dostep.setCellValueFactory(new PropertyValueFactory<>("dostep"));
		}
    @FXML
    void select(MouseEvent event) {
    	String loginValue = tf_filter_login.getText();
    	String hasloValue = tf_filter_haslo.getText();
    	String dostepValue = tf_filter_dostep.getText();
		
		TabLogowanieFilter filter = new TabLogowanieFilter(loginValue,hasloValue,dostepValue);
		List<TabLogowanie> list = (List<TabLogowanie>) adminTabLogowanieService.filter(filter);

		ObservableList<TabLogowanie> data = FXCollections.observableArrayList(list);
		table_logowanie.setItems(null);
		table_logowanie.setItems(data);
    }
    public void editCells() {
		editLoginCell();
		editHasloCell();
		editDostepCell();
		}

	private void editLoginCell() {
		col_login.setCellFactory(TextFieldTableCell.forTableColumn());
		col_login.setOnEditCommit(new EventHandler<CellEditEvent<TabLogowanie, String>>() {
			@Override
			public void handle(CellEditEvent<TabLogowanie, String> t) {
				((TabLogowanie) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLogin(t.getNewValue());
				TabLogowanie selectedItem = table_logowanie.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}
	private void editHasloCell() {
		col_haslo.setCellFactory(TextFieldTableCell.forTableColumn());
		col_haslo.setOnEditCommit(new EventHandler<CellEditEvent<TabLogowanie, String>>() {
			@Override
			public void handle(CellEditEvent<TabLogowanie, String> t) {
				((TabLogowanie) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLogin(t.getNewValue());
				TabLogowanie selectedItem = table_logowanie.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void editDostepCell() {
		col_dostep.setCellFactory(TextFieldTableCell.forTableColumn());
		col_dostep.setOnEditCommit(new EventHandler<CellEditEvent<TabLogowanie, String>>() {
			@Override
			public void handle(CellEditEvent<TabLogowanie, String> t) {
				((TabLogowanie) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDostep(t.getNewValue());
				TabLogowanie selectedItem = table_logowanie.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void updateCell(TabLogowanie selectedItem) {
		adminTabLogowanieService.update(selectedItem);
			}
}
