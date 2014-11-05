package ar.com.syntagma.esphora.conector.agenda;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.async.QuartzTriggerHandle;
import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.PropiedadesFactory;

@Name("controlador")
@AutoCreate
@Scope(ScopeType.APPLICATION)
public class AgendaControlador implements Serializable {
	private static final long serialVersionUID = 7609983147081676186L;

	@In
	AgendaProcesador procesador;

	@Logger
	Log log;

	private QuartzTriggerHandle handler;

	public void agendarProceso() {
		String configuracion;

		try {
			Properties conector = PropiedadesFactory.getArchivoConector();
			configuracion = conector.getProperty("cron");
		} catch (ConectorException e) {
			configuracion = "0 0 * * * ?";
		}

		if (handler == null)
			handler = procesador.createTimer(new Date(), configuracion);
		// if (handler == null) handler = procesador.createTimer(new Date(),
		// "0 * * * * ?");

	}
}
