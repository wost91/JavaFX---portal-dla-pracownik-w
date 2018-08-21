package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabWyksztalcenie;
import pl.pwn.reaktor.pracownicy.model.TabWyksztalcenieFilter;
import pl.pwn.reaktor.pracownicy.model.ZestHistoria;
import pl.pwn.reaktor.pracownicy.model.ZestHistoriaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminZestHistoriaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT z FROM ZestHistoria z";
	}
	public String delete() {
		return null;
	}
	public String reg2() {
		return null;		
	}	
	public Class<ZestHistoria> getCl(){
		return ZestHistoria.class;
	}	
	public void colList(List<String> colList){
		colList.add("imie");
		colList.add("nazwisko");
		colList.add("poprzPracodawca");
		colList.add("doswiadczenie");
		colList.add("pensja");
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((ZestHistoriaFilter) filter).getImie();
		}
		else if(i==1) {
			return ((ZestHistoriaFilter) filter).getNazwisko();
		} 
		else if(i==2) {
			return ((ZestHistoriaFilter) filter).getPoprzPracodawca();
		}
		else if(i==3) {
			return ((ZestHistoriaFilter) filter).getDoswiadczenie();
		}
		else {
			return ((ZestHistoriaFilter) filter).getPensja();
		}
	}
	public String condition1(int i) {
		return "x";
	}
}