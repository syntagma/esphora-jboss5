package ar.com.syntagma.esphora.conector.sap.listener;

import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerContextInfo;
import com.sap.conn.jco.server.JCoServerErrorListener;
import com.sap.conn.jco.server.JCoServerExceptionListener;

import facturaelectronica.dif.afip.gov.ar.VError;

// Don't touch
public class MyThrowableListener implements JCoServerErrorListener, JCoServerExceptionListener
{
    
	public void serverErrorOccurred(JCoServer jcoServer, String connectionId, JCoServerContextInfo serverCtx, VError error)
    {
        System.out.println(">>> Error occured on " + jcoServer.getProgramID() + " connection " + connectionId);
        
    }
    
    public void serverExceptionOccurred(JCoServer jcoServer, String connectionId, JCoServerContextInfo serverCtx, Exception error)
    {
        System.out.println(">>> Exception occured on " + jcoServer.getProgramID() + " connection " + connectionId);
        error.printStackTrace();
    }

	@Override
	public void serverErrorOccurred(JCoServer arg0, String arg1,
			JCoServerContextInfo arg2, java.lang.Error arg3) {
        System.out.println(">>> Exception occured on " + arg0.getProgramID() );
        arg3.printStackTrace();
	}
}
