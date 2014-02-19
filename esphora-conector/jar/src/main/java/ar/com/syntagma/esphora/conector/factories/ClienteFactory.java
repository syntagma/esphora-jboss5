package ar.com.syntagma.esphora.conector.factories;

import org.jboss.seam.annotations.Name;

import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSAA;
import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFE;
import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFEX;
import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFEv1;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;

@Name("clienteFactory")
public class ClienteFactory {

	public static ClienteWSFE getClienteWSFE (long cuit) throws ConectorException{
		return (new ClienteWSFE(cuit));
	}
	public static ClienteWSFEv1 getClienteWSFEv1 (long cuit) throws ConectorException{
		return (new ClienteWSFEv1(cuit));
	}
	
	public static ClienteWSFEX getClienteWSFEX (long cuit) throws ConectorException{
		return (new ClienteWSFEX(cuit));
	}

	public static ClienteWSAA getClienteWSAA (long cuit) throws ConectorException{
		return (new ClienteWSAA(cuit));
	}
}
