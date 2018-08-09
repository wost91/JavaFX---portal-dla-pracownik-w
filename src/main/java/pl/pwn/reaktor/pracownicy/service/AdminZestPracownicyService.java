package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.ZestPracownicy;
import pl.pwn.reaktor.pracownicy.model.ZestPracownicyFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminZestPracownicyService extends ServiceTemplate{
	
	public String select() {
		return "SELECT z FROM ZestPracownicy z";
	}
	public String delete() {
		return null;
	}
	public String reg2() {
		return null;		
	}			

	public List<ZestPracownicy> filter(ZestPracownicyFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(ZestPracownicy.class);

		if (Objects.nonNull(filter.getId()) && !filter.getId().isEmpty()) {
			criteria.add(Restrictions.eq("id", filter.getId()));
		}
		if (Objects.nonNull(filter.getImie()) && !filter.getImie().isEmpty()) {
			criteria.add(Restrictions.eq("imie", filter.getImie()));
		}
		if (Objects.nonNull(filter.getNazwisko()) && !filter.getNazwisko().isEmpty()) {
			criteria.add(Restrictions.eq("nazwisko", filter.getNazwisko()));
		}
		if (Objects.nonNull(filter.getDzial()) && !"Dzia³:".equals(filter.getDzial())
				&& !filter.getDzial().isEmpty()) {
			criteria.add(Restrictions.eq("dzial", filter.getDzial()));
		}
		if (Objects.nonNull(filter.getStanowisko()) && !"Stanowisko:".equals(filter.getStanowisko())
				&& !filter.getStanowisko().isEmpty()) {
			criteria.add(Restrictions.eq("stanowisko", filter.getStanowisko()));
		}
		if (Objects.nonNull(filter.getPensja()) && !filter.getPensja().isEmpty()) {
			criteria.add(Restrictions.eq("pensja", filter.getPensja()));
		}
		if (Objects.nonNull(filter.getStaz()) && !filter.getStaz().isEmpty()) {
			criteria.add(Restrictions.eq("staz", filter.getStaz()));
		}
		if (Objects.nonNull(filter.getKwalifikacja()) && !"Kwalifikacja".equals(filter.getKwalifikacja())
				&& !filter.getKwalifikacja().isEmpty()) {
			criteria.add(Restrictions.eq("kwalifikacja", filter.getKwalifikacja()));
		}
		if (Objects.nonNull(filter.getPremia()) && !filter.getPremia().isEmpty()) {
			criteria.add(Restrictions.eq("premia", filter.getPremia()));
		}
		if (Objects.nonNull(filter.getSuma()) && !filter.getSuma().isEmpty()) {
			criteria.add(Restrictions.eq("suma", filter.getSuma()));
		}
		List<ZestPracownicy> kryteria = criteria.list();

		session.close();
		return kryteria;
	}

}
