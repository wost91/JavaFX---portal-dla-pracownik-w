package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pl.pwn.reaktor.pracownicy.Main;

public class MenuAdminController {

    @FXML
    private AnchorPane table_pracownicy;

    @FXML
    private MenuBar menu;

    @FXML
    private Menu menu_tabele;

    @FXML
    private MenuItem m_tabele_dyr;

    @FXML
    private MenuItem m_tabele_dzial;

    @FXML
    private MenuItem m_tabele_historia;

    @FXML
    private MenuItem m_tabele_kwalifikacja;

    @FXML
    private MenuItem m_tabele_logowanie;

    @FXML
    private MenuItem m_tabele_pracownicy;

    @FXML
    private MenuItem m_tabele_prac_dzial;

    @FXML
    private MenuItem m_tabele_prac_stanowisko;

    @FXML
    private MenuItem m_tabele_stanowisko_pensja;

    @FXML
    private MenuItem m_tabele_staz;

    @FXML
    private MenuItem m_tabele_wyksztalcenie;

    @FXML
    private MenuItem m_tabele_wysokosc_premii;

    @FXML
    private MenuItem m_zest_pracownicy;

    @FXML
    private MenuItem m_zest_organizacja;

    @FXML
    private MenuItem m_zest_statystyki;

    @FXML
    private MenuItem m_zest_historia;

    @FXML
    private MenuItem m_zest_tytul_a_pensja;

    @FXML
    private MenuItem m_info;

    @FXML
    private Button btn_wyloguj;

   @FXML
    void a_m_info(ActionEvent event) {
	   Alert about = new Alert(AlertType.INFORMATION);
		about.setTitle("Informacja");
		about.setHeaderText("O WorkWorld");
		about.setContentText("WorkWorld to aplikacja s³u¿¹ca do obs³ugi pracowniczych baz danych. Powsta³a ona w ramach kursu Back-end Developer, prowadzonego przez Reaktor PWN. \nAutor: Wojciech Staniszewski");
		about.show();
    }

    @FXML
    void a_m_tabele_dyr(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabDyrektorzyView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_dzial(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabDzialView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_historia(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabHistoriaView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_kwalifikacja(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabKwalifikacjaView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_logowanie(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabLogowanieView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_prac_dzial(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabPracownikDzialView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_prac_stanowisko(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabPracownikStanowiskoView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_pracownicy(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabPracownicyView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_stanowisko_pensja(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabStanowiskoPensjaView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_staz(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabStazView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_wyksztalcenie(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabWyksztalcenieView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_tabele_wysokosc_premii(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminTabPremiaView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_zest_organizacja(ActionEvent event) throws IOException {

    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminZestOrganizacjaView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_zest_pracownicy(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminZestPracownicyView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);

    }

    @FXML
    void a_m_zest_tytul_a_historia(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminZestHistoriaView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);

    }

    @FXML
    void a_m_zest_tytul_a_pensja(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminZestTytulPensjaView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_zest_tytul_a_statystyki(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/AdminZestStatystykiView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_wyloguj(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

}

   
