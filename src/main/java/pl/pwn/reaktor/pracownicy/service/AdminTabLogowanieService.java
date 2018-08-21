package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabHistoria;
import pl.pwn.reaktor.pracownicy.model.TabHistoriaFilter;
import pl.pwn.reaktor.pracownicy.model.TabLogowanie;
import pl.pwn.reaktor.pracownicy.model.TabLogowanieFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabLogowanieService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabLogowanie t";
	}
	public String delete() {
		return "DELETE FROM TabLogowanie WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}	
	public Class<TabLogowanie> getCl(){
		return TabLogowanie.class;
	}	
	public void colList(List<String> colList){
		colList.add("login");
		colList.add("haslo");	
		colList.add("dostep");
	}
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((TabLogowanieFilter) filter).getLogin();
		} 
		else if(i==1) {
			return ((TabLogowanieFilter) filter).getHaslo();
		} 
		else {
			return ((TabLogowanieFilter) filter).getDostep();
		}		
	}
	public String condition1(int i) {
		return "x";
	}
}