package pl.pwn.reaktor.pracownicy.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.pwn.reaktor.pracownicy.controller.LoginController;
import pl.pwn.reaktor.pracownicy.model.ZestHistoria;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class UserHistoriaService {
	@SuppressWarnings("unchecked")
	public List<ZestHistoria> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query query = session.createQuery("SELECT z FROM ZestHistoria z, Logowanie l, TabPracownicy t WHERE z.nazwisko=t.nazwisko and l.id=t.id and l.login=:login");
		query.setString("login", LoginController.username);
		List<ZestHistoria> kryteria = query.list();
		trx.commit();
		session.close();
		return kryteria;
	}
}