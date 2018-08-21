package pl.pwn.reaktor.pracownicy.service;

import pl.pwn.reaktor.pracownicy.model.Logowanie;

public class LoginService {

	public boolean login(String login, String password) {
		Receiver r = new LoginReceiver(login,password);
        Command serviceCommand = new ServiceCommand(r);
        serviceCommand.execute();
        
		Logowanie login2 = (Logowanie) LoginReceiver.list.get(0);
		System.out.println(login2.getLogin());
		
		if (!LoginReceiver.list.isEmpty()) {
			return true;
		}		
		return false;
	}
	public boolean admin(String login) {
		Receiver r = new AdminReceiver(login);
        Command serviceCommand = new ServiceCommand(r);
        serviceCommand.execute();
        
		Logowanie dost = (Logowanie) AdminReceiver.list.get(0);
		String dostep=dost.getDostep();
		
		if (dostep.equals("A")) {
			return true;
		}		
		return false;
	}
}