package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historia")
public class ZestHistoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imie")
	private String imie;
	@Column(name = "nazwisko")
	private String nazwisko;
	@Column(name = "poprz_pracodawca")
	private String poprzPracodawca;
	@Column(name = "doswiadczenie")
	private String doswiadczenie;
	@Column(name = "pensja")
	private String pensja;
	
	public ZestHistoria() {
		super();
	}

	public ZestHistoria(String imie, String nazwisko, String poprzPracodawca, String doswiadczenie, String pensja) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.poprzPracodawca = poprzPracodawca;
		this.doswiadczenie = doswiadczenie;
		this.pensja = pensja;
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

	public String getPoprzPracodawca() {
		return poprzPracodawca;
	}

	public void setPoprzPracodawca(String poprzPracodawca) {
		this.poprzPracodawca = poprzPracodawca;
	}

	public String getDoswiadczenie() {
		return doswiadczenie;
	}

	public void setDoswiadczenie(String doswiadczenie) {
		this.doswiadczenie = doswiadczenie;
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
		result = prime * result + ((doswiadczenie == null) ? 0 : doswiadczenie.hashCode());
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + ((pensja == null) ? 0 : pensja.hashCode());
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
		ZestHistoria other = (ZestHistoria) obj;
		if (doswiadczenie == null) {
			if (other.doswiadczenie != null)
				return false;
		} else if (!doswiadczenie.equals(other.doswiadczenie))
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
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
		if (poprzPracodawca == null) {
			if (other.poprzPracodawca != null)
				return false;
		} else if (!poprzPracodawca.equals(other.poprzPracodawca))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ZestHistoria [imie=" + imie + ", nazwisko=" + nazwisko + ", poprzPracodawca=" + poprzPracodawca
				+ ", doswiadczenie=" + doswiadczenie + ", pensja=" + pensja + "]";
	}
		
	
}
