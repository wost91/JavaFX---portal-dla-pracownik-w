package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.ZestTytulPensja;
import pl.pwn.reaktor.pracownicy.model.ZestTytulPensjaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminZestTytulPensjaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT z FROM ZestTytulPensja z";
	}
	public String delete() {
		return null;
	}
	public String reg2() {
		return null;		
	}	

	public List<ZestTytulPensja> filter(ZestTytulPensjaFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(ZestTytulPensja.class);

		if (Objects.nonNull(filter.getTytul()) && !"Tytu³:".equals(filter.getTytul())
				&& !filter.getTytul().isEmpty()) {
			criteria.add(Restrictions.eq("tytul", filter.getTytul()));
		}
		if (Objects.nonNull(filter.getLiczebnosc()) && !filter.getLiczebnosc().isEmpty()) {
			criteria.add(Restrictions.eq("liczebnosc", filter.getLiczebnosc()));
		}
		if (Objects.nonNull(filter.getSrednia()) && !filter.getSrednia().isEmpty()) {
			criteria.add(Restrictions.eq("srednia", filter.getSrednia()));
		}
		
		List<ZestTytulPensja> kryteria = criteria.list();

		session.close();
		return kryteria;
	}
}
