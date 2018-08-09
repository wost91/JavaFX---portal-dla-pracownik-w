package pl.pwn.reaktor.pracownicy.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public abstract class ServiceTemplate {
	
	public static Session session;
	public static Transaction trx;
	
	public void openTrans() {
		ServiceTemplate.session = HibernateUtil.getSessionFactory().openSession();
		ServiceTemplate.trx = session.beginTransaction();
	}
	public void closeTrans() {
		ServiceTemplate.trx.commit();
		ServiceTemplate.session.close();
	}	
	
	public final List<?> getAll() {
		openTrans();
		Query query = session.createQuery(select());
		List<?> kryteria = query.list();
		closeTrans();
		return kryteria;
	}
	public abstract String select();
	
	public final String save(Object tab) {
		openTrans();
		String reg = (String) session.save(tab);
		closeTrans();
		return reg;
	}	
	public final void delete(String reg) {
		openTrans();
		Query query = session.createQuery(delete());
		query.setString(reg2(), reg);
		query.executeUpdate();
		closeTrans();
	}
	public final void delete(long id) {
		openTrans();
		Query query = session.createQuery(delete());
		query.setLong(reg2(), id);
		query.executeUpdate();
		closeTrans();
	}
	public abstract String delete();
	public abstract String reg2();
		
	public final void update(Object selectedItem) {
		openTrans();
		session.saveOrUpdate(selectedItem);
		closeTrans();
	}	
}
