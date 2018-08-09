package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabPracownicy;
import pl.pwn.reaktor.pracownicy.model.TabPracownicyFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabPracownicyService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabPracownicy t";
	}
	public String delete() {
		return "DELETE FROM TabPracownicy WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}		
	
	public List<TabPracownicy> filter(TabPracownicyFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabPracownicy.class);

		if (Objects.nonNull(filter.getImie()) && !filter.getImie().isEmpty()) {
			criteria.add(Restrictions.eq("imie", filter.getImie()));
		}
		if (Objects.nonNull(filter.getNazwisko()) && !filter.getNazwisko().isEmpty()) {
			criteria.add(Restrictions.eq("nazwisko", filter.getNazwisko()));
		}
		if (Objects.nonNull(filter.getPesel()) && !filter.getPesel().isEmpty()) {
			criteria.add(Restrictions.eq("pesel", filter.getPesel()));
		}
		if (Objects.nonNull(filter.getDataUr()) && !filter.getDataUr().isEmpty()) {
			criteria.add(Restrictions.eq("dataUr", filter.getDataUr()));
		}
				
		List<TabPracownicy> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}
