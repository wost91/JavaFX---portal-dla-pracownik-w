package pl.pwn.reaktor.pracownicy.model;

public class ZestPracownicyFilter {

	private String id;
	private String imie;
	private String nazwisko;
	private String dzial;
	private String stanowisko;
	private String pensja;
	private String staz;
	private String kwalifikacja;
	private String premia;
	private String suma;
	public ZestPracownicyFilter(String id, String imie, String nazwisko, String dzial, String stanowisko, String pensja,
			String staz, String kwalifikacja, String premia, String suma) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.dzial = dzial;
		this.stanowisko = stanowisko;
		this.pensja = pensja;
		this.staz = staz;
		this.kwalifikacja = kwalifikacja;
		this.premia = premia;
		this.suma = suma;
	}
	public ZestPracownicyFilter() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDzial() {
		return dzial;
	}
	public void setDzial(String dzial) {
		this.dzial = dzial;
	}
	public String getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
	public String getPensja() {
		return pensja;
	}
	public void setPensja(String pensja) {
		this.pensja = pensja;
	}
	public String getStaz() {
		return staz;
	}
	public void setStaz(String staz) {
		this.staz = staz;
	}
	public String getKwalifikacja() {
		return kwalifikacja;
	}
	public void setKwalifikacja(String kwalifikacja) {
		this.kwalifikacja = kwalifikacja;
	}
	public String getPremia() {
		return premia;
	}
	public void setPremia(String premia) {
		this.premia = premia;
	}
	public String getSuma() {
		return suma;
	}
	public void setSuma(String suma) {
		this.suma = suma;
	}
	
	
}
