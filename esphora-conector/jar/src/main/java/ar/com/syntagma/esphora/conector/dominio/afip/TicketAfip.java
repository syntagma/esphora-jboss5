package ar.com.syntagma.esphora.conector.dominio.afip;

import java.io.Serializable;
import java.util.Date;

import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;

/**
 * 
 * @author sebastian.bromberg
 * @version 1.0
 *
 * Clase dedicada a almacenar los datos de la empresa logueada y el Token/Sign obtenidos en la
 * Autentificacion en AFIP.
 */
public class TicketAfip implements Serializable {

	private static final long serialVersionUID = 1488234258529079943L;

	private String token;
	private String sign;
	private Date validezDesde;
	private Date validezHasta;
	private ServicioAfip servicio;
	private Ambiente ambiente;
	private long cuil;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Date getValidezDesde() {
		return validezDesde;
	}

	public void setValidezDesde(Date validezDesde) {
		this.validezDesde = validezDesde;
	}

	public Date getValidezHasta() {
		return validezHasta;
	}

	public void setValidezHasta(Date validezHasta) {
		this.validezHasta = validezHasta;
	}

	public ServicioAfip getServicio() {
		return servicio;
	}

	public void setServicio(ServicioAfip servicio) {
		this.servicio = servicio;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public void setCuil(long cuil) {
		this.cuil = cuil;
	}

	public long getCuil() {
		return cuil;
	}

}