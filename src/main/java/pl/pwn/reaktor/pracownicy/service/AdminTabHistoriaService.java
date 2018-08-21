package pl.pwn.reaktor.pracownicy.service;

import java.util.List;
import java.util.Objects;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabDzial;
import pl.pwn.reaktor.pracownicy.model.TabDzialFilter;
import pl.pwn.reaktor.pracownicy.model.TabHistoria;
import pl.pwn.reaktor.pracownicy.model.TabHistoriaFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabHistoriaService extends ServiceTemplate{
	
	public String select() {
		return "SELECT t FROM TabHistoria t";
	}
	public String delete() {
		return "DELETE FROM TabHistoria WHERE id=:id";
	}
	public String reg2() {
		return "id";
	}	
	public Class<TabHistoria> getCl(){
		return TabHistoria.class;
	}	
	public void colList(List<String> colList){
		colList.add("poprzPracodawca");
		colList.add("dataZatr");	
		colList.add("dataOdejscia");
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((TabHistoriaFilter) filter).getPoprzPracodawca();
		} 
		else if(i==1) {
			return ((TabHistoriaFilter) filter).getDataZatr();
		} 
		else {
			return ((TabHistoriaFilter) filter).getDataOdejscia();
		}		
	}
	public String condition1(int i) {
		return "x";
	}
}