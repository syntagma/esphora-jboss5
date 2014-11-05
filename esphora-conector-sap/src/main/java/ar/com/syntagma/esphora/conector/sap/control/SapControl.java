package ar.com.syntagma.esphora.conector.sap.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import ar.com.syntagma.esphora.conector.sap.handler.JavaSAPHandler;
import ar.com.syntagma.esphora.conector.sap.handler.MyTIDHandler;
import ar.com.syntagma.esphora.conector.sap.listener.MyStateChangedListener;
import ar.com.syntagma.esphora.conector.sap.listener.MyThrowableListener;
import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;

import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.server.DefaultServerHandlerFactory;
import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerFactory;
import com.sap.conn.jco.server.JCoServerFunctionHandler;

/**
 * Establece la comunicacion con SAP, recibe y envia datos
 * 
 * 
 */
public class SapControl extends Thread {

	static int num;
	static MyTIDHandler myTIDHandler = null;
	final static Logger logger = Logger.getLogger(SapControl.class);

	// private static ClientFacturaElectronicaSchemaMaker maker = new
	// ClientFacturaElectronicaSchemaMaker();
	// private static Converter converter = new Converter();

	// Don't touch
	public SapControl() throws IOException {

	}

	static void createDataFile(String name, String suffix, Properties properties) {

		File cfg = new File(name + "." + suffix);
		if (!cfg.exists()) {
			try {
				FileOutputStream fos = new FileOutputStream(cfg, false);
				properties.store(fos, "for tests only !");
				fos.close();
			} catch (Exception e) {
				throw new RuntimeException(
						"Unable to create the destination file "
								+ cfg.getName(), e);
			}
		}
	}

	// Modified
	public static void step2SimpleServer(String serverName) {
		logger.info("Inicia la escucha");
		JCoServer server;
		try {
			server = JCoServerFactory.getServer(serverName);
		} catch (JCoException ex) {
			throw new RuntimeException("Unable to create the server "
					+ serverName + ", because of " + ex.getMessage(), ex);

		}

		// Funciona

		JCoServerFunctionHandler javaSAPHandler = new JavaSAPHandler();
		DefaultServerHandlerFactory.FunctionHandlerFactory factory = new DefaultServerHandlerFactory.FunctionHandlerFactory();
		// Las RFC que seran escuchadas
		factory.registerHandler(SapParameter.RFC_FUNCTION_1, javaSAPHandler);
		factory.registerHandler(SapParameter.RFC_FUNCTION_2, javaSAPHandler);
		factory.registerHandler(SapParameter.RFC_FUNCTION_3, javaSAPHandler);

		server.setCallHandlerFactory(factory);

		MyThrowableListener eListener = new MyThrowableListener();

		server.addServerErrorListener(eListener);
		server.addServerExceptionListener(eListener);

		MyStateChangedListener slistener = new MyStateChangedListener();
		server.addServerStateChangedListener(slistener);

		server.start();
		System.out.println("The program can be stoped using <ctrl>+<c>");
		System.out.println("Runing...");
	}

	public void detener() {
		System.exit(1);
	}

}
