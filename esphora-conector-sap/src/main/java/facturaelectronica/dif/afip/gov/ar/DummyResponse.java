
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DummyResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DummyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appserver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dbserver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authserver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DummyResponse", propOrder = {
    "appserver",
    "dbserver",
    "authserver"
})
public class DummyResponse {

    protected String appserver;
    protected String dbserver;
    protected String authserver;

    /**
     * Gets the value of the appserver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppserver() {
        return appserver;
    }

    /**
     * Sets the value of the appserver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppserver(String value) {
        this.appserver = value;
    }

    /**
     * Gets the value of the dbserver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbserver() {
        return dbserver;
    }

    /**
     * Sets the value of the dbserver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbserver(String value) {
        this.dbserver = value;
    }

    /**
     * Gets the value of the authserver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthserver() {
        return authserver;
    }

    /**
     * Sets the value of the authserver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthserver(String value) {
        this.authserver = value;
    }

}
