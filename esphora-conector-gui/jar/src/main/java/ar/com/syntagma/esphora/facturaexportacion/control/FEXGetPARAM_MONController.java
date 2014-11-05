package ar.com.syntagma.esphora.facturaexportacion.control;

/**
 * Modificado: Maximiliano Ferreyra 
 * Fecha: 13/12/2011 
 * Descripción: Se modifica el metodo "ejecutarConsulta" Se pasa por parametro el Cuit en forma de String.
 */

import ar.com.syntagma.esphora.conector.helper.FEXMensajeDeError;
import ar.com.syntagma.esphora.conector.helper.ServicePropertiesHelper;
import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.faces.FacesMessages;

import fex.dif.afip.gov.ar.FEXResponseMon;

@Name("fexGetPARAM_MONController")
public class FEXGetPARAM_MONController {
	
	//@SuppressWarnings("unused")
	@Out(required=false)
	private FEXResponseMon fexResponseMon;
	
	@In
	FacesMessages facesMessages;
	
	public void ejecutarConsulta(String cuit) {
	
		WsfexService service;
		Wsfex port;
				
		String servicio = "wsfex";
		service = new WsfexService(ServicePropertiesHelper.getURL(servicio ),
				ServicePropertiesHelper.getQName(servicio));
		port = service.getWsfexPort();
		
		//pasa el valor que ingresa que es un string a un número, con la funcion long.
		fexResponseMon = port.fexGetPARAMMON(Long.parseLong(cuit.trim()));
		
		// llama a la clase FEXMensajeDeError para validar el mensaje de Error.
		FEXMensajeDeError.ejecutarMensajeDeError(fexResponseMon.getFEXErr() , fexResponseMon.getFEXEvents(), facesMessages);
		
	}

}
