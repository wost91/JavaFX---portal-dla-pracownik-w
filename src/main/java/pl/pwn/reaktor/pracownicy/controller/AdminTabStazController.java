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
import pl.pwn.reaktor.pracownicy.model.TabStaz;
import pl.pwn.reaktor.pracownicy.model.TabStazFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabStazService;

public class AdminTabStazController extends ControllerTemplate{

    @FXML
    private TableView<TabStaz> table_staz;

    @FXML
    private TableColumn<TabStaz, Long> col_id;

    @FXML
    private TableColumn<TabStaz, String> col_staz;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_staz;

    @FXML
    private Button btn_filtruj;

    @FXML
    private Button btn_usun;
    
    public boolean condition1() {
    	return Objects.isNull(table_staz.getSelectionModel())
				|| Objects.isNull(table_staz.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long id = table_staz.getSelectionModel().getSelectedItem().getId();
		adminTabStazService.delete(id);
	}
    
    private AdminTabStazService adminTabStazService;

    public TableView<TabStaz> init(){
    	return table_staz;
    }
    
    public void fillTableData() {
   		adminTabStazService = new AdminTabStazService();
   		List<TabStaz> kryteria = (List<TabStaz>) adminTabStazService.getAll();

   		ObservableList<TabStaz> data = FXCollections.observableArrayList(kryteria);
   		table_staz.setItems(null);
   		table_staz.setItems(data);
   	}

    public void setCellValue() {

   		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
   		col_staz.setCellValueFactory(new PropertyValueFactory<>("staz"));
   		}
    @FXML
    void select(MouseEvent event) {
    	String dzialValue = tf_filter_staz.getText();
		
		TabStazFilter filter = new TabStazFilter(dzialValue);
		List<TabStaz> list = adminTabStazService.filter(filter);

		ObservableList<TabStaz> data = FXCollections.observableArrayList(list);
		table_staz.setItems(null);
		table_staz.setItems(data);
    }
    public void editCells() {
		editStazCell();
		}

	private void editStazCell() {
		col_staz.setCellFactory(TextFieldTableCell.forTableColumn());
		col_staz.setOnEditCommit(new EventHandler<CellEditEvent<TabStaz, String>>() {
			@Override
			public void handle(CellEditEvent<TabStaz, String> t) {
				((TabStaz) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStaz(t.getNewValue());
				TabStaz selectedItem = table_staz.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
		private void updateCell(TabStaz selectedItem) {
			adminTabStazService.update(selectedItem);
		}
}

