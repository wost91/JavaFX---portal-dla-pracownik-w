package pl.pwn.reaktor.pracownicy.model;

public class TabDyrektorzyFilter {
	private String dyrektor;
	private String dzial;
	
	public TabDyrektorzyFilter(String dyrektor, String dzial) {
		super();
		this.dyrektor = dyrektor;
		this.dzial = dzial;
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
	
}
