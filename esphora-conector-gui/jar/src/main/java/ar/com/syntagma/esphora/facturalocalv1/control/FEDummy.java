package ar.com.syntagma.esphora.facturalocalv1.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.ws.WebServiceException;

import org.jboss.seam.annotations.Name;

import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;
import fev1.dif.afip.gov.ar.DummyResponse;

@Name("feDummy")
public class FEDummy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242458660705333813L;
	private static final Long CUIT = 30629416249L;

	private DummyResponse dummyResponse;

	public void ejecutarConsulta() {

		Wsfev1Service service;
		Wsfev1 port;

		service = new Wsfev1Service();
		port = service.getWsfev1Port();

		// feResponse.getFedResp().getFEDetalleResponse().get(0).getCbtDesde()
		try {
			dummyResponse = port.fev1Dummy(CUIT);
		} catch (WebServiceException ex) {
			dummyResponse = new DummyResponse();
			dummyResponse.setAppServer("Error");
			dummyResponse.setAuthServer("NA");
			dummyResponse.setDbServer("NA");
			dummyResponse.setErrorMsg(ex.getCause() != null ? ex.getCause()
					.getMessage() : ex.getMessage());
		}
	}

	public DummyResponse getDummyResponse() {
		if (dummyResponse == null) {
			ejecutarConsulta();
		}
		return dummyResponse;
	}

	public String getFechaVencimientoCertificado() {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(new Date(Long.valueOf(getDummyResponse()
				.getFechaVencimientoCertificado())));
	}

	public Integer getDiasHastaVencimiento() {
		if (getDummyResponse().getFechaVencimientoCertificado() == null) {
			return 0;
		}
		Long fechaVencimientoMillis = Long.valueOf(getDummyResponse()
				.getFechaVencimientoCertificado());
		Long todayMillis = System.currentTimeMillis();
		Long diffMillis = fechaVencimientoMillis - todayMillis;

		return diffMillis > 0 ? (int) (diffMillis / (24 * 60 * 60 * 1000)) : -1;
	}

	public boolean isVencimientoProximo() {
		return getDiasHastaVencimiento() < 30;
	}
}
