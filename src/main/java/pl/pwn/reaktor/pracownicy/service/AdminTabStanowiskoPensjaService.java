package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabPremia;
import pl.pwn.reaktor.pracownicy.model.TabPremiaFilter;
import pl.pwn.reaktor.pracownicy.model.TabStanowiskoPensja;
import pl.pwn.reaktor.pracownicy.model.TabStanowiskoPensjaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabStanowiskoPensjaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabStanowiskoPensja t";
	}
	public String delete() {
		return "DELETE FROM TabStanowiskoPensja WHERE stanowisko=:stanowisko";
	}
	public String reg2() {
		return "stanowisko";
	}	
	public Class<TabStanowiskoPensja> getCl(){
		return TabStanowiskoPensja.class;
	}	
	public void colList(List<String> colList){
		colList.add("pensja");	
	}	
	public Object getter(int i, Object filter) {
		return ((TabStanowiskoPensjaFilter) filter).getPensja();
	}
	public String condition1(int i) {
		return "x";
	}
}