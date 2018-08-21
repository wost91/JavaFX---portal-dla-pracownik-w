package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.ZestOrganizacja;
import pl.pwn.reaktor.pracownicy.model.ZestOrganizacjaFilter;
import pl.pwn.reaktor.pracownicy.model.ZestPracownicy;
import pl.pwn.reaktor.pracownicy.model.ZestPracownicyFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminZestPracownicyService extends ServiceTemplate{
	
	public String select() {
		return "SELECT z FROM ZestPracownicy z";
	}
	public String delete() {
		return null;
	}
	public String reg2() {
		return null;		
	}
	public String condition1(int i) {
		if(i==3) {
		return "Dzia³:";
		}
		else if(i==4) {
			return "Stanowisko:";
		}
		else if(i==7) {
			return "Kwalifikacja:";
		}
		else return "x";
	}
	public Class<ZestPracownicy> getCl(){
		return ZestPracownicy.class;
	}	
	public void colList(List<String> colList){
		colList.add("id");
		colList.add("imie");
		colList.add("nazwisko");
		colList.add("dzial");
		colList.add("stanowisko");
		colList.add("pensja");
		colList.add("staz");
		colList.add("kwalifikacja");
		colList.add("premia");
		colList.add("suma");
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((ZestPracownicyFilter) filter).getId();
		}
		else if(i==1) {
			return ((ZestPracownicyFilter) filter).getImie();
		} 
		else if(i==2) {
			return ((ZestPracownicyFilter) filter).getNazwisko();
		}
		else if(i==3) {
			return ((ZestPracownicyFilter) filter).getDzial();
		} 
		else if(i==4) {
			return ((ZestPracownicyFilter) filter).getStanowisko();
		}
		else if(i==5) {
			return ((ZestPracownicyFilter) filter).getPensja();
		} 
		else if(i==6) {
			return ((ZestPracownicyFilter) filter).getStaz();
		}
		else if(i==7) {
			return ((ZestPracownicyFilter) filter).getKwalifikacja();
		} 
		else if(i==8) {
			return ((ZestPracownicyFilter) filter).getPremia();
		}
		else {
			return ((ZestPracownicyFilter) filter).getSuma();
		}		
	}
}