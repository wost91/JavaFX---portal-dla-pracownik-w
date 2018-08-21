package pl.pwn.reaktor.pracownicy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.model.TabDyrektorzy;
import pl.pwn.reaktor.pracownicy.model.TabDyrektorzyFilter;
import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public class AdminTabDyrektorzyService extends ServiceTemplate {
	
	public String select() {
		return "SELECT t FROM TabDyrektorzy t";
	}
	public String delete() {
		return "DELETE FROM TabDyrektorzy WHERE dyrektor=:dyrektor";
	}
	public String reg2() {
		return "dyrektor";
	}		
	public Class<TabDyrektorzy> getCl(){
		return TabDyrektorzy.class;
	}	
	public void colList(List<String> colList){
		colList.add("dyrektor");
		colList.add("dzial");		
	}	
	public Object getter(int i, Object filter) {
		if(i==0) {
			return ((TabDyrektorzyFilter) filter).getDyrektor();
		} 
		else {
			return ((TabDyrektorzyFilter) filter).getDzial();
		}		
	}
	public String condition1(int i) {
		return "x";
	}
}