package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabPracownikDzial;
import pl.pwn.reaktor.pracownicy.model.TabPracownikDzialFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabPracownikDzialService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabPracownikDzial t";
	}
	public String delete() {
		return "DELETE FROM TabPracownikDzial WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}			

	public List<TabPracownikDzial> filter(TabPracownikDzialFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabPracownikDzial.class);

		if (Objects.nonNull(filter.getDzial()) && !filter.getDzial().isEmpty()) {
			criteria.add(Restrictions.eq("dzial", filter.getDzial()));
		}
						
		List<TabPracownikDzial> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}
