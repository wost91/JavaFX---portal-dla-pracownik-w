package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import org.hibernate.Query;

public class LoginReceiver implements Receiver{
	
	public static List<?> list;
	private String login;
	private String password;
	
	public LoginReceiver(String login,String password) {
		this.login=login;
		this.password=password;
	}
	public void action() {
		
		Query query = ServiceCommand.session.createQuery("FROM Logowanie WHERE login=:login and haslo=:pass");
		query.setString("login", login);
		query.setString("pass", password);
		list = query.list();		
	}	
}