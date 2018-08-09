package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.pracownicy.Main;
import pl.pwn.reaktor.pracownicy.model.ZestHistoria;
import pl.pwn.reaktor.pracownicy.model.ZestHistoriaFilter;
import pl.pwn.reaktor.pracownicy.service.AdminZestHistoriaService;

public class AdminZestHistoriaController extends ControllerTemplate{

    @FXML
    private TableView<ZestHistoria> table_historia;

    @FXML
    private TableColumn<ZestHistoria, String> col_imie;

    @FXML
    private TableColumn<ZestHistoria, String> col_nazwisko;

    @FXML
    private TableColumn<ZestHistoria, String> col_poprz_pracodawca;

    @FXML
    private TableColumn<ZestHistoria, Long> col_doswiadczenie;

    @FXML
    private TableColumn<ZestHistoria, Long> col_pensja;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_imie;

    @FXML
    private TextField tf_filter_nazwisko;

    @FXML
    private Button btn_filtruj;

    @FXML
    private TextField tf_filter_pensja;

    @FXML
    private TextField tf_filter_poprz_prac;

    @FXML
    private TextField tf_filter_doswiadczenie;
    
    @FXML
    public void a_usun(MouseEvent event) {    	
    }
    
    private AdminZestHistoriaService adminZestHistoriaService;

	public void initialize() {
		fillTableData();
		setCellValue();
	}
	public void fillTableData() {
		adminZestHistoriaService = new AdminZestHistoriaService();
		List<ZestHistoria> kryteria = (List<ZestHistoria>) adminZestHistoriaService.getAll();

		ObservableList<ZestHistoria> data = FXCollections.observableArrayList(kryteria);
		table_historia.setItems(null);
		table_historia.setItems(data);
	}

	public void setCellValue() {

		col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
		col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		col_poprz_pracodawca.setCellValueFactory(new PropertyValueFactory<>("poprzPracodawca"));
		col_doswiadczenie.setCellValueFactory(new PropertyValueFactory<>("doswiadczenie"));
		col_pensja.setCellValueFactory(new PropertyValueFactory<>("pensja"));
		}
    @FXML
    void select(MouseEvent event) {
    	String imieValue = tf_filter_imie.getText();
		String nazwiskoValue = tf_filter_nazwisko.getText();
		String poprzPracodawcaValue = tf_filter_poprz_prac.getText();
		String doswiadczenieValue = tf_filter_doswiadczenie.getText();
		String pensjaValue = tf_filter_pensja.getText();
		
		ZestHistoriaFilter filter = new ZestHistoriaFilter(imieValue,nazwiskoValue,poprzPracodawcaValue,doswiadczenieValue,pensjaValue);
		List<ZestHistoria> list = adminZestHistoriaService.filter(filter);

		ObservableList<ZestHistoria> data = FXCollections.observableArrayList(list);
		table_historia.setItems(null);
		table_historia.setItems(data);
    }
	@Override
	public TableView<?> init() {
		return null;
	}
	@Override
	public void editCells() {	
	}
	@Override
	public boolean condition1() {
		return false;
	}
	@Override
	public void condition2() {
	}
}
