package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dzial")
public class TabDzial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dzial")
	private String dzial;
	@Column(name = "budzet")
	private String budzet;
	@Column(name = "liczba_pracownikow")
	private String liczbaPrac;
	
	public TabDzial(String dzial, String budzet, String liczbaPrac) {
		super();
		this.dzial = dzial;
		this.budzet = budzet;
		this.liczbaPrac = liczbaPrac;
	}
	public TabDzial() {
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
	public String getLiczbaPrac() {
		return liczbaPrac;
	}
	public void setLiczbaPrac(String liczbaPrac) {
		this.liczbaPrac = liczbaPrac;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budzet == null) ? 0 : budzet.hashCode());
		result = prime * result + ((dzial == null) ? 0 : dzial.hashCode());
		result = prime * result + ((liczbaPrac == null) ? 0 : liczbaPrac.hashCode());
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
		TabDzial other = (TabDzial) obj;
		if (budzet == null) {
			if (other.budzet != null)
				return false;
		} else if (!budzet.equals(other.budzet))
			return false;
		if (dzial == null) {
			if (other.dzial != null)
				return false;
		} else if (!dzial.equals(other.dzial))
			return false;
		if (liczbaPrac == null) {
			if (other.liczbaPrac != null)
				return false;
		} else if (!liczbaPrac.equals(other.liczbaPrac))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TabDzial [dzial=" + dzial + ", budzet=" + budzet + ", liczbaPrac=" + liczbaPrac + "]";
	}
	
	
}
