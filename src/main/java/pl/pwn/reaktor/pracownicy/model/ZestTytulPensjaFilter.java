package pl.pwn.reaktor.pracownicy.model;

public class ZestTytulPensjaFilter {
	private String tytul;
	private String liczebnosc;
	private String srednia;
	
	public ZestTytulPensjaFilter(String tytul, String liczebnosc, String srednia) {
		super();
		this.tytul = tytul;
		this.liczebnosc = liczebnosc;
		this.srednia = srednia;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getLiczebnosc() {
		return liczebnosc;
	}
	public void setLiczebnosc(String liczebnosc) {
		this.liczebnosc = liczebnosc;
	}
	public String getSrednia() {
		return srednia;
	}
	public void setSrednia(String srednia) {
		this.srednia = srednia;
	}
	
	
}
