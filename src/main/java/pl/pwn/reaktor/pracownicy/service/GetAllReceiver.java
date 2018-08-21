package pl.pwn.reaktor.pracownicy.service;

import java.util.List;

import org.hibernate.Query;

public class GetAllReceiver implements Receiver{

	private String select;
	public GetAllReceiver(String select) {
		this.select=select;
	}
	public static List<?> kryteria;
	
	public void action() {
		Query query = ServiceCommand.session.createQuery(select);
		kryteria = query.list();
	}	
}