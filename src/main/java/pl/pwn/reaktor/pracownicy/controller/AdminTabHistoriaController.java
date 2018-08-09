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
import pl.pwn.reaktor.pracownicy.service.AdminTabHistoriaService;

public class AdminTabHistoriaController extends ControllerTemplate{

    @FXML
    private TableView<TabHistoria> table_historia;

    @FXML
    private TableColumn<TabHistoria, Long> col_id;

    @FXML
    private TableColumn<TabHistoria, String> col_poprz_pracodawca;

    @FXML
    private TableColumn<TabHistoria, String> col_data_zatr;

    @FXML
    private TableColumn<TabHistoria, String> col_data_odejscia;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private Button btn_filtruj;

    @FXML
    private TextField tf_filter_data_odejscia;

    @FXML
    private TextField tf_filter_poprz_prac;

    @FXML
    private TextField tf_filter_data_zatr;

    @FXML
    private Button btn_usun;

    public boolean condition1() {
    	return Objects.isNull(table_historia.getSelectionModel())
				|| Objects.isNull(table_historia.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long id = table_historia.getSelectionModel().getSelectedItem().getId();
		adminTabHistoriaService.delete(id);
	}    

    private AdminTabHistoriaService adminTabHistoriaService;

	public TableView<TabHistoria> init(){
	    	return table_historia;
	    }

	public void fillTableData() {
		adminTabHistoriaService = new AdminTabHistoriaService();
		List<TabHistoria> kryteria = (List<TabHistoria>) adminTabHistoriaService.getAll();

		ObservableList<TabHistoria> data = FXCollections.observableArrayList(kryteria);
		table_historia.setItems(null);
		table_historia.setItems(data);
	}

	public void setCellValue() {

		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_poprz_pracodawca.setCellValueFactory(new PropertyValueFactory<>("poprzPracodawca"));
		col_data_zatr.setCellValueFactory(new PropertyValueFactory<>("dataZatr"));
		col_data_odejscia.setCellValueFactory(new PropertyValueFactory<>("dataOdejscia"));
	   }
    @FXML
    void select(MouseEvent event) {
    	String poprzPracodawcaValue = tf_filter_poprz_prac.getText();
		String dataZatrValue = tf_filter_data_zatr.getText();
		String dataOdejsciaValue = tf_filter_data_odejscia.getText();
						
		TabHistoriaFilter filter = new TabHistoriaFilter(poprzPracodawcaValue,dataZatrValue,dataOdejsciaValue);
		List<TabHistoria> list = adminTabHistoriaService.filter(filter);

		ObservableList<TabHistoria> data = FXCollections.observableArrayList(list);
		table_historia.setItems(null);
		table_historia.setItems(data);
    }
    public void editCells() {
			editPoprzPracodawcaCell();
			editDataZatrCell();
			editDataOdejsciaCell();
		}

		private void editPoprzPracodawcaCell() {
			col_poprz_pracodawca.setCellFactory(TextFieldTableCell.forTableColumn());
			col_poprz_pracodawca.setOnEditCommit(new EventHandler<CellEditEvent<TabHistoria, String>>() {
				@Override
				public void handle(CellEditEvent<TabHistoria, String> t) {
					((TabHistoria) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPoprzPracodawca(t.getNewValue());
					TabHistoria selectedItem = table_historia.getSelectionModel().getSelectedItem();
					updateCell(selectedItem);
				}
			});
		}
		private void editDataZatrCell() {
			col_data_zatr.setCellFactory(TextFieldTableCell.forTableColumn());
			col_data_zatr.setOnEditCommit(new EventHandler<CellEditEvent<TabHistoria, String>>() {
				@Override
				public void handle(CellEditEvent<TabHistoria, String> t) {
					((TabHistoria) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDataZatr(t.getNewValue());
					TabHistoria selectedItem = table_historia.getSelectionModel().getSelectedItem();
					updateCell(selectedItem);
				}
			});
		}
		private void editDataOdejsciaCell() {
			col_data_odejscia.setCellFactory(TextFieldTableCell.forTableColumn());
			col_data_odejscia.setOnEditCommit(new EventHandler<CellEditEvent<TabHistoria, String>>() {
				@Override
				public void handle(CellEditEvent<TabHistoria, String> t) {
					((TabHistoria) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDataOdejscia(t.getNewValue());
					TabHistoria selectedItem = table_historia.getSelectionModel().getSelectedItem();
					updateCell(selectedItem);
				}
			});
		}
		private void updateCell(TabHistoria selectedItem) {
	adminTabHistoriaService.update(selectedItem);
		}
    }