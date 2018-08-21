package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import pl.pwn.reaktor.pracownicy.Main;
import pl.pwn.reaktor.pracownicy.model.TabDyrektorzy;
import pl.pwn.reaktor.pracownicy.model.TabDyrektorzyFilter;
import pl.pwn.reaktor.pracownicy.service.AdminTabDyrektorzyService;

public class AdminTabDyrektorzyController extends ControllerTemplate{

    @FXML
    private TableView<TabDyrektorzy> table_dyrektorzy;

    @FXML
    private TableColumn<TabDyrektorzy, String> col_dyrektor;

    @FXML
    private TableColumn<TabDyrektorzy, String> col_dzial;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_dyrektor;

    @FXML
    private TextField tf_filter_dzial;

    @FXML
    private Button btn_filtruj;

    @FXML
    private Button btn_usun;

    /*@FXML
    void a_usun(MouseEvent event) {
    	if (Objects.isNull(table_dyrektorzy.getSelectionModel())
				|| Objects.isNull(table_dyrektorzy.getSelectionModel().getSelectedItem())) {

			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("ERROR");
			error.setContentText("Nale¿y najpierw wybraæ wiersz");
			error.setTitle("Nie wybrano wiersza!");
			error.show();
			return;
		}

		String dyrektor = table_dyrektorzy.getSelectionModel().getSelectedItem().getDyrektor();
		adminTabDyrektorzyService.delete(dyrektor);

		fillTableData();
    }*/
    public boolean condition1() {
    	return Objects.isNull(table_dyrektorzy.getSelectionModel())
				|| Objects.isNull(table_dyrektorzy.getSelectionModel().getSelectedItem());
    }
	public void condition2() {
		String dyrektor = table_dyrektorzy.getSelectionModel().getSelectedItem().getDyrektor();
		adminTabDyrektorzyService.delete(dyrektor);
	}
   /* @FXML
    void a_wstecz(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/MenuViewAdmin.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_wyloguj(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }*/
    private AdminTabDyrektorzyService adminTabDyrektorzyService;

	/*public void initialize() {
		fillTableData();
		setCellValue();		
		table_dyrektorzy.setEditable(true);
		editCells();
	}*/
    public TableView<TabDyrektorzy> init(){
    	return table_dyrektorzy;
    }

	public void fillTableData() {
		adminTabDyrektorzyService = new AdminTabDyrektorzyService();
		List<TabDyrektorzy> kryteria = (List<TabDyrektorzy>) adminTabDyrektorzyService.getAll();

		ObservableList<TabDyrektorzy> data = FXCollections.observableArrayList(kryteria);
		table_dyrektorzy.setItems(null);
		table_dyrektorzy.setItems(data);
	}

	public void setCellValue() {

		col_dyrektor.setCellValueFactory(new PropertyValueFactory<>("dyrektor"));
		col_dzial.setCellValueFactory(new PropertyValueFactory<>("dzial"));
		}
    @FXML
    void select(MouseEvent event) {
    	String dyrektorValue = tf_filter_dyrektor.getText();
		String dzialValue = tf_filter_dzial.getText();
						
		TabDyrektorzyFilter filter = new TabDyrektorzyFilter(dyrektorValue,dzialValue);
		List<TabDyrektorzy> list = (List<TabDyrektorzy>) adminTabDyrektorzyService.filter(filter);

		ObservableList<TabDyrektorzy> data = FXCollections.observableArrayList(list);
		table_dyrektorzy.setItems(null);
		table_dyrektorzy.setItems(data);
    }
    public void editCells() {		
		editDzialCell();
	}

	private void editDzialCell() {
		col_dzial.setCellFactory(TextFieldTableCell.forTableColumn());
		col_dzial.setOnEditCommit(new EventHandler<CellEditEvent<TabDyrektorzy, String>>() {
			@Override
			public void handle(CellEditEvent<TabDyrektorzy, String> t) {
				((TabDyrektorzy) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDzial(t.getNewValue());
				TabDyrektorzy selectedItem = table_dyrektorzy.getSelectionModel().getSelectedItem();
				updateCell(selectedItem);
			}
		});
	}
	private void updateCell(TabDyrektorzy selectedItem) {
adminTabDyrektorzyService.update(selectedItem);
	}
}

