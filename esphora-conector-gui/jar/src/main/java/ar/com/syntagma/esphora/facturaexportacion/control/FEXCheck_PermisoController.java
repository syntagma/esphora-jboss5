package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseCheckPermiso;

@Name("fexCheck_PermisoController")
public class FEXCheck_PermisoController {
	
	private String idPermiso;
	private int dstMerc;
	private long cuit;
	@Out(required=false)
	private FEXResponseCheckPermiso fexResponseCheckPermiso;
	
	public void setIdPermiso(String idPermiso) {
		this.idPermiso = idPermiso;
	}
	public String getIdPermiso() {
		return idPermiso;
	}
	public void setDstMerc(int dstMerc) {
		this.dstMerc = dstMerc;
	}
	public int getDstMerc() {
		return dstMerc;
	}
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public void ejecutarConsulta() {
	
		WsfexService service;
		Wsfex port;
				
		service = new WsfexService();
		port = service.getWsfexPort();
		
		
		fexResponseCheckPermiso = port.fexCheckPermiso(idPermiso, dstMerc, cuit);
		
	}

}
