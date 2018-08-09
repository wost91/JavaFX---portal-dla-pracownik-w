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
import pl.pwn.reaktor.pracownicy.service.AdminZestOrganizacjaService;

public class AdminZestOrganizacjaController extends ControllerTemplate{

    @FXML
    private TableView<ZestOrganizacja> table_organizacja;

    @FXML
    private TableColumn<ZestOrganizacja, String> col_dzial;

    @FXML
    private TableColumn<ZestOrganizacja, Long> col_budzet;

    @FXML
    private TableColumn<ZestOrganizacja, Long> col_liczba_prac;

    @FXML
    private TableColumn<ZestOrganizacja, String> col_dyrektor;

    @FXML
    private Button btn_wstecz;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private ComboBox<String> cmb_filter_dzial;

    @FXML
    private Button btn_filtruj;

    @FXML
    private TextField tf_filter_budzet;

    @FXML
    private TextField tf_filter_liczba_prac;

    @FXML
    private TextField tf_filter_dyrektor;

    @FXML
    public void a_usun(MouseEvent event) {    	
    }

    private AdminZestOrganizacjaService adminZestOrganizacjaService;

	ObservableList<String> dzial = FXCollections.observableArrayList("Dzia³:", "IT", "sprzeda¿", "obs³uga klienta","administracja");
	

	public void initialize() {
		cmb_filter_dzial.setItems(dzial);
		
		fillTableData();

		setCellValue();
		
	}

	public void fillTableData() {
		adminZestOrganizacjaService = new AdminZestOrganizacjaService();
		List<ZestOrganizacja> kryteria = (List<ZestOrganizacja>) adminZestOrganizacjaService.getAll();

		ObservableList<ZestOrganizacja> data = FXCollections.observableArrayList(kryteria);
		table_organizacja.setItems(null);
		table_organizacja.setItems(data);
	}

	public void setCellValue() {

		col_dzial.setCellValueFactory(new PropertyValueFactory<>("dzial"));
		col_budzet.setCellValueFactory(new PropertyValueFactory<>("budzet"));
		col_liczba_prac.setCellValueFactory(new PropertyValueFactory<>("liczbaPracownikow"));
		col_dyrektor.setCellValueFactory(new PropertyValueFactory<>("dyrektor"));
		}
    @FXML
    void select(MouseEvent event) {

    	String dzialValue = cmb_filter_dzial.getValue();
		String budzetValue = tf_filter_budzet.getText();
		String liczbaPracValue = tf_filter_liczba_prac.getText();
		String dyrektorValue = tf_filter_dyrektor.getText();
		
		ZestOrganizacjaFilter filter = new ZestOrganizacjaFilter(dzialValue,budzetValue,liczbaPracValue,dyrektorValue);
		List<ZestOrganizacja> list = adminZestOrganizacjaService.filter(filter);

		ObservableList<ZestOrganizacja> data = FXCollections.observableArrayList(list);
		table_organizacja.setItems(null);
		table_organizacja.setItems(data);
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