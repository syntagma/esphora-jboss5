package ar.com.syntagma.esphora.facturaexportacion.control;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.ws.WebServiceException;

import org.jboss.seam.annotations.Name;

import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;
import fex.dif.afip.gov.ar.DummyResponse;

@Name("fexDummyController")
public class FEXDummyController {

	private DummyResponse dummyResponse;
	private static final Long CUIT = 30629416249L;

	public void ejecutarConsulta() {

		WsfexService service;
		Wsfex port;

		service = new WsfexService();
		port = service.getWsfexPort();
		try {
			dummyResponse = port.fexDummy(CUIT);
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
