package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabKwalifikacja;
import pl.pwn.reaktor.pracownicy.model.TabKwalifikacjaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabKwalifikacjaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabKwalifikacja t";
	}
	public String delete() {
		return "DELETE FROM TabKwalifikacja WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}	
	
	public List<TabKwalifikacja> filter(TabKwalifikacjaFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabKwalifikacja.class);

		if (Objects.nonNull(filter.getKwalifikacja()) && !filter.getKwalifikacja().isEmpty()) {
			criteria.add(Restrictions.eq("kwalifikacja", filter.getKwalifikacja()));
		}
				
		List<TabKwalifikacja> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}