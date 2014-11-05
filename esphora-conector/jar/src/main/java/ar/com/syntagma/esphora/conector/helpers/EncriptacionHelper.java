package ar.com.syntagma.esphora.conector.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jboss.seam.annotations.Name;

import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.PropiedadesFactory;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

@SuppressWarnings("restriction")
@Name("encriptacionHelper")
public class EncriptacionHelper {
	// @Logger
	// private static Log log;

	//
	// Create the CMS Message
	//
	public static byte[] crearCms(Ambiente a, String signer, String dstDN,
			String service) throws ConectorException {

		PrivateKey pKey = null;
		X509Certificate pCertificate = null;
		byte[] asn1Cms = null;
		CertStore cstore = null;
		String LoginTicketRequestXml = null;
		String SignerDN = null;

		Properties conector = PropiedadesFactory.getArchivoConector();

		String jksfile;
		String jkspwd = conector.getProperty("jkspwd");

		if (a == Ambiente.PRODUCCION) {
			jksfile = "prod/"+conector.getProperty("jksfile");
		} else {
			jksfile = "test/"+conector.getProperty("jksfile");
		}
		Long ticketTime = new Long(conector.getProperty("TicketTime"));

		//
		// Manage Keys & Certificates Base64.encode (loginTicketRequestXmlCms)
		//
		KeyStore ks = null;
		try {
			// ks = KeyStore.getInstance("jks");
			ks = KeyStore.getInstance(KeyStore.getDefaultType());
		} catch (KeyStoreException e4) {
			throw new ConectorException(99999,
					"Excepcion al instanciar el certificado", e4);
		}

		// InputStream p12stream =
		// ResourceLoader.instance().getResourceAsStream("/"+p12file);
		// //InputStream.class.getResourceAsStream(p12file);
		InputStream jksStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(jksfile);
		// System.out.println("Certificado Leido!: "+p12file);
		System.out.println("KetStore Leido!!: " + jksfile);

		try {
			// ks.load(p12stream, p12pass.toCharArray());
			ks.load(jksStream, jkspwd.toCharArray());
			System.out.println("Certificado Cargado! " + ks.getProvider());
		} catch (NoSuchAlgorithmException e) {
			throw new ConectorException(99999,
					"No se puede interpretar el algoritmo de encriptacion", e);
		} catch (CertificateException e) {
			throw new ConectorException(99999,
					"No se puede leer el certificado .'12", e);
		} catch (IOException e) {
			throw new ConectorException(99999,
					"Error de I/O al cargar el archivo de certificados", e);
		}
		try {
			System.out.println("Certificado Cargado! " + ks.size() + "-"
					+ ks.getType() + "-" + ks.toString());
		} catch (KeyStoreException e4) {
			throw new ConectorException(99999,
					"No se puede leer el certificado .p12", e4);
		}
		/*
		 * try { //p12stream.close(); jksStream.close(); } catch (IOException
		 * e3) { e3.printStackTrace(); throw new ConectorException(99999,
		 * "Error de I/O al cerrar el archivo de certificados",e3); } catch
		 * (Exception e3) { e3.printStackTrace(); throw new
		 * ConectorException(99999
		 * ,"Error de I/O al cerrar el archivo de certificados",e3); }
		 */

		// Get Certificate & Private key from KeyStore
		try {
			// pKey = (PrivateKey) ks.getKey(signer, p12pass.toCharArray());
			pKey = (PrivateKey) ks.getKey(signer, jkspwd.toCharArray());
			System.out.println("Key: " + pKey.getAlgorithm());
		} catch (UnrecoverableKeyException e2) {
			throw new ConectorException(99999,
					"No se puede recuperar la clave del certificado .p12", e2);
		} catch (KeyStoreException e2) {
			throw new ConectorException(99999,
					"No se puede leer el certificado .p12", e2);
		} catch (NoSuchAlgorithmException e2) {
			throw new ConectorException(99999, "No se encuentra el algoritmo",
					e2);
		} catch (NullPointerException e3) {
			throw new ConectorException(99999, "No existe clave privada en la tienda de certificados para el cuit: " + signer,
					e3);
		}


		try {
			pCertificate = (X509Certificate) ks.getCertificate(signer);
			
			//log.debug("Certificado valido hasta: " + pCertificate.getNotAfter());

		} catch (KeyStoreException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		SignerDN = pCertificate.getSubjectDN().toString();

		// Create a list of Certificates to include in the final CMS
		ArrayList<X509Certificate> certList = new ArrayList<X509Certificate>();
		certList.add(pCertificate);

		if (Security.getProvider("BC") == null) {
			Security.addProvider(new BouncyCastleProvider());
		}

		try {
			cstore = CertStore.getInstance("Collection",
					new CollectionCertStoreParameters(certList), "BC");
		} catch (InvalidAlgorithmParameterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchProviderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//
		// Create XML Message
		//
		LoginTicketRequestXml = crearLoginTicketRequest(SignerDN, dstDN,
				service, ticketTime);
		// log.info("XML: " + LoginTicketRequestXml);
		//
		// Create CMS Message
		//
		CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

		// Add a Signer to the Message
		gen.addSigner(pKey, pCertificate, CMSSignedDataGenerator.DIGEST_SHA1);
		// log.info("Key: " + pKey);
		// log.info("Certificate: " + pCertificate);

		// Add the Certificate to the Message
		try {
			gen.addCertificatesAndCRLs(cstore);
		} catch (CertStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Add the data (XML) to the Message
		CMSProcessable data = new CMSProcessableByteArray(
				LoginTicketRequestXml.getBytes());

		// Add a Sign of the Data to the Message
		CMSSignedData signed = null;
		try {
			signed = gen.generate(data, true, "BC");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//
		try {
			asn1Cms = signed.getEncoded();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// log.info("signed: " + signed.getSignerInfos().getSigners() );
		// log.info("asn: " +asn1Cms.toString());

		return (asn1Cms);
	}

	//
	// Create XML Message for AFIP wsaa
	//
	public static String crearLoginTicketRequest(String SignerDN, String dstDN,
			String service, Long TicketTime) {

		String loginTicketRequestXml;

		Date GenTime = new Date();
		GregorianCalendar gentime = new GregorianCalendar();
		GregorianCalendar exptime = new GregorianCalendar();
		String UniqueId = new Long(GenTime.getTime() / 1000).toString();

		exptime.setTime(new Date(GenTime.getTime() + TicketTime));

		XMLGregorianCalendarImpl XMLGenTime = new XMLGregorianCalendarImpl(
				gentime);
		XMLGregorianCalendarImpl XMLExpTime = new XMLGregorianCalendarImpl(
				exptime);
		loginTicketRequestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<loginTicketRequest version=\"1.0\">"
				+ "<header>"
				+ "<source>"
				+ SignerDN
				+ "</source>"
				+ "<destination>"
				+ dstDN
				+ "</destination>"
				+ "<uniqueId>"
				+ UniqueId
				+ "</uniqueId>"
				+ "<generationTime>"
				+ XMLGenTime
				+ "</generationTime>"
				+ "<expirationTime>"
				+ XMLExpTime
				+ "</expirationTime>"
				+ "</header>"
				+ "<service>"
				+ service
				+ "</service>"
				+ "</loginTicketRequest>";

		return (loginTicketRequestXml);
	}

}
