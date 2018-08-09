package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabLogowanie;
import pl.pwn.reaktor.pracownicy.model.TabLogowanieFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabLogowanieService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabLogowanie t";
	}
	public String delete() {
		return "DELETE FROM TabLogowanie WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}		
	
	public List<TabLogowanie> filter(TabLogowanieFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabLogowanie.class);

		if (Objects.nonNull(filter.getLogin()) && !filter.getLogin().isEmpty()) {
			criteria.add(Restrictions.eq("login", filter.getLogin()));
		}
		if (Objects.nonNull(filter.getHaslo()) && !filter.getHaslo().isEmpty()) {
			criteria.add(Restrictions.eq("haslo", filter.getHaslo()));
		}
		if (Objects.nonNull(filter.getDostep()) && !filter.getDostep().isEmpty()) {
			criteria.add(Restrictions.eq("dostep", filter.getDostep()));
		}
				
		List<TabLogowanie> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}
