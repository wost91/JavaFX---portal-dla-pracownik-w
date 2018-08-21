package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabLogowanie;
import pl.pwn.reaktor.pracownicy.model.TabLogowanieFilter;
import pl.pwn.reaktor.pracownicy.model.TabPracownicy;
import pl.pwn.reaktor.pracownicy.model.TabPracownicyFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabPracownicyService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabPracownicy t";
	}
	public String delete() {
		return "DELETE FROM TabPracownicy WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}	
	public Class<TabPracownicy> getCl(){
		return TabPracownicy.class;
	}	
	public void colList(List<String> colList){
		colList.add("imie");
		colList.add("nazwisko");	
		colList.add("pesel");
		colList.add("dataUr");
	}
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((TabPracownicyFilter) filter).getImie();
		} 
		else if(i==1) {
			return ((TabPracownicyFilter) filter).getNazwisko();
		} 
		else if(i==2) {
			return ((TabPracownicyFilter) filter).getPesel();
		} 
		else {
			return ((TabPracownicyFilter) filter).getDataUr();
		}		
	}
	public String condition1(int i) {
		return "x";
	}
}