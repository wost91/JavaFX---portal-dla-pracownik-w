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
import pl.pwn.reaktor.pracownicy.model.TabPracownikDzial;
import pl.pwn.reaktor.pracownicy.model.TabPracownikDzialFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabPracownikDzialService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabPracownikDzial t";
	}
	public String delete() {
		return "DELETE FROM TabPracownikDzial WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}
	public Class<TabPracownikDzial> getCl(){
		return TabPracownikDzial.class;
	}	
	public void colList(List<String> colList){
		colList.add("dzial");		
	}	
	public Object getter(int i, Object filter) {
		return ((TabPracownikDzialFilter) filter).getDzial();
	}
	public String condition1(int i) {
		return "x";
	}
}