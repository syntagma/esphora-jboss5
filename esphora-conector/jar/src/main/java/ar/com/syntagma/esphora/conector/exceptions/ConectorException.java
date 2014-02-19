package ar.com.syntagma.esphora.conector.exceptions;

import java.io.Serializable;

/**
 * 1: No se pudo formar la URL para el servicio WSFE 2: No se pudo establecer el
 * servicio en la locacion wsdlocation con el servicio serviceName 3: No se
 * puede obtener el servicio requerido por serviceName. 4: Servicio invalido
 * para solicitar autorizacion de ticket 5: Usuario invalido para solicitar
 * ticket de autorizacion 6: Error al intentar crear LoginTicketRequest 7: Error
 * al Intentar obtener un nuevo cliente WSAA 8: No se pudo formar la URL del
 * servicio WSFEX
 * 
 * 
 * FEX 9: No se pudo realizar el proceso de autorizacion del comprobante 
 * 10:
 * Problemas al verificar la existencia del pais de destino de embarque 
 * 11:
 * Problemas para la verificacion basica del funcionamiento 
 * 12: Problemas para
 * recuperar los datos completos de un comprobante ya autorizado 
 * 13: Problemas
 * para recuperar el ultimo comprobante autorizado 
 * 14: Problemas para recuperar
 * el ultimo ID con su fecha 
 * 15: Problemas para recuperar la cotizacion de la
 * moneda con su fecha 
 * 16: Problemas para recuperar la lista de cuits de los
 * paises de destinacion 
 * 17: Problemas para recuperar la lista de paises de
 * destinacion 
 * 18: Problemas para recuperar la lista de idiomas y sus codigos
 * 19: Problemas para recuperar la lista de incoterms 
 * 20: Problemas para recuperar el listado de monedas y sus codigos 
 * 21: Problemas para recuperar el
 * listado de puntos de venta registrados para FEX-WS y su estado 
 * 22: Problemas para recuperar el listado de tipos de comprobante y sus codigos 
 * 23: Problemas para recuperar el listado de tipos de exportacion y sus codigos 
 * 24: Problemas para recuperar el listado de unidades de medida
 * 
 * FE
 * 
 * 25: No se pudo realizar el proceso de dado un lote de comprobantes, retonar
 * el mismo autorizado con el CAE 
 * 26: No se pudo realizar el proceso de consulta
 * del CAE 
 * 27: No se pudo realizar dummy 
 * 28: No se pudo realizar el proceso que
 * retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta
 * ingresado 
 * 29: No se pudo realizar el proceso que retorna la maxima cantidad
 * de resgitros de detalle que puede tener una invocacion al FEAutorizarRequest
 * 30: No se pudo realizar el proceso que retorna el ultimo numero de request
 * 
 * AA
 * 
 * 40: No se puede utilizar el servicio WSAA
 * 50 No se puede obtener una instancia de KeyStore utilizado para
 * crear el CMS, o hay problemas para la obtencion de clave privada y obtencion
 * de certificado X509 
 * 51 No fue posible establecer el ContextClassLoader que
 * nos posiblita obtener el archivo p12 o existen problemas de seguridad al
 * agregarle un provider a Security. 
 * 52 No es posible carga o cerrar el archivo ks (KeyStore) con el contenido del archivo p12 
 * 53 La instancia de BouncyCastleProvider, herramienta que nos brinda la encriptacion, es nula 
 * 54 Parametros invalidos al agregar un Signer al mensaje
 * 55 Error al intentar adherir un certificado al mensaje. O error al intentar firmar los datos
 * 56 Error al procesar el certificado que se iba adherir al mensaje * 
 * 
 * PROPERTIES 

 * 60 No se ha podido leer el archivo ....... 
 * 
 * @author Marcos Carranza
 * 
 */
public class ConectorException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5068656593769973533L;

	private Integer codigoError;
	private String mensaje;
	private String message;

	public ConectorException(Integer codigoError, String mensaje, Exception e) {
		super();
		this.codigoError = codigoError;
		this.mensaje = mensaje;
		this.message = e.getMessage();
		this.setStackTrace(e.getStackTrace());
	}

	public Integer getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensaje() {
		
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
