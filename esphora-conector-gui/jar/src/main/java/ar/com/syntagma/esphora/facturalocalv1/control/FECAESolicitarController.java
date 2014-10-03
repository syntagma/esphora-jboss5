package ar.com.syntagma.esphora.facturalocalv1.control;

import java.io.Serializable;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fev1.dif.afip.gov.ar.FECAECabRequest;
import fev1.dif.afip.gov.ar.FECAEDetRequest;
import fev1.dif.afip.gov.ar.FECAERequest;
import fev1.dif.afip.gov.ar.FECAEResponse;

import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;

@Name("feCaeSolicitarController")
public class FECAESolicitarController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242458660705333813L;
	private long cuit;
	private int cbteTipo;
	private int ptoVta;
	private long nroFactura;
	
	@Out(required = false)
	private FECAEResponse feResponse;
	
	public void ejecutarConsulta() {

		Wsfev1Service service;
		Wsfev1 port;

		service = new Wsfev1Service();
		port = service.getWsfev1Port();

		//Se crea la variable de entrada al servicio que contiene los datos de la factura a autorizar	
		FECAERequest fer = new FECAERequest();
		
		//Se crea la variable de cabecera de factura
		FECAECabRequest fecr = new FECAECabRequest();
		fecr.setCantReg(1);
		fecr.setCbteTipo(cbteTipo);
		fecr.setPtoVta(ptoVta);
		//Se asocia la cabecera del pedido al pedido a enviar
		fer.setFeCabReq(fecr);
		
		//Se crea una variable de detalle
		FECAEDetRequest fedr = new FECAEDetRequest();
		fedr.setCbteDesde(nroFactura);
		fedr.setCbteHasta(nroFactura);
		// Se agrega el detalle a la lista de detalles de la variable a enviar
		fer.getFeDetReq().getFECAEDetRequest().add(fedr);
		
		//feResponse.getFedResp().getFEDetalleResponse().get(0).getCbtDesde()
		feResponse = port.fecaeSolicitar(fer, cuit);

	}

}
