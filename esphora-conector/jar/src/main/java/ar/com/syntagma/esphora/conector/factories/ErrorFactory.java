package ar.com.syntagma.esphora.conector.factories;

import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import facturaelectronica.dif.afip.gov.ar.VError;
import fev1.dif.afip.gov.ar.ArrayOfErr;
import fev1.dif.afip.gov.ar.Err;
import fex.dif.afip.gov.ar.ClsFEXErr;

public class ErrorFactory {
	
	public static ClsFEXErr getError(ConectorException e){
		return construirError(e);
	}
	
	public static VError  getErrorFE(ConectorException e){
		return construirErrorFE(e);
	}
	
	public static ArrayOfErr  getErrorFEv1(ConectorException e){
		return construirErrorFEv1(e);
	}
	
	private static ClsFEXErr construirError(ConectorException e){
		ClsFEXErr error = new ClsFEXErr();
		
		error.setErrCode(e.getCodigoError());
		error.setErrMsg(e.getMensaje());
		
		return error;
	}

	private static VError construirErrorFE(ConectorException e){
		VError error = new VError();
		
		error.setPercode(e.getCodigoError());
		error.setPerrmsg(e.getMensaje());
		
		return error;
	}

	private static ArrayOfErr construirErrorFEv1(ConectorException e){
		ArrayOfErr lista = new ArrayOfErr();
		Err err = new Err();;
		err.setCode(e.getCodigoError());
		err.setMsg(e.getMensaje());
		lista.getErr().add(err);
		
		return lista;
	}

}
