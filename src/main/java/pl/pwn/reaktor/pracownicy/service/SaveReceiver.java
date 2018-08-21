package pl.pwn.reaktor.pracownicy.service;

public class SaveReceiver implements Receiver{
	
	Object tab;
	
	public SaveReceiver(Object tab) {
		this.tab=tab;
	}
	public static String reg;
	public void action() {
		reg = (String) ServiceCommand.session.save(tab);	
	}
}
