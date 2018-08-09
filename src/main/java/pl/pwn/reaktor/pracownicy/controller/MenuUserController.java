package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pl.pwn.reaktor.pracownicy.Main;

public class MenuUserController {

    @FXML
    private AnchorPane table_pracownicy;

    @FXML
    private MenuBar menu;

    @FXML
    private MenuItem m_dane;

    @FXML
    private MenuItem m_historia;

    @FXML
    private MenuItem m_info;

    @FXML
    private Button btn_wyloguj;

    @FXML
    void a_m_dane(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/UserDaneView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_historia(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/UserHistoriaView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void a_m_info(ActionEvent event) {
    	Alert about = new Alert(AlertType.INFORMATION);
		about.setTitle("Informacja");
		about.setHeaderText("O WorkWorld");
		about.setContentText("WorkWorld to aplikacja s³u¿¹ca do obs³ugi pracowniczych baz danych. Powsta³a ona w ramach kursu Back-end Developer, prowadzonego przez Reaktor PWN. \nAutor: Wojciech Staniszewski");
		about.show();
    }

    @FXML
    void a_wyloguj(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

}
