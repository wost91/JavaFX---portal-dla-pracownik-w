package pl.pwn.reaktor.pracownicy.service;

import org.hibernate.Query;

public class DeleteReceiver implements Receiver{

	private String reg;
	private String reg2;
	private String delete;
	public DeleteReceiver(String reg,String reg2,String delete) {
		this.reg=reg;
		this.reg2=reg2;
		this.delete=delete;
	}
	
	public void action() {
		Query query = ServiceCommand.session.createQuery(delete);
		query.setString(reg2, reg);
		query.executeUpdate();
	}	
}