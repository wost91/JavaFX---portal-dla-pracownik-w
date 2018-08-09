package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historia_zatrudnienia")
public class TabHistoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "poprz_pracodawca")
	private String poprzPracodawca;
	@Column(name = "data_zatrudnienia")
	private String dataZatr;
	@Column(name = "data_odejscia")
	private String dataOdejscia;
	
	public TabHistoria(long id, String poprzPracodawca, String dataZatr, String dataOdejscia) {
		super();
		this.id = id;
		this.poprzPracodawca = poprzPracodawca;
		this.dataZatr = dataZatr;
		this.dataOdejscia = dataOdejscia;
	}
	public TabHistoria() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPoprzPracodawca() {
		return poprzPracodawca;
	}
	public void setPoprzPracodawca(String poprzPracodawca) {
		this.poprzPracodawca = poprzPracodawca;
	}
	public String getDataZatr() {
		return dataZatr;
	}
	public void setDataZatr(String dataZatr) {
		this.dataZatr = dataZatr;
	}
	public String getDataOdejscia() {
		return dataOdejscia;
	}
	public void setDataOdejscia(String dataOdejscia) {
		this.dataOdejscia = dataOdejscia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataOdejscia == null) ? 0 : dataOdejscia.hashCode());
		result = prime * result + ((dataZatr == null) ? 0 : dataZatr.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((poprzPracodawca == null) ? 0 : poprzPracodawca.hashCode());
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
		TabHistoria other = (TabHistoria) obj;
		if (dataOdejscia == null) {
			if (other.dataOdejscia != null)
				return false;
		} else if (!dataOdejscia.equals(other.dataOdejscia))
			return false;
		if (dataZatr == null) {
			if (other.dataZatr != null)
				return false;
		} else if (!dataZatr.equals(other.dataZatr))
			return false;
		if (id != other.id)
			return false;
		if (poprzPracodawca == null) {
			if (other.poprzPracodawca != null)
				return false;
		} else if (!poprzPracodawca.equals(other.poprzPracodawca))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TabHistoria [id=" + id + ", poprzPracodawca=" + poprzPracodawca + ", dataZatr=" + dataZatr
				+ ", dataOdejscia=" + dataOdejscia + "]";
	}	
		
}
