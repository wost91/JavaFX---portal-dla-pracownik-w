package pl.pwn.reaktor.pracownicy.model;

public class TabWyksztalcenieFilter {

	private String uczelnia;
	private String dataRozp;
	private String dataZak;
	private String tytul;
	
	public TabWyksztalcenieFilter(String uczelnia, String dataRozp, String dataZak, String tytul) {
		super();
		this.uczelnia = uczelnia;
		this.dataRozp = dataRozp;
		this.dataZak = dataZak;
		this.tytul = tytul;
	}
	public String getUczelnia() {
		return uczelnia;
	}
	public void setUczelnia(String uczelnia) {
		this.uczelnia = uczelnia;
	}
	public String getDataRozp() {
		return dataRozp;
	}
	public void setDataRozp(String dataRozp) {
		this.dataRozp = dataRozp;
	}
	public String getDataZak() {
		return dataZak;
	}
	public void setDataZak(String dataZak) {
		this.dataZak = dataZak;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	
	
}
