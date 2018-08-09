package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabWyksztalcenie;
import pl.pwn.reaktor.pracownicy.model.TabWyksztalcenieFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabWyksztalcenieService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabWyksztalcenie t";
	}
	public String delete() {
		return "DELETE FROM TabWyksztalcenie WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}			
		
	public List<TabWyksztalcenie> filter(TabWyksztalcenieFilter filter) {

			Session session = HibernateUtil.getSessionFactory().openSession();

			Criteria criteria = session.createCriteria(TabWyksztalcenie.class);

			if (Objects.nonNull(filter.getUczelnia()) && !filter.getUczelnia().isEmpty()) {
				criteria.add(Restrictions.eq("uczelnia", filter.getUczelnia()));
			}
			if (Objects.nonNull(filter.getDataRozp()) && !filter.getDataRozp().isEmpty()) {
				criteria.add(Restrictions.eq("dataRozp", filter.getDataRozp()));
			}
			if (Objects.nonNull(filter.getDataZak()) && !filter.getDataZak().isEmpty()) {
				criteria.add(Restrictions.eq("dataZak", filter.getDataZak()));
			}
			if (Objects.nonNull(filter.getTytul()) && !filter.getTytul().isEmpty()) {
				criteria.add(Restrictions.eq("tytul", filter.getTytul()));
			}
			
			List<TabWyksztalcenie> kryteria = criteria.list();

			session.close();
			return kryteria;
			
		}		
	}
