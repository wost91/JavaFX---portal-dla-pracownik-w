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
import pl.pwn.reaktor.pracownicy.model.TabHistoria;
import pl.pwn.reaktor.pracownicy.model.TabHistoriaFilter;
import pl.pwn.reaktor.pracownicy.model.TabWyksztalcenie;
import pl.pwn.reaktor.pracownicy.model.TabWyksztalcenieFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabHistoriaService;
import pl.pwn.reaktor.pracownicy.service.AdminTabWyksztalcenieService;

public class AdminTabWyksztalcenieController extends ControllerTemplate{

    @FXML
    private TableView<TabWyksztalcenie> table_wyksztalcenie;

    @FXML
    private TableColumn<TabWyksztalcenie, Long> col_id;

    @FXML
    private TableColumn<TabWyksztalcenie, String> col_uczelnia;

    @FXML
    private TableColumn<TabWyksztalcenie, String> col_data_rozp;

    @FXML
    private TableColumn<TabWyksztalcenie, String> col_data_zak;

    @FXML
    private TableColumn<TabWyksztalcenie, String> col_tytul;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private Button btn_filtruj;

    @FXML
    private TextField tf_filter_data_zak;

    @FXML
    private TextField tf_filter_uczelnia;

    @FXML
    private TextField tf_filter_data_rozp;

    @FXML
    private Button btn_usun;

    @FXML
    private TextField tf_filter_tytul;
    
    public boolean condition1() {
    	return Objects.isNull(table_wyksztalcenie.getSelectionModel())
				|| Objects.isNull(table_wyksztalcenie.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long id = table_wyksztalcenie.getSelectionModel().getSelectedItem().getId();
		adminTabWyksztalcenieService.delete(id);
	}
    
    private AdminTabWyksztalcenieService adminTabWyksztalcenieService;

    public TableView<TabWyksztalcenie> init(){
    	return table_wyksztalcenie;
    }
	
    public void fillTableData() {
		adminTabWyksztalcenieService = new AdminTabWyksztalcenieService();
		List<TabWyksztalcenie> kryteria = (List<TabWyksztalcenie>) adminTabWyksztalcenieService.getAll();

		ObservableList<TabWyksztalcenie> data = FXCollections.observableArrayList(kryteria);
		table_wyksztalcenie.setItems(null);
		table_wyksztalcenie.setItems(data);
	}

    public void setCellValue() {

		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_uczelnia.setCellValueFactory(new PropertyValueFactory<>("uczelnia"));
		col_data_rozp.setCellValueFactory(new PropertyValueFactory<>("dataRozp"));
		col_data_zak.setCellValueFactory(new PropertyValueFactory<>("dataZak"));
		col_tytul.setCellValueFactory(new PropertyValueFactory<>("tytul"));
	   }

    @FXML
    void select(MouseEvent event) {
    	String uczelniaValue = tf_filter_uczelnia.getText();
		String dataRozpValue = tf_filter_data_rozp.getText();
		String dataZakValue = tf_filter_data_zak.getText();
		String tytulValue = tf_filter_tytul.getText();
						
		TabWyksztalcenieFilter filter = new TabWyksztalcenieFilter(uczelniaValue,dataRozpValue,dataZakValue,tytulValue);
		List<TabWyksztalcenie> list = adminTabWyksztalcenieService.filter(filter);

		ObservableList<TabWyksztalcenie> data = FXCollections.observableArrayList(list);
		table_wyksztalcenie.setItems(null);
		table_wyksztalcenie.setItems(data);
    }
    public void editCells() {
		editUczelniaCell();
		editDataRozpCell();
		editDataZakCell();
		editTytulCell();
	}

	private void editUczelniaCell() {
		col_uczelnia.setCellFactory(TextFieldTableCell.forTableColumn());
		col_uczelnia.setOnEditCommit(new EventHandler<CellEditEvent<TabWyksztalcenie, String>>() {
			@Override
			public void handle(CellEditEvent<TabWyksztalcenie, String> t) {
				((TabWyksztalcenie) t.getTableView().getItems().get(t.getTablePosition().getRow())).setUczelnia(t.getNewValue());
				TabWyksztalcenie selectedItem = table_wyksztalcenie.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void editDataRozpCell() {
		col_data_rozp.setCellFactory(TextFieldTableCell.forTableColumn());
		col_data_rozp.setOnEditCommit(new EventHandler<CellEditEvent<TabWyksztalcenie, String>>() {
			@Override
			public void handle(CellEditEvent<TabWyksztalcenie, String> t) {
				((TabWyksztalcenie) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDataRozp(t.getNewValue());
				TabWyksztalcenie selectedItem = table_wyksztalcenie.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void editDataZakCell() {
		col_data_zak.setCellFactory(TextFieldTableCell.forTableColumn());
		col_data_zak.setOnEditCommit(new EventHandler<CellEditEvent<TabWyksztalcenie, String>>() {
			@Override
			public void handle(CellEditEvent<TabWyksztalcenie, String> t) {
				((TabWyksztalcenie) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDataZak(t.getNewValue());
				TabWyksztalcenie selectedItem = table_wyksztalcenie.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void editTytulCell() {
		col_tytul.setCellFactory(TextFieldTableCell.forTableColumn());
		col_tytul.setOnEditCommit(new EventHandler<CellEditEvent<TabWyksztalcenie, String>>() {
			@Override
			public void handle(CellEditEvent<TabWyksztalcenie, String> t) {
				((TabWyksztalcenie) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTytul(t.getNewValue());
				TabWyksztalcenie selectedItem = table_wyksztalcenie.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void updateCell(TabWyksztalcenie selectedItem) {
		adminTabWyksztalcenieService.update(selectedItem);
	}
}
