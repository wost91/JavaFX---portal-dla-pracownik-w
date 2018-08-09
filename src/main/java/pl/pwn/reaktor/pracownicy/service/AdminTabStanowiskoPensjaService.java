package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabStanowiskoPensja;
import pl.pwn.reaktor.pracownicy.model.TabStanowiskoPensjaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabStanowiskoPensjaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabStanowiskoPensja t";
	}
	public String delete() {
		return "DELETE FROM TabStanowiskoPensja WHERE stanowisko=:stanowisko";
	}
	public String reg2() {
		return "stanowisko";
	}
	
	public List<TabStanowiskoPensja> filter(TabStanowiskoPensjaFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabStanowiskoPensja.class);

		if (Objects.nonNull(filter.getPensja()) && !filter.getPensja().isEmpty()) {
			criteria.add(Restrictions.eq("pensja", filter.getPensja()));
		}
						
		List<TabStanowiskoPensja> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}
