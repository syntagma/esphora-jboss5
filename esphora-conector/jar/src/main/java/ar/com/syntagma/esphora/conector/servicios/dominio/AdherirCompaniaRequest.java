package ar.com.syntagma.esphora.conector.servicios.dominio;

import ar.com.syntagma.esphora.conector.dominio.Compania;

public class AdherirCompaniaRequest {

	private Compania compania;
	private String crt;
	private String key;

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	public String getCrt() {
		return crt;
	}

	public void setCrt(String crt) {
		this.crt = crt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
