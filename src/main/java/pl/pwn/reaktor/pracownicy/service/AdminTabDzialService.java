package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pl.pwn.reaktor.pracownicy.model.TabDzial;
import pl.pwn.reaktor.pracownicy.model.TabDzialFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabDzialService extends ServiceTemplate{

	public String select() {
		return "SELECT t FROM TabDzial t";
	}
	public String delete() {
		return "DELETE FROM TabDzial WHERE dzial=:dzial";
	}
	public String reg2() {
		return "dzial";
	}
	
	public List<TabDzial> filter(TabDzialFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabDzial.class);

		if (Objects.nonNull(filter.getDzial()) && !filter.getDzial().isEmpty()) {
			criteria.add(Restrictions.eq("dzial", filter.getDzial()));
		}
		if (Objects.nonNull(filter.getBudzet()) && !filter.getBudzet().isEmpty()) {
			criteria.add(Restrictions.eq("budzet", filter.getBudzet()));
		}
		if (Objects.nonNull(filter.getLiczbaPrac()) && !filter.getLiczbaPrac().isEmpty()) {
			criteria.add(Restrictions.eq("liczbaPrac", filter.getLiczbaPrac()));
		}
		
		List<TabDzial> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}
}
