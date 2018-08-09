package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pl.pwn.reaktor.pracownicy.model.TabHistoria;
import pl.pwn.reaktor.pracownicy.model.TabHistoriaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabHistoriaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabHistoria t";
	}
	public String delete() {
		return "DELETE FROM TabHistoria WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}	
	
	public List<TabHistoria> filter(TabHistoriaFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(TabHistoria.class);

		if (Objects.nonNull(filter.getPoprzPracodawca()) && !filter.getPoprzPracodawca().isEmpty()) {
			criteria.add(Restrictions.eq("poprzPracodawca", filter.getPoprzPracodawca()));
		}
		if (Objects.nonNull(filter.getDataZatr()) && !filter.getDataZatr().isEmpty()) {
			criteria.add(Restrictions.eq("dataZatr", filter.getDataZatr()));
		}
		if (Objects.nonNull(filter.getDataOdejscia()) && !filter.getDataOdejscia().isEmpty()) {
			criteria.add(Restrictions.eq("dataOdejscia", filter.getDataOdejscia()));
		}
		
		List<TabHistoria> kryteria = criteria.list();

		session.close();
		return kryteria;		
	}	
}