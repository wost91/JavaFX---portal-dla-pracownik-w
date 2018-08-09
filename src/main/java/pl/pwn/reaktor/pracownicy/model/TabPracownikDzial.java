package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pracownik_dzial")
public class TabPracownikDzial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "dzial")
	private String dzial;
	
	public TabPracownikDzial(long id, String dzial) {
		super();
		this.id = id;
		this.dzial = dzial;
	}
	public TabPracownikDzial() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDzial() {
		return dzial;
	}
	public void setDzial(String dzial) {
		this.dzial = dzial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dzial == null) ? 0 : dzial.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		TabPracownikDzial other = (TabPracownikDzial) obj;
		if (dzial == null) {
			if (other.dzial != null)
				return false;
		} else if (!dzial.equals(other.dzial))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TabPracownikDzial [id=" + id + ", dzial=" + dzial + "]";
	}
	
}
