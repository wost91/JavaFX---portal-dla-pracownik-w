package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.ZestHistoria;
import pl.pwn.reaktor.pracownicy.model.ZestHistoriaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminZestHistoriaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT z FROM ZestHistoria z";
	}
	public String delete() {
		return null;
	}
	public String reg2() {
		return null;		
	}			
	
	public List<ZestHistoria> filter(ZestHistoriaFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(ZestHistoria.class);

		if (Objects.nonNull(filter.getImie()) && !filter.getImie().isEmpty()) {
			criteria.add(Restrictions.eq("imie", filter.getImie()));
		}
		if (Objects.nonNull(filter.getNazwisko()) && !filter.getNazwisko().isEmpty()) {
			criteria.add(Restrictions.eq("nazwisko", filter.getNazwisko()));
		}
		if (Objects.nonNull(filter.getPoprzPracodawca()) && !filter.getPoprzPracodawca().isEmpty()) {
			criteria.add(Restrictions.eq("poprzPracodawca", filter.getPoprzPracodawca()));
		}
		if (Objects.nonNull(filter.getDoswiadczenie()) && !filter.getDoswiadczenie().isEmpty()) {
			criteria.add(Restrictions.eq("doswiadczenie", filter.getDoswiadczenie()));
		}
		if (Objects.nonNull(filter.getPensja()) && !filter.getPensja().isEmpty()) {
			criteria.add(Restrictions.eq("pensja", filter.getPensja()));
		}
		
		List<ZestHistoria> kryteria = criteria.list();

		session.close();
		return kryteria;
	}
}
