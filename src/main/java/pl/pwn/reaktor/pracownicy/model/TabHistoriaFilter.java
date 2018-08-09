package pl.pwn.reaktor.pracownicy.model;

public class TabHistoriaFilter {
	private String poprzPracodawca;
	private String dataZatr;
	private String dataOdejscia;
	
	public TabHistoriaFilter(String poprzPracodawca, String dataZatr, String dataOdejscia) {
		super();
		this.poprzPracodawca = poprzPracodawca;
		this.dataZatr = dataZatr;
		this.dataOdejscia = dataOdejscia;
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
	
}
