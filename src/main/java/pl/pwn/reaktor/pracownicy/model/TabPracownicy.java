package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pracownicy")
public class TabPracownicy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "imie")
	private String imie;
	@Column(name = "nazwisko")
	private String nazwisko;
	@Column(name = "PESEL")
	private String pesel;
	@Column(name = "Data_ur")
	private String dataUr;
	
	public TabPracownicy(long id, String imie, String nazwisko, String pesel, String dataUr) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.dataUr = dataUr;
	}
	public TabPracownicy() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataUr == null) ? 0 : dataUr.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
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
		TabPracownicy other = (TabPracownicy) obj;
		if (dataUr == null) {
			if (other.dataUr != null)
				return false;
		} else if (!dataUr.equals(other.dataUr))
			return false;
		if (id != other.id)
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TabPracownicy [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", pesel=" + pesel
				+ ", dataUr=" + dataUr + "]";
	}
	
}
