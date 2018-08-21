package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabDyrektorzy;
import pl.pwn.reaktor.pracownicy.model.TabDyrektorzyFilter;
import pl.pwn.reaktor.pracownicy.model.TabDzial;
import pl.pwn.reaktor.pracownicy.model.TabDzialFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabDzialService extends ServiceTemplate{

	public String select() {
		return "SELECT t FROM TabDzial t";
	}
	public String delete() {
		return "DELETE FROM TabDzial WHERE dzial=:dzial";
	}
	public String reg2() {
		return "dzial";
	}	
	public Class<TabDzial> getCl(){
		return TabDzial.class;
	}	
	public void colList(List<String> colList){
		colList.add("dzial");
		colList.add("budzet");	
		colList.add("liczbaPrac");
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((TabDzialFilter) filter).getDzial();
		} 
		else if(i==1) {
			return ((TabDzialFilter) filter).getBudzet();
		} 
		else {
			return ((TabDzialFilter) filter).getLiczbaPrac();
		}		
	}
	public String condition1(int i) {
		return "x";
	}
}