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
import pl.pwn.reaktor.pracownicy.model.ZestOrganizacja;
import pl.pwn.reaktor.pracownicy.model.ZestOrganizacjaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminZestOrganizacjaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT z FROM ZestOrganizacja z";
	}
	public String delete() {
		return null;
	}
	public String reg2() {
		return null;		
	}
	public String condition1(int i) {
		if(i==0) {
		return "Dzia³:";
		}
		else return "x";
	}
	public Class<ZestOrganizacja> getCl(){
		return ZestOrganizacja.class;
	}	
	public void colList(List<String> colList){
		colList.add("dzial");
		colList.add("budzet");
		colList.add("liczbaPracownikow");
		colList.add("dyrektor");
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((ZestOrganizacjaFilter) filter).getDzial();
		}
		else if(i==1) {
			return ((ZestOrganizacjaFilter) filter).getBudzet();
		} 
		else if(i==2) {
			return ((ZestOrganizacjaFilter) filter).getLiczbaPracownikow();
		}
		else {
			return ((ZestOrganizacjaFilter) filter).getDyrektor();
		}		
	}
	
	/*public List<ZestOrganizacja> filter(ZestOrganizacjaFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(ZestOrganizacja.class);

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
		if (Objects.nonNull(filter.getDyrektor()) && !filter.getDyrektor().isEmpty()) {
			criteria.add(Restrictions.eq("dyrektor", filter.getDyrektor()));
		}
		
		List<ZestOrganizacja> kryteria = criteria.list();

		session.close();
		return kryteria;
	}*/
}
