package ar.com.syntagma.esphora.conector.helpers;

import java.io.Serializable;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.PropiedadesFactory;

@Name("expiracionHelper")
@AutoCreate
@Scope(ScopeType.EVENT)
public class ExpiracionHelper implements Serializable {
	@Logger
	private Log log;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1855936681085813098L;

	public boolean certificadoValido(X509Certificate certificado) throws ConectorException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(certificado.getNotAfter());
		
		
		
		try {
			calendar.add(Calendar.DAY_OF_YEAR, Integer.parseInt(PropiedadesFactory.getArchivoConector().getProperty("vencimiento.dias")) * -1);
			log.debug("fecha de vencimiento menos 7 " +calendar.getTime().toString());
		} catch (NumberFormatException e) {
			throw new ConectorException(-99999,e.getMessage(),e);
		} catch (ConectorException e) {
			throw e;
		}

		if (new Date().after(calendar.getTime())) {
			return false;
		}
		return true;

	}
}
