package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabPracownikStanowisko;
import pl.pwn.reaktor.pracownicy.model.TabPracownikStanowiskoFilter;
import pl.pwn.reaktor.pracownicy.model.TabPremia;
import pl.pwn.reaktor.pracownicy.model.TabPremiaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabPremiaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabPremia t";
	}
	public String delete() {
		return "DELETE FROM TabPremia WHERE staz=:staz";
	}
	public String reg2() {
		return "staz";
	}
	public Class<TabPremia> getCl(){
		return TabPremia.class;
	}	
	public void colList(List<String> colList){
		colList.add("premia");	
	}	
	public Object getter(int i, Object filter) {
		return ((TabPremiaFilter) filter).getPremia();
	}
	public String condition1(int i) {
		return "x";
	}
}