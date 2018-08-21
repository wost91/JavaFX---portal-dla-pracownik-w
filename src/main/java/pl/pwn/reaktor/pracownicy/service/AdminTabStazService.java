package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabStanowiskoPensja;
import pl.pwn.reaktor.pracownicy.model.TabStanowiskoPensjaFilter;
import pl.pwn.reaktor.pracownicy.model.TabStaz;
import pl.pwn.reaktor.pracownicy.model.TabStazFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabStazService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabStaz t";
	}
	public String delete() {
		return "DELETE FROM TabStaz WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}
	public Class<TabStaz> getCl(){
		return TabStaz.class;
	}	
	public void colList(List<String> colList){
		colList.add("staz");	
	}	
	public Object getter(int i, Object filter) {
		return ((TabStazFilter) filter).getStaz();
	}
	public String condition1(int i) {
		return "x";
	}
}