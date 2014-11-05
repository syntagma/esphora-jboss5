package ar.com.syntagma.esphora.conector.agenda;
/**
 * AgendaProcesador, engloba el comportamiento relacionado a la ejecucion de Acciones del Quartz.
 * 
 * @author Syntagma SA/ Sebastian Bromberg
 * @see http://www.syntagma.com.ar
 * 
 */

import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.async.Asynchronous;
import org.jboss.seam.annotations.async.Expiration;
import org.jboss.seam.annotations.async.IntervalCron;
import org.jboss.seam.async.QuartzTriggerHandle;
import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.acciones.EmailAccion;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;



@Name("procesador")
@AutoCreate
@Scope(ScopeType.APPLICATION)
public class AgendaProcesador {
	@Logger
	private Log log;
	
	@In(create=true)
	private EmailAccion emailAccion;
	
	
	@Asynchronous
	public QuartzTriggerHandle createTimer(@Expiration Date when,
			@IntervalCron String interval) {
		log.info("Ejecutando Cron");
		try {
			log.debug("Entrando a EmailAction ...");
			emailAccion.enviarSync();
		} catch (ConectorException ce) {
					ce.printStackTrace();  
				  }
		 catch (Exception e) {
			e.printStackTrace();
			log.debug(e.getMessage());
		}	
		log.info("Quartz Test: Email enviado");
		
		return null;
	}
	
	
}
