package pl.pwn.reaktor.pracownicy.model;

public class ZestOrganizacjaFilter {

	private String dzial;
	private String budzet;
	private String liczbaPracownikow;
	private String dyrektor;
	
	public ZestOrganizacjaFilter(String dzial, String budzet, String liczbaPracownikow, String dyrektor) {
		super();
		this.dzial = dzial;
		this.budzet = budzet;
		this.liczbaPracownikow = liczbaPracownikow;
		this.dyrektor = dyrektor;
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

	public String getLiczbaPracownikow() {
		return liczbaPracownikow;
	}

	public void setLiczbaPracownikow(String liczbaPracownikow) {
		this.liczbaPracownikow = liczbaPracownikow;
	}

	public String getDyrektor() {
		return dyrektor;
	}

	public void setDyrektor(String dyrektor) {
		this.dyrektor = dyrektor;
	}
	
	
}
