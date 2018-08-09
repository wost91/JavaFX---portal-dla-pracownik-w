package pl.pwn.reaktor.pracownicy.model;

public class ZestHistoriaFilter {

	private String imie;
	private String nazwisko;
	private String poprzPracodawca;
	private String doswiadczenie;
	private String pensja;
	
	public ZestHistoriaFilter(String imie, String nazwisko, String poprzPracodawca, String doswiadczenie,
			String pensja) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.poprzPracodawca = poprzPracodawca;
		this.doswiadczenie = doswiadczenie;
		this.pensja = pensja;
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
	public String getPoprzPracodawca() {
		return poprzPracodawca;
	}
	public void setPoprzPracodawca(String poprzPracodawca) {
		this.poprzPracodawca = poprzPracodawca;
	}
	public String getDoswiadczenie() {
		return doswiadczenie;
	}
	public void setDoswiadczenie(String doswiadczenie) {
		this.doswiadczenie = doswiadczenie;
	}
	public String getPensja() {
		return pensja;
	}
	public void setPensja(String pensja) {
		this.pensja = pensja;
	}
	
}
