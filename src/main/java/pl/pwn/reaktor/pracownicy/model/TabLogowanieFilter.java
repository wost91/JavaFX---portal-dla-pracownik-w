package pl.pwn.reaktor.pracownicy.model;

public class TabLogowanieFilter {

	private String login;
	private String haslo;
	private String dostep;
	
	public TabLogowanieFilter(String login, String haslo, String dostep) {
		super();
		this.login = login;
		this.haslo = haslo;
		this.dostep = dostep;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String getDostep() {
		return dostep;
	}
	public void setDostep(String dostep) {
		this.dostep = dostep;
	}	
	
}
