package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;
import java.util.List;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import pl.pwn.reaktor.pracownicy.Main;
import pl.pwn.reaktor.pracownicy.model.ZestPracownicy;
import pl.pwn.reaktor.pracownicy.model.ZestPracownicyFilter;
import pl.pwn.reaktor.pracownicy.service.AdminZestPracownicyService;

public class AdminZestPracownicyController extends ControllerTemplate{

    @FXML
    private TableView<ZestPracownicy> table_pracownicy;

    @FXML
    private TableColumn<ZestPracownicy, Long> col_id;

    @FXML
    private TableColumn<ZestPracownicy, String> col_imie;

    @FXML
    private TableColumn<ZestPracownicy, String> col_nazwisko;

    @FXML
    private TableColumn<ZestPracownicy, String> col_dzial;

    @FXML
    private TableColumn<ZestPracownicy, String> col_stanowisko;

    @FXML
    private TableColumn<ZestPracownicy, Long> col_pensja;

    @FXML
    private TableColumn<ZestPracownicy, Long> col_staz;

    @FXML
    private TableColumn<ZestPracownicy, String> col_kwalifikacja;

    @FXML
    private TableColumn<ZestPracownicy, Long> col_premia;

    @FXML
    private TableColumn<ZestPracownicy, Long> col_suma;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_id;

    @FXML
    private TextField tf_filter_imie;

    @FXML
    private TextField tf_filter_nazwisko;

    @FXML
    private ComboBox<String> cmb_filter_dzial;

    @FXML
    private ComboBox<String> cmb_filter_stanowisko;

    @FXML
    private Button btn_filtruj;

    @FXML
    private ComboBox<String> cmb_filter_kwalifikacja;

    @FXML
    private TextField tf_filter_pensja;

    @FXML
    private TextField tf_filter_staz;

    @FXML
    private TextField tf_filter_premia;

    @FXML
    private TextField tf_filter_suma;

    @FXML
    public void a_usun(MouseEvent event) {    	
    }

    private AdminZestPracownicyService adminZestPracownicyService;

	ObservableList<String> dzial = FXCollections.observableArrayList("Dzia³:", "IT", "sprzeda¿", "obs³uga klienta","administracja");
	ObservableList<String> stanowisko = FXCollections.observableArrayList("Stanowisko:", "specjalista", "st. specjalista","mened¿er");
	ObservableList<String> kwalifikacja = FXCollections.observableArrayList("Kwalifikacja:", "tak", "nie");

	public void initialize() {
		cmb_filter_dzial.setItems(dzial);
		cmb_filter_stanowisko.setItems(stanowisko);
		cmb_filter_kwalifikacja.setItems(kwalifikacja);

		fillTableData();

		setCellValue();
		
		}

	public void fillTableData() {
		adminZestPracownicyService = new AdminZestPracownicyService();
		List<ZestPracownicy> kryteria = (List<ZestPracownicy>) adminZestPracownicyService.getAll();

		ObservableList<ZestPracownicy> data = FXCollections.observableArrayList(kryteria);
		table_pracownicy.setItems(null);
		table_pracownicy.setItems(data);
	}

	public void setCellValue() {

		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
		col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		col_dzial.setCellValueFactory(new PropertyValueFactory<>("dzial"));
		col_stanowisko.setCellValueFactory(new PropertyValueFactory<>("stanowisko"));
		col_pensja.setCellValueFactory(new PropertyValueFactory<>("pensja"));
		col_staz.setCellValueFactory(new PropertyValueFactory<>("staz"));
		col_kwalifikacja.setCellValueFactory(new PropertyValueFactory<>("kwalifikacja"));
		col_premia.setCellValueFactory(new PropertyValueFactory<>("premia"));
		col_suma.setCellValueFactory(new PropertyValueFactory<>("suma"));
		}
    
    @FXML
    void select(MouseEvent event) {

    	String idValue = tf_filter_id.getText();
		String imieValue = tf_filter_imie.getText();
		String nazwiskoValue = tf_filter_nazwisko.getText();
		String dzialValue = cmb_filter_dzial.getValue();
		String stanowiskoValue = cmb_filter_stanowisko.getValue();
		String pensjaValue = tf_filter_pensja.getText();
		String stazValue = tf_filter_staz.getText();
		String kwalifikacjaValue = cmb_filter_kwalifikacja.getValue();
		String premiaValue = tf_filter_premia.getText();
		String sumaValue = tf_filter_suma.getText();

		ZestPracownicyFilter filter = new ZestPracownicyFilter(idValue,imieValue,nazwiskoValue,dzialValue,stanowiskoValue,pensjaValue,stazValue,kwalifikacjaValue,premiaValue,sumaValue);
		List<ZestPracownicy> list = adminZestPracownicyService.filter(filter);

		ObservableList<ZestPracownicy> data = FXCollections.observableArrayList(list);
		table_pracownicy.setItems(null);
		table_pracownicy.setItems(data);
    }

	@Override
	public boolean condition1() {
		return false;
	}

	@Override
	public void condition2() {		
	}
	
	@Override
	public TableView<?> init() {
		return null;
	}	

	@Override
	public void editCells() {
	}    
}