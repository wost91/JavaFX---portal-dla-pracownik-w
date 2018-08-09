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
import pl.pwn.reaktor.pracownicy.model.TabKwalifikacja;
import pl.pwn.reaktor.pracownicy.model.TabKwalifikacjaFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabKwalifikacjaService;

public class AdminTabKwalifikacjaController extends ControllerTemplate{

    @FXML
    private TableView<TabKwalifikacja> table_kwalifikacja;

    @FXML
    private TableColumn<TabKwalifikacja, Long> col_id;

    @FXML
    private TableColumn<TabKwalifikacja, String> col_kwalifikacja;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_kwalifikacja;

    @FXML
    private Button btn_filtruj;

    @FXML
    private Button btn_usun;
   
    public boolean condition1() {
    	return Objects.isNull(table_kwalifikacja.getSelectionModel())
				|| Objects.isNull(table_kwalifikacja.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		long id = table_kwalifikacja.getSelectionModel().getSelectedItem().getId();
		adminTabKwalifikacjaService.delete(id);
	}
    
    private AdminTabKwalifikacjaService adminTabKwalifikacjaService;

	public TableView<TabKwalifikacja> init(){
    	return table_kwalifikacja;
    }

	public void fillTableData() {
		adminTabKwalifikacjaService = new AdminTabKwalifikacjaService();
		List<TabKwalifikacja> kryteria = (List<TabKwalifikacja>) adminTabKwalifikacjaService.getAll();

		ObservableList<TabKwalifikacja> data = FXCollections.observableArrayList(kryteria);
		table_kwalifikacja.setItems(null);
		table_kwalifikacja.setItems(data);
	}

	public void setCellValue() {

		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_kwalifikacja.setCellValueFactory(new PropertyValueFactory<>("kwalifikacja"));
		}
    @FXML
    void select(MouseEvent event) {
    	String kwalifikacjaValue = tf_filter_kwalifikacja.getText();
								
		TabKwalifikacjaFilter filter = new TabKwalifikacjaFilter(kwalifikacjaValue);
		List<TabKwalifikacja> list = adminTabKwalifikacjaService.filter(filter);

		ObservableList<TabKwalifikacja> data = FXCollections.observableArrayList(list);
		table_kwalifikacja.setItems(null);
		table_kwalifikacja.setItems(data);
    }
    public void editCells() {
		editKwalifikacjaCell();
		}

	private void editKwalifikacjaCell() {
		col_kwalifikacja.setCellFactory(TextFieldTableCell.forTableColumn());
		col_kwalifikacja.setOnEditCommit(new EventHandler<CellEditEvent<TabKwalifikacja, String>>() {
			@Override
			public void handle(CellEditEvent<TabKwalifikacja, String> t) {
				((TabKwalifikacja) t.getTableView().getItems().get(t.getTablePosition().getRow())).setKwalifikacja(t.getNewValue());
				TabKwalifikacja selectedItem = table_kwalifikacja.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void updateCell(TabKwalifikacja selectedItem) {
		adminTabKwalifikacjaService.update(selectedItem);
			}
}
