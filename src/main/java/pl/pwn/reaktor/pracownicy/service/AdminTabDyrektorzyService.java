package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabDyrektorzy;
import pl.pwn.reaktor.pracownicy.model.TabDyrektorzyFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabDyrektorzyService extends ServiceTemplate {
	
	public String select() {
		return "SELECT t FROM TabDyrektorzy t";
	}
	public String delete() {
		return "DELETE FROM TabDyrektorzy WHERE dyrektor=:dyrektor";
	}
	public String reg2() {
		return "dyrektor";
	}
	
	public List<TabDyrektorzy> filter(TabDyrektorzyFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabDyrektorzy.class);

		if (Objects.nonNull(filter.getDyrektor()) && !filter.getDyrektor().isEmpty()) {
			criteria.add(Restrictions.eq("dyrektor", filter.getDyrektor()));
		}
		if (Objects.nonNull(filter.getDzial()) && !filter.getDzial().isEmpty()) {
			criteria.add(Restrictions.eq("dzial", filter.getDzial()));
		}		
		List<TabDyrektorzy> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}
