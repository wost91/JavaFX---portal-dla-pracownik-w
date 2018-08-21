package pl.pwn.reaktor.pracownicy.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class ServiceCommand implements Command{
	private Receiver receiver;

    public ServiceCommand(Receiver receiver){
        this.receiver = receiver;
    }
    public static Session session=null;
	public static Transaction trx=null;
	
	public static void openTrans() {
		session = HibernateUtil.getSessionFactory().openSession();
		trx = session.beginTransaction();
	}
	public static void closeTrans() {
		trx.commit();
		session.close();
	}	
    public void execute(){
    	openTrans();
        receiver.action();
        closeTrans();
    }
}