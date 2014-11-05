package ar.com.syntagma.esphora.conector.servicios;

public class MailStruct {
	private String nombre;
	private String direccion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public MailStruct(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}
}
