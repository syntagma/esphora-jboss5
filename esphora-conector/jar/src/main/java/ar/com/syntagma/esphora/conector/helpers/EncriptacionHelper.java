package ar.com.syntagma.esphora.conector.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jboss.seam.annotations.Name;

import ar.com.syntagma.esphora.conector.exceptions.ConectorException;


@SuppressWarnings("restriction")
@Name("encriptacionHelper")
public class EncriptacionHelper {
    //@Logger
    //private static Log log;

    //
    // Create the CMS Message
    //

    private Date fechaVencimientoCertificado;

    public byte[] crearCms(String p12file, String p12pass,
                           String signer, String dstDN, String service, Long TicketTime) throws ConectorException {

        PrivateKey pKey = null;
        X509Certificate pCertificate = null;
        byte[] asn1Cms = null;
        CertStore cstore = null;
        String LoginTicketRequestXml = null;
        String SignerDN = null;

        //
        // Manage Keys & Certificates Base64.encode (loginTicketRequestXmlCms)
        //
        KeyStore ks = null;
        try {
            ks = KeyStore.getInstance("pkcs12");
        } catch (KeyStoreException e4) {
            throw new ConectorException(99999,
                    "Excepcion al instanciar el certificado", e4);
        }

        String path = System.getProperty("jboss.server.config.url") + p12file;
        InputStream p12stream;
        try {
            p12stream = new URL(path).openStream(); //new FileInputStream(path));
        } catch (IOException e) {
            throw new ConectorException(99999, "No se ha podido leer el archivo " + path, e);
        } catch (Exception e) {
            throw new ConectorException(99999, "No se ha podido leer el archivo " + path, e);
        }

        //InputStream p12stream = ResourceLoader.instance().getResourceAsStream(path); //InputStream.class.getResourceAsStream(p12file);
        //Thread.currentThread().getContextClassLoader().getResourceAsStream(p12file);
        System.out.println("Certificado Leido!: " + path);
        System.out.println("P12 Stream!: " + p12stream.toString());

        try {
            ks.load(p12stream, p12pass.toCharArray());


            System.out.println("Certificado Cargado! " + ks.getProvider());
        } catch (NoSuchAlgorithmException e) {
            throw new ConectorException(99999,
                    "No se puede interpretar el algoritmo de encriptacion", e);
        } catch (CertificateException e) {
            throw new ConectorException(99999,
                    "No se puede leer el certificado .'12", e);
        } catch (IOException e) {
            throw new ConectorException(99999, "Error de I/O al cargar el archivo de certificados", e);
        }
        try {
            System.out.println("Certificado Cargado! " + ks.size() + "-" + ks.getType()
                    + "-" + ks.toString());
        } catch (KeyStoreException e4) {
            throw new ConectorException(99999,
                    "No se puede leer el certificado .p12", e4);
        }
        try {
            System.out.println("Cerrando p12stream");
            p12stream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
            throw new ConectorException(99999, "Error de I/O al cerrar el archivo de certificados", e3);
        } catch (Exception e3) {
            e3.printStackTrace();
            throw new ConectorException(99999, "Error de I/O al cerrar el archivo de certificados", e3);
        }

        // Get Certificate & Private key from KeyStore
        try {
            System.out.println("Obtengo clave privada " + signer + " " + p12pass);
            pKey = (PrivateKey) ks.getKey(signer, p12pass.toCharArray());

        } catch (UnrecoverableKeyException e2) {
            throw new ConectorException(99999,
                    "No se puede recuperar la clave del certificado .p12", e2);
        } catch (KeyStoreException e2) {
            throw new ConectorException(99999,
                    "No se puede leer el certificado .p12", e2);
        } catch (NoSuchAlgorithmException e2) {
            throw new ConectorException(99999,
                    "No se encuentra el algoritmo", e2);
        }
        try {
            System.out.println("Obtengo certificado X509");
            pCertificate = (X509Certificate) ks.getCertificate(signer);
            System.out.println("Certificado X509 Obtenido: " + pCertificate.getType() );
            fechaVencimientoCertificado = pCertificate.getNotAfter();
        } catch (KeyStoreException e2) {
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
            e1.printStackTrace();
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (NoSuchProviderException e1) {
            e1.printStackTrace();
        }

        //
        // Create XML Message
        //
        LoginTicketRequestXml = crearLoginTicketRequest(SignerDN, dstDN,
                service, TicketTime);
        // log.info("XML: " + LoginTicketRequestXml);
        //
        // Create CMS Message
        //
        CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

        // Add a Signer to the Message
        gen.addSigner(pKey, pCertificate,
                CMSSignedDataGenerator.DIGEST_SHA1);
        // log.info("Key: " + pKey);
        // log.info("Certificate: " + pCertificate);


        // Add the Certificate to the Message
        try {
            gen.addCertificatesAndCRLs(cstore);
        } catch (CertStoreException e) {
            e.printStackTrace();
        } catch (CMSException e) {
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
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (CMSException e) {
            e.printStackTrace();
        }

        //
        try {
            asn1Cms = signed.getEncoded();
        } catch (IOException e) {
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

        //String date = "2009-07-16T19:20:30-05:00";
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSz";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);


        //XMLGregorianCalendarImpl XMLGenTime = new XMLGregorianCalendarImpl(gentime);

        //XMLGregorianCalendarImpl XMLExpTime = new XMLGregorianCalendarImpl(exptime);
        System.out.println("Fecha: " + sdf.format(gentime.getTime()).replace("GMT",""));

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
                + sdf.format(gentime.getTime()).replace("GMT","") //+ XMLGenTime
                + "</generationTime>"
                + "<expirationTime>"
                + sdf.format(exptime.getTime()).replace("GMT","")//+ XMLExpTime
                + "</expirationTime>"
                + "</header>"
                + "<service>"
                + service
                + "</service>"
                + "</loginTicketRequest>";

        System.out.println("Ticket: " + loginTicketRequestXml);

        return (loginTicketRequestXml);
    }

    public Date getFechaVencimientoCertificado() {
        return fechaVencimientoCertificado;
    }

    public void setFechaVencimientoCertificado(
            Date fechaVencimientoCertificado) {
        this.fechaVencimientoCertificado = fechaVencimientoCertificado;
    }

}
