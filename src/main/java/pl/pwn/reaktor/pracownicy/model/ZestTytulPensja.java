package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tytul_a_pensja")
public class ZestTytulPensja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tytul")
	private String tytul;
	@Column(name = "liczebnosc")
	private String liczebnosc;
	@Column(name = "srednia")
	private String srednia;
	
	public ZestTytulPensja(String tytul, String liczebnosc, String srednia) {
		super();
		this.tytul = tytul;
		this.liczebnosc = liczebnosc;
		this.srednia = srednia;
	}
	public ZestTytulPensja() {
		super();
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getLiczebnosc() {
		return liczebnosc;
	}
	public void setLiczebnosc(String liczebnosc) {
		this.liczebnosc = liczebnosc;
	}
	public String getSrednia() {
		return srednia;
	}
	public void setSrednia(String srednia) {
		this.srednia = srednia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((liczebnosc == null) ? 0 : liczebnosc.hashCode());
		result = prime * result + ((srednia == null) ? 0 : srednia.hashCode());
		result = prime * result + ((tytul == null) ? 0 : tytul.hashCode());
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
		ZestTytulPensja other = (ZestTytulPensja) obj;
		if (liczebnosc == null) {
			if (other.liczebnosc != null)
				return false;
		} else if (!liczebnosc.equals(other.liczebnosc))
			return false;
		if (srednia == null) {
			if (other.srednia != null)
				return false;
		} else if (!srednia.equals(other.srednia))
			return false;
		if (tytul == null) {
			if (other.tytul != null)
				return false;
		} else if (!tytul.equals(other.tytul))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ZestTytulPensja [tytul=" + tytul + ", liczebnosc=" + liczebnosc + ", srednia=" + srednia + "]";
	}
		
}
