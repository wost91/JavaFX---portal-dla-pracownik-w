package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.pracownicy.Main;
import pl.pwn.reaktor.pracownicy.model.ZestTytulPensja;
import pl.pwn.reaktor.pracownicy.model.ZestTytulPensjaFilter;
import pl.pwn.reaktor.pracownicy.service.AdminZestTytulPensjaService;

public class AdminZestTytulPensjaController extends ControllerTemplate{

    @FXML
    private TableView<ZestTytulPensja> table_tytul_a_pensja;

    @FXML
    private TableColumn<ZestTytulPensja, String> col_tytul;

    @FXML
    private TableColumn<ZestTytulPensja, Long> col_liczebnosc;

    @FXML
    private TableColumn<ZestTytulPensja, Long> col_srednia;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_liczebnosc;

    @FXML
    private TextField tf_filter_srednia;

    @FXML
    private ComboBox<String> cmb_filter_tytul;

    @FXML
    private Button btn_filtruj;

    @FXML
    public void a_usun(MouseEvent event) {    	
    }
    
    private AdminZestTytulPensjaService adminZestTytulPensjaService;

	ObservableList<String> tytul = FXCollections.observableArrayList("Tytu³:", "licencjat", "in¿ynier", "magister","doktor");
	

	public void initialize() {
		cmb_filter_tytul.setItems(tytul);
		
		fillTableData();

		setCellValue();
	}

	public void fillTableData() {
		adminZestTytulPensjaService = new AdminZestTytulPensjaService();
		List<ZestTytulPensja> kryteria = (List<ZestTytulPensja>) adminZestTytulPensjaService.getAll();

		ObservableList<ZestTytulPensja> data = FXCollections.observableArrayList(kryteria);
		table_tytul_a_pensja.setItems(null);
		table_tytul_a_pensja.setItems(data);
	}

	public void setCellValue() {

		col_tytul.setCellValueFactory(new PropertyValueFactory<>("tytul"));
		col_liczebnosc.setCellValueFactory(new PropertyValueFactory<>("liczebnosc"));
		col_srednia.setCellValueFactory(new PropertyValueFactory<>("srednia"));
		}
    @FXML
    void select(MouseEvent event) {
    	String tytulValue = cmb_filter_tytul.getValue();
		String liczebnoscValue = tf_filter_liczebnosc.getText();
		String sredniaValue = tf_filter_srednia.getText();
				
		ZestTytulPensjaFilter filter = new ZestTytulPensjaFilter(tytulValue,liczebnoscValue,sredniaValue);
		List<ZestTytulPensja> list = adminZestTytulPensjaService.filter(filter);

		ObservableList<ZestTytulPensja> data = FXCollections.observableArrayList(list);
		table_tytul_a_pensja.setItems(null);
		table_tytul_a_pensja.setItems(data);
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