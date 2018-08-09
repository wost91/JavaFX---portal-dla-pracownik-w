package pl.pwn.reaktor.pracownicy.model;

public class ZestStatystykiFilter {

	private String dzial;
	private String budzet;
	private String liczbaPracownikow;
	private String budzetNaPracownika;
	private String sredniaPensja;
	private String sumaPensji;
	private String udzialPensji;
	
	public ZestStatystykiFilter(String dzial, String budzet, String liczbaPracownikow, String budzetNaPracownika,
			String sredniaPensja, String sumaPensji, String udzialPensji) {
		super();
		this.dzial = dzial;
		this.budzet = budzet;
		this.liczbaPracownikow = liczbaPracownikow;
		this.budzetNaPracownika = budzetNaPracownika;
		this.sredniaPensja = sredniaPensja;
		this.sumaPensji = sumaPensji;
		this.udzialPensji = udzialPensji;
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

	public String getBudzetNaPracownika() {
		return budzetNaPracownika;
	}

	public void setBudzetNaPracownika(String budzetNaPracownika) {
		this.budzetNaPracownika = budzetNaPracownika;
	}

	public String getSredniaPensja() {
		return sredniaPensja;
	}

	public void setSredniaPensja(String sredniaPensja) {
		this.sredniaPensja = sredniaPensja;
	}

	public String getSumaPensji() {
		return sumaPensji;
	}

	public void setSumaPensji(String sumaPensji) {
		this.sumaPensji = sumaPensji;
	}

	public String getUdzialPensji() {
		return udzialPensji;
	}

	public void setUdzialPensji(String udzialPensji) {
		this.udzialPensji = udzialPensji;
	}
	
	
}
