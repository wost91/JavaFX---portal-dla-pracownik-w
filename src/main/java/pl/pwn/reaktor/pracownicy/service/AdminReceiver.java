package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import org.hibernate.Query;

public class AdminReceiver implements Receiver{

	public static List<?> list;
	private String login;
	
	public AdminReceiver(String login) {
		this.login=login;
	}
public void action() {
		
	Query query = ServiceCommand.session.createQuery("FROM Logowanie WHERE login=:login");
	query.setString("login", login);
	
	list = query.list();
	}	
}
