package pl.pwn.reaktor.pracownicy.service;

public class UpdateReceiver implements Receiver{

	Object selectedItem;
	
	public UpdateReceiver(Object selectedItem) {
		this.selectedItem=selectedItem;
	}
	
	public void action() {
		ServiceCommand.session.saveOrUpdate(selectedItem);
	}
}