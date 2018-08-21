package pl.pwn.reaktor.pracownicy.service;

import org.hibernate.Session;

import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class ServiceCommandFilter implements Command{
	
	private Receiver receiver;

	public ServiceCommandFilter(Receiver receiver) {
        this.receiver = receiver;
	}	
	public static Session session=null;	
		
	public static void openTrans() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	public static void closeTrans() {
		session.close();
	}	
	public void execute(){
		openTrans();
        receiver.action();
        closeTrans();
    }
}