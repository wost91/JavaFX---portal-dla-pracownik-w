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
import pl.pwn.reaktor.pracownicy.model.TabPracownicy;
import pl.pwn.reaktor.pracownicy.model.TabPracownicyFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabPracownicyService;

public class AdminTabPracownicyController extends ControllerTemplate{

    @FXML
    private TableView<TabPracownicy> table_pracownicy;

    @FXML
    private TableColumn<TabPracownicy, Long> col_id;

    @FXML
    private TableColumn<TabPracownicy, String> col_imie;

    @FXML
    private TableColumn<TabPracownicy, String> col_nazwisko;

    @FXML
    private TableColumn<TabPracownicy, String> col_pesel;

    @FXML
    private TableColumn<TabPracownicy, String> col_data_ur;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private Button btn_filtruj;

    @FXML
    private TextField tf_filter_data_ur;

    @FXML
    private TextField tf_filter_nazwisko;

    @FXML
    private TextField tf_filter_pesel;

    @FXML
    private Button btn_usun;

    @FXML
    private TextField tf_filter_imie;

    public boolean condition1() {
    	return Objects.isNull(table_pracownicy.getSelectionModel())
				|| Objects.isNull(table_pracownicy.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long id = table_pracownicy.getSelectionModel().getSelectedItem().getId();
		adminTabPracownicyService.delete(id);
	}
   
    private AdminTabPracownicyService adminTabPracownicyService;

    public TableView<TabPracownicy> init(){
    	return table_pracownicy;
    }
    
    public void fillTableData() {
		adminTabPracownicyService = new AdminTabPracownicyService();
		List<TabPracownicy> kryteria = (List<TabPracownicy>) adminTabPracownicyService.getAll();

		ObservableList<TabPracownicy> data = FXCollections.observableArrayList(kryteria);
		table_pracownicy.setItems(null);
		table_pracownicy.setItems(data);
	}

    public void setCellValue() {

		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
		col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		col_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
		col_data_ur.setCellValueFactory(new PropertyValueFactory<>("dataUr"));
		}
    @FXML
    void select(MouseEvent event) {
    	String imieValue = tf_filter_imie.getText();
    	String nazwiskoValue = tf_filter_nazwisko.getText();
    	String peselValue = tf_filter_pesel.getText();
    	String dataUrValue = tf_filter_data_ur.getText();
		
		TabPracownicyFilter filter = new TabPracownicyFilter(imieValue,nazwiskoValue,peselValue,dataUrValue);
		List<TabPracownicy> list = adminTabPracownicyService.filter(filter);

		ObservableList<TabPracownicy> data = FXCollections.observableArrayList(list);
		table_pracownicy.setItems(null);
		table_pracownicy.setItems(data);
    }
    public void editCells() {
		editImieCell();
		editNazwiskoCell();
		editPeselCell();
		editDataUrCell();
		}

	private void editImieCell() {
		col_imie.setCellFactory(TextFieldTableCell.forTableColumn());
		col_imie.setOnEditCommit(new EventHandler<CellEditEvent<TabPracownicy, String>>() {
			@Override
			public void handle(CellEditEvent<TabPracownicy, String> t) {
				((TabPracownicy) t.getTableView().getItems().get(t.getTablePosition().getRow())).setImie(t.getNewValue());
				TabPracownicy selectedItem = table_pracownicy.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void editNazwiskoCell() {
		col_nazwisko.setCellFactory(TextFieldTableCell.forTableColumn());
		col_nazwisko.setOnEditCommit(new EventHandler<CellEditEvent<TabPracownicy, String>>() {
			@Override
			public void handle(CellEditEvent<TabPracownicy, String> t) {
				((TabPracownicy) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNazwisko(t.getNewValue());
				TabPracownicy selectedItem = table_pracownicy.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void editPeselCell() {
		col_pesel.setCellFactory(TextFieldTableCell.forTableColumn());
		col_pesel.setOnEditCommit(new EventHandler<CellEditEvent<TabPracownicy, String>>() {
			@Override
			public void handle(CellEditEvent<TabPracownicy, String> t) {
				((TabPracownicy) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPesel(t.getNewValue());
				TabPracownicy selectedItem = table_pracownicy.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}
	private void editDataUrCell() {
		col_data_ur.setCellFactory(TextFieldTableCell.forTableColumn());
		col_data_ur.setOnEditCommit(new EventHandler<CellEditEvent<TabPracownicy, String>>() {
			@Override
			public void handle(CellEditEvent<TabPracownicy, String> t) {
				((TabPracownicy) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDataUr(t.getNewValue());
				TabPracownicy selectedItem = table_pracownicy.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}
	private void updateCell(TabPracownicy selectedItem) {
		adminTabPracownicyService.update(selectedItem);
			}

}
