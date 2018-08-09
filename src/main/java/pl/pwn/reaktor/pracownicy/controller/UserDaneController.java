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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.pracownicy.Main;
import pl.pwn.reaktor.pracownicy.model.ZestPracownicy;
import pl.pwn.reaktor.pracownicy.service.UserDaneService;

public class UserDaneController extends ControllerTemplate{

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
    public void a_usun(MouseEvent event) {    	
    }
    
    private UserDaneService userDaneService;
    
    public void initialize() {
		fillTableData();
		setCellValue();
	}
    
    public void fillTableData() {
    	userDaneService = new UserDaneService();
		List<ZestPracownicy> kryteria = userDaneService.getAll();

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