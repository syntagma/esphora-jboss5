
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEConsultaCAEResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEConsultaCAEResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Resultado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RError" type="{http://ar.gov.afip.dif.facturaelectronica/}vError" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEConsultaCAEResponse", propOrder = {
    "resultado",
    "rError"
})
public class FEConsultaCAEResponse {

    @XmlElement(name = "Resultado")
    protected int resultado;
    @XmlElement(name = "RError")
    protected VError rError;

    /**
     * Gets the value of the resultado property.
     * 
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * Sets the value of the resultado property.
     * 
     */
    public void setResultado(int value) {
        this.resultado = value;
    }

    /**
     * Gets the value of the rError property.
     * 
     * @return
     *     possible object is
     *     {@link VError }
     *     
     */
    public VError getRError() {
        return rError;
    }

    /**
     * Sets the value of the rError property.
     * 
     * @param value
     *     allowed object is
     *     {@link VError }
     *     
     */
    public void setRError(VError value) {
        this.rError = value;
    }

}
