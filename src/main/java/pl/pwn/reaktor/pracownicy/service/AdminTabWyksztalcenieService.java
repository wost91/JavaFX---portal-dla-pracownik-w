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
import pl.pwn.reaktor.pracownicy.model.TabWyksztalcenie;
import pl.pwn.reaktor.pracownicy.model.TabWyksztalcenieFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabWyksztalcenieService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabWyksztalcenie t";
	}
	public String delete() {
		return "DELETE FROM TabWyksztalcenie WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}
	public Class<TabWyksztalcenie> getCl(){
		return TabWyksztalcenie.class;
	}	
	public void colList(List<String> colList){
		colList.add("uczelnia");
		colList.add("dataRozp");
		colList.add("dataZak");
		colList.add("tytul");	
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((TabWyksztalcenieFilter) filter).getUczelnia();
		}
		else if(i==1) {
			return ((TabWyksztalcenieFilter) filter).getDataRozp();
		} 
		else if(i==2) {
			return ((TabWyksztalcenieFilter) filter).getDataZak();
		} 
		else {
			return ((TabWyksztalcenieFilter) filter).getTytul();
		}		
	}
	public String condition1(int i) {
		return "x";
	}
}