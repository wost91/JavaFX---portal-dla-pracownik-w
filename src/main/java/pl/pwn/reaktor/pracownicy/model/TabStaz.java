package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sta¿_w_firmie")
public class TabStaz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "staz")
	private String staz;
	
	public TabStaz(long id, String staz) {
		super();
		this.id = id;
		this.staz = staz;
	}

	public TabStaz() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStaz() {
		return staz;
	}

	public void setStaz(String staz) {
		this.staz = staz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((staz == null) ? 0 : staz.hashCode());
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
		TabStaz other = (TabStaz) obj;
		if (id != other.id)
			return false;
		if (staz == null) {
			if (other.staz != null)
				return false;
		} else if (!staz.equals(other.staz))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TabStaz [id=" + id + ", staz=" + staz + "]";
	}
	
	
}
