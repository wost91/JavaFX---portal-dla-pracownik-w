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
import pl.pwn.reaktor.pracownicy.model.TabPremia;
import pl.pwn.reaktor.pracownicy.model.TabPremiaFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabPremiaService;

public class AdminTabPremiaController extends ControllerTemplate{

    @FXML
    private TableView<TabPremia> table_premia;

    @FXML
    private TableColumn<TabPremia, Long> col_staz;

    @FXML
    private TableColumn<TabPremia, String> col_premia;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_premia;

    @FXML
    private Button btn_filtruj;

    @FXML
    private Button btn_usun;
    
    public boolean condition1() {
    	return Objects.isNull(table_premia.getSelectionModel())
				|| Objects.isNull(table_premia.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long staz = table_premia.getSelectionModel().getSelectedItem().getStaz();
		adminTabPremiaService.delete(staz);
	}
    
    private AdminTabPremiaService adminTabPremiaService;
    
    public TableView<TabPremia> init(){
    	return table_premia;
    }

    public void fillTableData() {
   		adminTabPremiaService = new AdminTabPremiaService();
   		List<TabPremia> kryteria = (List<TabPremia>) adminTabPremiaService.getAll();

   		ObservableList<TabPremia> data = FXCollections.observableArrayList(kryteria);
   		table_premia.setItems(null);
   		table_premia.setItems(data);
   	}

    public void setCellValue() {

   		col_staz.setCellValueFactory(new PropertyValueFactory<>("staz"));
   		col_premia.setCellValueFactory(new PropertyValueFactory<>("premia"));
   		}
    @FXML
    void select(MouseEvent event) {
    	String premiaValue = tf_filter_premia.getText();
		
		TabPremiaFilter filter = new TabPremiaFilter(premiaValue);
		List<TabPremia> list = (List<TabPremia>) adminTabPremiaService.filter(filter);

		ObservableList<TabPremia> data = FXCollections.observableArrayList(list);
		table_premia.setItems(null);
		table_premia.setItems(data);
    }
    public void editCells() {
		editPremiaCell();
		}

	private void editPremiaCell() {
		col_premia.setCellFactory(TextFieldTableCell.forTableColumn());
		col_premia.setOnEditCommit(new EventHandler<CellEditEvent<TabPremia, String>>() {
			@Override
			public void handle(CellEditEvent<TabPremia, String> t) {
				((TabPremia) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPremia(t.getNewValue());
				TabPremia selectedItem = table_premia.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
		private void updateCell(TabPremia selectedItem) {
			adminTabPremiaService.update(selectedItem);
		}    
}
