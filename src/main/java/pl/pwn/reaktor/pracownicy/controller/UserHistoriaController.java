package pl.pwn.reaktor.pracownicy.controller;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.pracownicy.model.ZestHistoria;
import pl.pwn.reaktor.pracownicy.service.UserHistoriaService;

public class UserHistoriaController extends ControllerTemplate{

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
    public void a_usun(MouseEvent event) {    	
    }
    
    private UserHistoriaService userHistoriaService;
    
    public void initialize() {
		fillTableData();
		setCellValue();
	}
    
    public void fillTableData() {
    	userHistoriaService = new UserHistoriaService();
		List<ZestHistoria> kryteria = userHistoriaService.getAll();

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
