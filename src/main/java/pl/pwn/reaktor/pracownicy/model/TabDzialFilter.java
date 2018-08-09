package pl.pwn.reaktor.pracownicy.model;

public class TabDzialFilter {

	private String dzial;
	private String budzet;
	private String liczbaPrac;
	
	public TabDzialFilter(String dzial, String budzet, String liczbaPrac) {
		super();
		this.dzial = dzial;
		this.budzet = budzet;
		this.liczbaPrac = liczbaPrac;
	}
	public String getDzial() {
		return dzial;
	}
	public void setDzial(String dzial) {
		this.dzial = dzial;
	}
	public String getBudzet() {
		return budzet;
	}
	public void setBudzet(String budzet) {
		this.budzet = budzet;
	}
	public String getLiczbaPrac() {
		return liczbaPrac;
	}
	public void setLiczbaPrac(String liczbaPrac) {
		this.liczbaPrac = liczbaPrac;
	}
	
	
	
}
