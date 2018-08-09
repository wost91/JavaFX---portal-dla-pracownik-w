package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dane_pracownik")
public class ZestPracownicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String id;
	@Column(name = "imie")
	private String imie;
	@Column(name = "nazwisko")
	private String nazwisko;
	@Column(name = "dzial")
	private String dzial;
	@Column(name = "stanowisko")
	private String stanowisko;
	@Column(name = "pensja")
	private String pensja;
	@Column(name = "staz")
	private String staz;
	@Column(name = "kwalifikacja")
	private String kwalifikacja;
	@Column(name = "premia_przyznana")
	private String premia;
	@Column(name = "suma")
	private String suma;
	
	public ZestPracownicy(String id, String imie, String nazwisko, String dzial, String stanowisko, String pensja,
			String staz, String kwalifikacja, String premia, String suma) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.dzial = dzial;
		this.stanowisko = stanowisko;
		this.pensja = pensja;
		this.staz = staz;
		this.kwalifikacja = kwalifikacja;
		this.premia = premia;
		this.suma = suma;
	}
	public ZestPracownicy() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getDzial() {
		return dzial;
	}
	public void setDzial(String dzial) {
		this.dzial = dzial;
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
	public String getStaz() {
		return staz;
	}
	public void setStaz(String staz) {
		this.staz = staz;
	}
	public String getKwalifikacja() {
		return kwalifikacja;
	}
	public void setKwalifikacja(String kwalifikacja) {
		this.kwalifikacja = kwalifikacja;
	}
	public String getPremia() {
		return premia;
	}
	public void setPremia(String premia) {
		this.premia = premia;
	}
	public String getSuma() {
		return suma;
	}
	public void setSuma(String suma) {
		this.suma = suma;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dzial == null) ? 0 : dzial.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((kwalifikacja == null) ? 0 : kwalifikacja.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + ((pensja == null) ? 0 : pensja.hashCode());
		result = prime * result + ((premia == null) ? 0 : premia.hashCode());
		result = prime * result + ((stanowisko == null) ? 0 : stanowisko.hashCode());
		result = prime * result + ((staz == null) ? 0 : staz.hashCode());
		result = prime * result + ((suma == null) ? 0 : suma.hashCode());
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
		ZestPracownicy other = (ZestPracownicy) obj;
		if (dzial == null) {
			if (other.dzial != null)
				return false;
		} else if (!dzial.equals(other.dzial))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (kwalifikacja == null) {
			if (other.kwalifikacja != null)
				return false;
		} else if (!kwalifikacja.equals(other.kwalifikacja))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (pensja == null) {
			if (other.pensja != null)
				return false;
		} else if (!pensja.equals(other.pensja))
			return false;
		if (premia == null) {
			if (other.premia != null)
				return false;
		} else if (!premia.equals(other.premia))
			return false;
		if (stanowisko == null) {
			if (other.stanowisko != null)
				return false;
		} else if (!stanowisko.equals(other.stanowisko))
			return false;
		if (staz == null) {
			if (other.staz != null)
				return false;
		} else if (!staz.equals(other.staz))
			return false;
		if (suma == null) {
			if (other.suma != null)
				return false;
		} else if (!suma.equals(other.suma))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ZestPracownicy [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", dzial=" + dzial
				+ ", stanowisko=" + stanowisko + ", pensja=" + pensja + ", staz=" + staz + ", kwalifikacja="
				+ kwalifikacja + ", premia=" + premia + ", suma=" + suma + "]";
	}
	
	
	
}
