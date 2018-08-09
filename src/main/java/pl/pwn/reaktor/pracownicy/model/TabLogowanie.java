package pl.pwn.reaktor.pracownicy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logowanie")
public class TabLogowanie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "login")
	private String login;
	@Column(name = "haslo")
	private String haslo;
	@Column(name = "dostep")
	private String dostep;
	
	public TabLogowanie(long id, String login, String haslo, String dostep) {
		super();
		this.id = id;
		this.login = login;
		this.haslo = haslo;
		this.dostep = dostep;
	}
	public TabLogowanie() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String getDostep() {
		return dostep;
	}
	public void setDostep(String dostep) {
		this.dostep = dostep;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dostep == null) ? 0 : dostep.hashCode());
		result = prime * result + ((haslo == null) ? 0 : haslo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		TabLogowanie other = (TabLogowanie) obj;
		if (dostep == null) {
			if (other.dostep != null)
				return false;
		} else if (!dostep.equals(other.dostep))
			return false;
		if (haslo == null) {
			if (other.haslo != null)
				return false;
		} else if (!haslo.equals(other.haslo))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TabLogowanie [id=" + id + ", login=" + login + ", haslo=" + haslo + ", dostep=" + dostep + "]";
	}
	
	
}
