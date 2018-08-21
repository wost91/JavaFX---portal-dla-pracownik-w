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
	public String condition1(int i) {
		if(i==0) {
		return "Dzia³:";
		}		
		else return "x";
	}
	public Class<ZestStatystyki> getCl(){
		return ZestStatystyki.class;
	}	
	public void colList(List<String> colList){
		colList.add("dzial");
		colList.add("budzet");
		colList.add("liczbaPracownikow");
		colList.add("budzetNaPracownika");
		colList.add("sredniaPensja");
		colList.add("sumaPensji");
		colList.add("udzialPensji");		
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((ZestStatystykiFilter) filter).getDzial();
		}
		else if(i==1) {
			return ((ZestStatystykiFilter) filter).getBudzet();
		} 
		else if(i==2) {
			return ((ZestStatystykiFilter) filter).getLiczbaPracownikow();
		}
		else if(i==3) {
			return ((ZestStatystykiFilter) filter).getBudzetNaPracownika();
		} 
		else if(i==4) {
			return ((ZestStatystykiFilter) filter).getSredniaPensja();
		}
		else if(i==5) {
			return ((ZestStatystykiFilter) filter).getSumaPensji();
		} 
		else if(i==6) {
			return ((ZestStatystykiFilter) filter).getUdzialPensji();
		}		
		else {
			return ((ZestStatystykiFilter) filter).getUdzialPensji();
		}
	}
}