package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizacja")
public class ZestOrganizacja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dzial")
	private String dzial;
	@Column(name = "budzet")
	private String budzet;
	@Column(name = "liczba_pracownikow")
	private String liczbaPracownikow;
	@Column(name = "dyrektor")
	private String dyrektor;
	
	public ZestOrganizacja(String dzial, String budzet, String liczbaPracownikow, String dyrektor) {
		super();
		this.dzial = dzial;
		this.budzet = budzet;
		this.liczbaPracownikow = liczbaPracownikow;
		this.dyrektor = dyrektor;
	}

	public ZestOrganizacja() {
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

	public String getDyrektor() {
		return dyrektor;
	}

	public void setDyrektor(String dyrektor) {
		this.dyrektor = dyrektor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budzet == null) ? 0 : budzet.hashCode());
		result = prime * result + ((dyrektor == null) ? 0 : dyrektor.hashCode());
		result = prime * result + ((dzial == null) ? 0 : dzial.hashCode());
		result = prime * result + ((liczbaPracownikow == null) ? 0 : liczbaPracownikow.hashCode());
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
		ZestOrganizacja other = (ZestOrganizacja) obj;
		if (budzet == null) {
			if (other.budzet != null)
				return false;
		} else if (!budzet.equals(other.budzet))
			return false;
		if (dyrektor == null) {
			if (other.dyrektor != null)
				return false;
		} else if (!dyrektor.equals(other.dyrektor))
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
		return true;
	}

	@Override
	public String toString() {
		return "ZestOrganizacja [dzial=" + dzial + ", budzet=" + budzet + ", liczbaPracownikow=" + liczbaPracownikow
				+ ", dyrektor=" + dyrektor + "]";
	}
	
	
}
