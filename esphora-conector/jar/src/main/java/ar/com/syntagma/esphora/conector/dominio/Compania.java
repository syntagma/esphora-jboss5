package ar.com.syntagma.esphora.conector.dominio;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author sebastian.bromberg
 * @version 1.0
 *
 * Clase dedicada a almacenar los datos de la empresa logueada y el Token/Sign obtenidos en la
 * Autentificacion en AFIP.
 */
public class Compania implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2490523636190901047L;
	private long cuil;
	private String razonSocial;
	private String direccion;
	private Date fechaCreacion;
	
	public void setCuil(long cuil) {
		this.cuil = cuil;
	}

	public long getCuil() {
		return cuil;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}