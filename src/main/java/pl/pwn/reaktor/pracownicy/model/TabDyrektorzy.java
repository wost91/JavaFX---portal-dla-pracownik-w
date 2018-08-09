package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "dyrektorzy")
public class TabDyrektorzy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dyrektor")
	private String dyrektor;
	@Column(name = "dzial")
	private String dzial;
	
	public TabDyrektorzy(String dyrektor, String dzial) {
		super();
		this.dyrektor = dyrektor;
		this.dzial = dzial;
	}

	public TabDyrektorzy() {
		super();
	}

	public String getDyrektor() {
		return dyrektor;
	}

	public void setDyrektor(String dyrektor) {
		this.dyrektor = dyrektor;
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
		result = prime * result + ((dyrektor == null) ? 0 : dyrektor.hashCode());
		result = prime * result + ((dzial == null) ? 0 : dzial.hashCode());
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
		TabDyrektorzy other = (TabDyrektorzy) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "TabDyrektorzy [dyrektor=" + dyrektor + ", dzial=" + dzial + "]";
	}
	
	
}
