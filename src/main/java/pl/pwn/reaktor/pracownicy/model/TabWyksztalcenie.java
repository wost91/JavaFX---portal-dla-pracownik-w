package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wykszta³cenie")
public class TabWyksztalcenie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "uczelnia")
	private String uczelnia;
	@Column(name = "data_rozp")
	private String dataRozp;
	@Column(name = "data_zak")
	private String dataZak;
	@Column(name = "tytul")
	private String tytul;
	
	public TabWyksztalcenie(long id, String uczelnia, String dataRozp, String dataZak, String tytul) {
		super();
		this.id = id;
		this.uczelnia = uczelnia;
		this.dataRozp = dataRozp;
		this.dataZak = dataZak;
		this.tytul = tytul;
	}

	public TabWyksztalcenie() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUczelnia() {
		return uczelnia;
	}

	public void setUczelnia(String uczelnia) {
		this.uczelnia = uczelnia;
	}

	public String getDataRozp() {
		return dataRozp;
	}

	public void setDataRozp(String dataRozp) {
		this.dataRozp = dataRozp;
	}

	public String getDataZak() {
		return dataZak;
	}

	public void setDataZak(String dataZak) {
		this.dataZak = dataZak;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRozp == null) ? 0 : dataRozp.hashCode());
		result = prime * result + ((dataZak == null) ? 0 : dataZak.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((tytul == null) ? 0 : tytul.hashCode());
		result = prime * result + ((uczelnia == null) ? 0 : uczelnia.hashCode());
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
		TabWyksztalcenie other = (TabWyksztalcenie) obj;
		if (dataRozp == null) {
			if (other.dataRozp != null)
				return false;
		} else if (!dataRozp.equals(other.dataRozp))
			return false;
		if (dataZak == null) {
			if (other.dataZak != null)
				return false;
		} else if (!dataZak.equals(other.dataZak))
			return false;
		if (id != other.id)
			return false;
		if (tytul == null) {
			if (other.tytul != null)
				return false;
		} else if (!tytul.equals(other.tytul))
			return false;
		if (uczelnia == null) {
			if (other.uczelnia != null)
				return false;
		} else if (!uczelnia.equals(other.uczelnia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TabWyksztalcenie [id=" + id + ", uczelnia=" + uczelnia + ", dataRozp=" + dataRozp + ", dataZak="
				+ dataZak + ", tytul=" + tytul + "]";
	}
	
	
}
