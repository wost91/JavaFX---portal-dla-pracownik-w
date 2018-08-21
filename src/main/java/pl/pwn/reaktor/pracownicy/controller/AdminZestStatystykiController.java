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
import pl.pwn.reaktor.pracownicy.model.ZestOrganizacja;
import pl.pwn.reaktor.pracownicy.model.ZestOrganizacjaFilter;
import pl.pwn.reaktor.pracownicy.model.ZestStatystyki;
import pl.pwn.reaktor.pracownicy.model.ZestStatystykiFilter;
import pl.pwn.reaktor.pracownicy.service.AdminZestOrganizacjaService;
import pl.pwn.reaktor.pracownicy.service.AdminZestStatystykiService;

public class AdminZestStatystykiController extends ControllerTemplate{

    @FXML
    private TableView<ZestStatystyki> table_statystyki;

    @FXML
    private TableColumn<ZestStatystyki, String> col_dzial;

    @FXML
    private TableColumn<ZestStatystyki, Long> col_budzet;

    @FXML
    private TableColumn<ZestStatystyki, Long> col_liczba_prac;
    
    @FXML
    private TableColumn<ZestStatystyki, Long> col_budzet_na_prac;

    @FXML
    private TableColumn<ZestStatystyki, Long> col_sr_pensja;

    @FXML
    private TableColumn<ZestStatystyki, Long> col_suma;

    @FXML
    private TableColumn<ZestStatystyki, Long> col_udzial;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private TextField tf_filter_budzet;

    @FXML
    private TextField tf_filter_liczba_prac;

    @FXML
    private ComboBox<String> cmb_filter_dzial;

    @FXML
    private Button btn_filtruj;

    @FXML
    private TextField tf_filter_budzet_na_prac;

    @FXML
    private TextField tf_filter_srednia;

    @FXML
    private TextField tf_filter_udzial_w_budzecie;

    @FXML
    private TextField tf_filter_suma;

    @FXML
    public void a_usun(MouseEvent event) {    	
    }
    
    private AdminZestStatystykiService adminZestStatystykiService;

   	ObservableList<String> dzial = FXCollections.observableArrayList("Dzia³:", "IT", "sprzeda¿", "obs³uga klienta","administracja");
   	

   	public void initialize() {
   		cmb_filter_dzial.setItems(dzial);
   		
   		fillTableData();

   		setCellValue();
   	}

   	public void fillTableData() {
   		adminZestStatystykiService = new AdminZestStatystykiService();
   		List<ZestStatystyki> kryteria = (List<ZestStatystyki>) adminZestStatystykiService.getAll();

   		ObservableList<ZestStatystyki> data = FXCollections.observableArrayList(kryteria);
   		table_statystyki.setItems(null);
   		table_statystyki.setItems(data);
   	}

   	public void setCellValue() {

   		col_dzial.setCellValueFactory(new PropertyValueFactory<>("dzial"));
   		col_budzet.setCellValueFactory(new PropertyValueFactory<>("budzet"));
   		col_liczba_prac.setCellValueFactory(new PropertyValueFactory<>("liczbaPracownikow"));
   		col_budzet_na_prac.setCellValueFactory(new PropertyValueFactory<>("budzetNaPracownika"));
   		col_sr_pensja.setCellValueFactory(new PropertyValueFactory<>("sredniaPensja"));
   		col_suma.setCellValueFactory(new PropertyValueFactory<>("sumaPensji"));
   		col_udzial.setCellValueFactory(new PropertyValueFactory<>("udzialPensji"));
   		}
    @FXML
    void select(MouseEvent event) {
    	String dzialValue = cmb_filter_dzial.getValue();
		String budzetValue = tf_filter_budzet.getText();
		String liczbaPracValue = tf_filter_liczba_prac.getText();
		String budzetNaPracownikaValue = tf_filter_budzet_na_prac.getText();
		String sredniaPensjaValue = tf_filter_srednia.getText();
		String sumaPensjiValue = tf_filter_suma.getText();
		String udzialPensjiValue = tf_filter_udzial_w_budzecie.getText();
		
		ZestStatystykiFilter filter = new ZestStatystykiFilter(dzialValue,budzetValue,liczbaPracValue,budzetNaPracownikaValue,sredniaPensjaValue,sumaPensjiValue,udzialPensjiValue);
		List<ZestStatystyki> list = (List<ZestStatystyki>) adminZestStatystykiService.filter(filter);

		ObservableList<ZestStatystyki> data = FXCollections.observableArrayList(list);
		table_statystyki.setItems(null);
		table_statystyki.setItems(data);
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
