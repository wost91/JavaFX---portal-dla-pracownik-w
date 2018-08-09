package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wysokoœæ_premii")
public class TabPremia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staz")
	private long staz;
	@Column(name = "premia")
	private String premia;
	
	public TabPremia(long staz, String premia) {
		super();
		this.staz = staz;
		this.premia = premia;
	}
	public TabPremia() {
		super();
	}
	public long getStaz() {
		return staz;
	}
	public void setStaz(long staz) {
		this.staz = staz;
	}
	public String getPremia() {
		return premia;
	}
	public void setPremia(String premia) {
		this.premia = premia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((premia == null) ? 0 : premia.hashCode());
		result = prime * result + (int) (staz ^ (staz >>> 32));
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
		TabPremia other = (TabPremia) obj;
		if (premia == null) {
			if (other.premia != null)
				return false;
		} else if (!premia.equals(other.premia))
			return false;
		if (staz != other.staz)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TabPremia [staz=" + staz + ", premia=" + premia + "]";
	}
	
	
	
	
}
