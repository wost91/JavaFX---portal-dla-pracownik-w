package pl.pwn.reaktor.pracownicy.model;

public class TabPracownicyFilter {

	private String imie;
	private String nazwisko;
	private String pesel;
	private String dataUr;
	
	public TabPracownicyFilter(String imie, String nazwisko, String pesel, String dataUr) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.dataUr = dataUr;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getDataUr() {
		return dataUr;
	}
	public void setDataUr(String dataUr) {
		this.dataUr = dataUr;
	}
	
	
}
