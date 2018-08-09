package pl.pwn.reaktor.pracownicy.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.pwn.reaktor.pracownicy.controller.LoginController;
import pl.pwn.reaktor.pracownicy.model.ZestPracownicy;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class UserDaneService {
	
	@SuppressWarnings("unchecked")
	public List<ZestPracownicy> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query query = session.createQuery("SELECT z FROM ZestPracownicy z, Logowanie l WHERE l.id=z.id and l.login=:login");
		query.setString("login", LoginController.username);
		List<ZestPracownicy> kryteria = query.list();
		trx.commit();
		session.close();
		return kryteria;
	}
}
