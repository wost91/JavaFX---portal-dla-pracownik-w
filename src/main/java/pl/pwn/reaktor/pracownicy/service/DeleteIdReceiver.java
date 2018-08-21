package pl.pwn.reaktor.pracownicy.service;

import org.hibernate.Query;

public class DeleteIdReceiver implements Receiver{

	private long id;
	private String reg2;
	private String delete;
	
	public DeleteIdReceiver(long id,String reg2,String delete) {
		this.id=id;
		this.reg2=reg2;
		this.delete=delete;
	}
	
	public void action() {
		Query query = ServiceCommand.session.createQuery(delete);
		query.setLong(reg2, id);
		query.executeUpdate();
	}	
}