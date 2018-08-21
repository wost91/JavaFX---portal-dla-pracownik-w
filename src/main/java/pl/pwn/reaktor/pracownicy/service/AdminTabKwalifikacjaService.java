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
import pl.pwn.reaktor.pracownicy.model.TabKwalifikacja;
import pl.pwn.reaktor.pracownicy.model.TabKwalifikacjaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabKwalifikacjaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabKwalifikacja t";
	}
	public String delete() {
		return "DELETE FROM TabKwalifikacja WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}	
	public Class<TabKwalifikacja> getCl(){
		return TabKwalifikacja.class;
	}	
	public void colList(List<String> colList){
		colList.add("kwalifikacja");
	}	
	public Object getter(int i, Object filter) {
		return ((TabKwalifikacjaFilter) filter).getKwalifikacja();
	}
	public String condition1(int i) {
		return "x";
	}
}