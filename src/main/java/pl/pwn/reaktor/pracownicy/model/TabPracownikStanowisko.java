package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pracownik_stanowisko")
public class TabPracownikStanowisko {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "stanowisko")
	private String stanowisko;
	
	public TabPracownikStanowisko(long id, String stanowisko) {
		super();
		this.id = id;
		this.stanowisko = stanowisko;
	}

	public TabPracownikStanowisko() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		TabPracownikStanowisko other = (TabPracownikStanowisko) obj;
		if (id != other.id)
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
		return "TabPracownikStanowisko [id=" + id + ", stanowisko=" + stanowisko + "]";
	}
	
	
}