package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabPracownikStanowisko;
import pl.pwn.reaktor.pracownicy.model.TabPracownikStanowiskoFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabPracownikStanowiskoService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabPracownikStanowisko t";
	}
	public String delete() {
		return "DELETE FROM TabPracownikStanowisko WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}			
	
	public List<TabPracownikStanowisko> filter(TabPracownikStanowiskoFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabPracownikStanowisko.class);

		if (Objects.nonNull(filter.getStanowisko()) && !filter.getStanowisko().isEmpty()) {
			criteria.add(Restrictions.eq("stanowisko", filter.getStanowisko()));
		}
						
		List<TabPracownikStanowisko> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}

