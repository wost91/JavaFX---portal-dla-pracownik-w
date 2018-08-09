package pl.pwn.reaktor.pracownicy.controller;

import java.io.IOException;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.pracownicy.Main;
import pl.pwn.reaktor.pracownicy.service.LoginService;

public class LoginController {

	public static String username = null;

	@FXML
	private Button btn_login;

	@FXML
	private TextField tf_login;

	@FXML
	private TextField tf_password;
	
	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		LoginController.username = username;
	}

	@FXML
	void login(MouseEvent event) throws IOException {

		String login = tf_login.getText();
		String password = tf_password.getText();
		boolean isLogin = loginService.login(login, password);
		if (isLogin) {
			
			boolean isAdmin = loginService.admin(login);
			if(isAdmin) {
				Parent parent = FXMLLoader.load(getClass().getResource("/view/MenuViewAdmin.fxml"));
				Scene scene = new Scene(parent);
				Main.getPrimaryStage().setScene(scene);
				setUsername(login);
			} else {
				Parent parent = FXMLLoader.load(getClass().getResource("/view/MenuViewUser.fxml"));
				Scene scene = new Scene(parent);
				Main.getPrimaryStage().setScene(scene);
				setUsername(login);
			}
			
		} else {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("Error");
			error.setContentText("Enter valid login/password");
			error.setTitle("Wrong login or password");
			error.show();
		}
		
	}

	private LoginService loginService;

	public void initialize() {
		loginService = new LoginService();
	}

}
