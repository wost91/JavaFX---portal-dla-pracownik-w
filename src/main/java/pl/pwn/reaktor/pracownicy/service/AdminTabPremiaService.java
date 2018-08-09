package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabPremia;
import pl.pwn.reaktor.pracownicy.model.TabPremiaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabPremiaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabPremia t";
	}
	public String delete() {
		return "DELETE FROM TabPremia WHERE staz=:staz";
	}
	public String reg2() {
		return "staz";
	}
	
	public List<TabPremia> filter(TabPremiaFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabPremia.class);

		if (Objects.nonNull(filter.getPremia()) && !filter.getPremia().isEmpty()) {
			criteria.add(Restrictions.eq("premia", filter.getPremia()));
		}
						
		List<TabPremia> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}
}
