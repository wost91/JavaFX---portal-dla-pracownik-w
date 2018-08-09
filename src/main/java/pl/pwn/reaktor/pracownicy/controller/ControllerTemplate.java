package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.pracownicy.Main;

public abstract class ControllerTemplate {

	@FXML
    public void a_usun(MouseEvent event) {
    	if (condition1()) {

			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("ERROR");
			error.setContentText("Nale¿y najpierw wybraæ wiersz");
			error.setTitle("Nie wybrano wiersza!");
			error.show();
			return;
		}
    	condition2();
		fillTableData();
    }
	public abstract boolean condition1();
	public abstract void condition2();
	public abstract void fillTableData();
		
	 @FXML
	 public final void a_wstecz(MouseEvent event) throws IOException {
	    	Parent parent = FXMLLoader.load(getClass().getResource("/view/MenuViewAdmin.fxml"));
			Scene scene = new Scene(parent);
			Main.getPrimaryStage().setScene(scene);
	    }

	 @FXML
	 public final void a_wyloguj(MouseEvent event) throws IOException {
	    	Parent parent = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
			Scene scene = new Scene(parent);
			Main.getPrimaryStage().setScene(scene);
	    }
	 public void initialize() {
			fillTableData();
			setCellValue();		
			init().setEditable(true);
			editCells();
		}
	 public abstract TableView<?> init();
	 public abstract void setCellValue();
	 public abstract void editCells();	 
}
