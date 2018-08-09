package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stanowisko_pensja")
public class TabStanowiskoPensja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stanowisko")
	private String stanowisko;
	@Column(name = "pensja")
	private String pensja;
	
	public TabStanowiskoPensja(String stanowisko, String pensja) {
		super();
		this.stanowisko = stanowisko;
		this.pensja = pensja;
	}
	public TabStanowiskoPensja() {
		super();
	}
	public String getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
	public String getPensja() {
		return pensja;
	}
	public void setPensja(String pensja) {
		this.pensja = pensja;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pensja == null) ? 0 : pensja.hashCode());
		result = prime * result + ((stanowisko == null) ? 0 : stanowisko.hashCode());
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
		TabStanowiskoPensja other = (TabStanowiskoPensja) obj;
		if (pensja == null) {
			if (other.pensja != null)
				return false;
		} else if (!pensja.equals(other.pensja))
			return false;
		if (stanowisko == null) {
			if (other.stanowisko != null)
				return false;
		} else if (!stanowisko.equals(other.stanowisko))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TabStanowiskoPensja [stanowisko=" + stanowisko + ", pensja=" + pensja + "]";
	}
	
	
}
