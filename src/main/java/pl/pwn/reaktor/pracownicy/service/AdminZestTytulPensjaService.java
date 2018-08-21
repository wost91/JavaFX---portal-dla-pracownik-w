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
import pl.pwn.reaktor.pracownicy.model.ZestTytulPensja;
import pl.pwn.reaktor.pracownicy.model.ZestTytulPensjaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminZestTytulPensjaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT z FROM ZestTytulPensja z";
	}
	public String delete() {
		return null;
	}
	public String reg2() {
		return null;		
	}
	public String condition1(int i) {
		if(i==0) {
		return "Tytu³:";
		}		
		else return "x";
	}
	public Class<ZestTytulPensja> getCl(){
		return ZestTytulPensja.class;
	}	
	public void colList(List<String> colList){
		colList.add("tytul");
		colList.add("liczebnosc");
		colList.add("srednia");
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((ZestTytulPensjaFilter) filter).getTytul();
		}
		else if(i==1) {
			return ((ZestTytulPensjaFilter) filter).getLiczebnosc();
		}		
		else {
			return ((ZestTytulPensjaFilter) filter).getSrednia();
		}
	}
}