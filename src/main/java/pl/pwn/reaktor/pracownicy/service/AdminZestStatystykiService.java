package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.ZestStatystyki;
import pl.pwn.reaktor.pracownicy.model.ZestStatystykiFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminZestStatystykiService extends ServiceTemplate{
	
	public String select() {
		return "SELECT z FROM ZestStatystyki z";
	}
	public String delete() {
		return null;
	}
	public String reg2() {
		return null;		
	}			
	
	public List<ZestStatystyki> filter(ZestStatystykiFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(ZestStatystyki.class);

		if (Objects.nonNull(filter.getDzial()) && !"Dzia³:".equals(filter.getDzial())
				&& !filter.getDzial().isEmpty()) {
			criteria.add(Restrictions.eq("dzial", filter.getDzial()));
		}
		if (Objects.nonNull(filter.getBudzet()) && !filter.getBudzet().isEmpty()) {
			criteria.add(Restrictions.eq("budzet", filter.getBudzet()));
		}
		if (Objects.nonNull(filter.getLiczbaPracownikow()) && !filter.getLiczbaPracownikow().isEmpty()) {
			criteria.add(Restrictions.eq("liczbaPracownikow", filter.getLiczbaPracownikow()));
		}
		if (Objects.nonNull(filter.getBudzetNaPracownika()) && !filter.getBudzetNaPracownika().isEmpty()) {
			criteria.add(Restrictions.eq("budzetNaPracownika", filter.getBudzetNaPracownika()));
		}
		if (Objects.nonNull(filter.getSredniaPensja()) && !filter.getSredniaPensja().isEmpty()) {
			criteria.add(Restrictions.eq("sredniaPensja", filter.getSredniaPensja()));
		}
		if (Objects.nonNull(filter.getSumaPensji()) && !filter.getSumaPensji().isEmpty()) {
			criteria.add(Restrictions.eq("sumaPensji", filter.getSumaPensji()));
		}
		if (Objects.nonNull(filter.getUdzialPensji()) && !filter.getUdzialPensji().isEmpty()) {
			criteria.add(Restrictions.eq("udzialPensji", filter.getUdzialPensji()));
		}
		
		List<ZestStatystyki> kryteria = criteria.list();

		session.close();
		return kryteria;
	}
}
