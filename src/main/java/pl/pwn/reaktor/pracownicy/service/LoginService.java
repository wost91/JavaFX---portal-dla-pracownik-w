package pl.pwn.reaktor.pracownicy.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.pwn.reaktor.pracownicy.controller.LoginController;
import pl.pwn.reaktor.pracownicy.model.Logowanie;
import pl.pwn.reaktor.pracownicy.model.ZestHistoria;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class LoginService {

	public boolean login(String login, String password) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query query = session.createQuery("FROM Logowanie WHERE login=:login and haslo=:pass");
		query.setString("login", login);
		query.setString("pass", password);

		List<Logowanie> list = query.list();
		trx.commit();
		session.close();
		Logowanie login2 = list.get(0);
		System.out.println(login2.getLogin());
		
		if (!list.isEmpty()) {
			return true;
		}		
		return false;
	}
	public boolean admin(String login) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query query = session.createQuery("FROM Logowanie WHERE login=:login");
		query.setString("login", login);
		List<Logowanie> list = query.list();
		trx.commit();
		session.close();
		Logowanie dost = list.get(0);
		String dostep=dost.getDostep();
		
		if (dostep.equals("A")) {
			return true;
		}		
		return false;
	}
}
