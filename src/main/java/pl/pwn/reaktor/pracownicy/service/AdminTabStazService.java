package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabStaz;
import pl.pwn.reaktor.pracownicy.model.TabStazFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabStazService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabStaz t";
	}
	public String delete() {
		return "DELETE FROM TabStaz WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}	
	
	public List<TabStaz> filter(TabStazFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabStaz.class);

		if (Objects.nonNull(filter.getStaz()) && !filter.getStaz().isEmpty()) {
			criteria.add(Restrictions.eq("staz", filter.getStaz()));
		}
						
		List<TabStaz> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}
