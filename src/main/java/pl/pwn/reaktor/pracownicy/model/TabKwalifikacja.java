package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kwalifikacja_do_premii")
public class TabKwalifikacja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "kwalifikacja")
	private String kwalifikacja;
	
	public TabKwalifikacja(long id, String kwalifikacja) {
		super();
		this.id = id;
		this.kwalifikacja = kwalifikacja;
	}

	public TabKwalifikacja() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKwalifikacja() {
		return kwalifikacja;
	}

	public void setKwalifikacja(String kwalifikacja) {
		this.kwalifikacja = kwalifikacja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((kwalifikacja == null) ? 0 : kwalifikacja.hashCode());
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
		TabKwalifikacja other = (TabKwalifikacja) obj;
		if (id != other.id)
			return false;
		if (kwalifikacja == null) {
			if (other.kwalifikacja != null)
				return false;
		} else if (!kwalifikacja.equals(other.kwalifikacja))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TabKwalifikacja [id=" + id + ", kwalifikacja=" + kwalifikacja + "]";
	}
	
	
}
