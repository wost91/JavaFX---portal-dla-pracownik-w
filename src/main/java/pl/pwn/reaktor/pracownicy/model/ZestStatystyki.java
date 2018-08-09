package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statystyki")
public class ZestStatystyki {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dzial")
	private String dzial;
	@Column(name = "budzet")
	private String budzet;
	@Column(name = "liczba_pracownikow")
	private String liczbaPracownikow;
	@Column(name = "budzet_na_pracownika")
	private String budzetNaPracownika;
	@Column(name = "srednia_pensja")
	private String sredniaPensja;
	@Column(name = "suma_pensji")
	private String sumaPensji;
	@Column(name = "udzial_pensji_w_budzecie")
	private String udzialPensji;
	
	public ZestStatystyki(String dzial, String budzet, String liczbaPracownikow, String budzetNaPracownika,
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
	public ZestStatystyki() {
		super();
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budzet == null) ? 0 : budzet.hashCode());
		result = prime * result + ((budzetNaPracownika == null) ? 0 : budzetNaPracownika.hashCode());
		result = prime * result + ((dzial == null) ? 0 : dzial.hashCode());
		result = prime * result + ((liczbaPracownikow == null) ? 0 : liczbaPracownikow.hashCode());
		result = prime * result + ((sredniaPensja == null) ? 0 : sredniaPensja.hashCode());
		result = prime * result + ((sumaPensji == null) ? 0 : sumaPensji.hashCode());
		result = prime * result + ((udzialPensji == null) ? 0 : udzialPensji.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZestStatystyki other = (ZestStatystyki) obj;
		if (budzet == null) {
			if (other.budzet != null)
				return false;
		} else if (!budzet.equals(other.budzet))
			return false;
		if (budzetNaPracownika == null) {
			if (other.budzetNaPracownika != null)
				return false;
		} else if (!budzetNaPracownika.equals(other.budzetNaPracownika))
			return false;
		if (dzial == null) {
			if (other.dzial != null)
				return false;
		} else if (!dzial.equals(other.dzial))
			return false;
		if (liczbaPracownikow == null) {
			if (other.liczbaPracownikow != null)
				return false;
		} else if (!liczbaPracownikow.equals(other.liczbaPracownikow))
			return false;
		if (sredniaPensja == null) {
			if (other.sredniaPensja != null)
				return false;
		} else if (!sredniaPensja.equals(other.sredniaPensja))
			return false;
		if (sumaPensji == null) {
			if (other.sumaPensji != null)
				return false;
		} else if (!sumaPensji.equals(other.sumaPensji))
			return false;
		if (udzialPensji == null) {
			if (other.udzialPensji != null)
				return false;
		} else if (!udzialPensji.equals(other.udzialPensji))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ZestStatystyki [dzial=" + dzial + ", budzet=" + budzet + ", liczbaPracownikow=" + liczbaPracownikow
				+ ", budzetNaPracownika=" + budzetNaPracownika + ", sredniaPensja=" + sredniaPensja + ", sumaPensji="
				+ sumaPensji + ", udzialPensji=" + udzialPensji + "]";
	}
	
}
