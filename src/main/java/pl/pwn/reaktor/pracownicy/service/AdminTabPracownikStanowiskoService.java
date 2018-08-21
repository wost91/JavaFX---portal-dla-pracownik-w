package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabPracownikDzial;
import pl.pwn.reaktor.pracownicy.model.TabPracownikDzialFilter;
import pl.pwn.reaktor.pracownicy.model.TabPracownikStanowisko;
import pl.pwn.reaktor.pracownicy.model.TabPracownikStanowiskoFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabPracownikStanowiskoService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabPracownikStanowisko t";
	}
	public String delete() {
		return "DELETE FROM TabPracownikStanowisko WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}
	public Class<TabPracownikStanowisko> getCl(){
		return TabPracownikStanowisko.class;
	}	
	public void colList(List<String> colList){
		colList.add("stanowisko");		
	}	
	public Object getter(int i, Object filter) {
		return ((TabPracownikStanowiskoFilter) filter).getStanowisko();
	}
	public String condition1(int i) {
		return "x";
	}
}