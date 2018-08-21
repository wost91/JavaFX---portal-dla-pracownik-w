package pl.pwn.reaktor.pracownicy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.pracownicy.util.HibernateUtil;

public abstract class ServiceTemplate {
		
	public final List<?> getAll() {
		Receiver r = new GetAllReceiver(select());
        Command serviceCommand = new ServiceCommand(r);
        serviceCommand.execute();
		return GetAllReceiver.kryteria;
	}
	public abstract String select();
	
	public final String save(Object tab) {
		Receiver r = new SaveReceiver(tab);
        Command serviceCommand = new ServiceCommand(r);
        serviceCommand.execute();
		return SaveReceiver.reg;
	}	
	public final void delete(String reg) {
		Receiver r = new DeleteReceiver(reg,reg2(),delete());
        Command serviceCommand = new ServiceCommand(r);
        serviceCommand.execute();
	}
	public abstract String reg2();
	public abstract String delete();
	
	public final void delete(long id) {
		Receiver r = new DeleteIdReceiver(id,reg2(),delete());
        Command serviceCommand = new ServiceCommand(r);
        serviceCommand.execute();
	}		
	public final void update(Object selectedItem) {
		Receiver r = new UpdateReceiver(selectedItem);
        Command serviceCommand = new ServiceCommand(r);
        serviceCommand.execute();
	}
	public final List<?> filter(Object filter) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(getCl());
		List<String> colList = new ArrayList<>();
		colList(colList);
		
		for(int i=0;i<colList.size();i++) {
			if (Objects.nonNull(getter(i,filter))&& !condition1(i).equals(getter(i,filter)) && !(((String) getter(i,filter)).isEmpty())) {
				criteria.add(Restrictions.eq(colList.get(i), getter(i,filter)));
			}
		}
		List<?> kryteria = criteria.list();
		session.close();
		
		return kryteria;
	}	
	public abstract Class<?> getCl();
	public abstract void colList(List<String> colList);
	public abstract Object getter(int i,Object filter);
	public abstract String condition1(int i);
}