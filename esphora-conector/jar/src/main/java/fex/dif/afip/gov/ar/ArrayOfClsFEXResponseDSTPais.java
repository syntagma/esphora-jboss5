
package fex.dif.afip.gov.ar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClsFEXResponse_DST_pais complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsFEXResponse_DST_pais">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClsFEXResponse_DST_pais" type="{http://ar.gov.afip.dif.fex/}ClsFEXResponse_DST_pais" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsFEXResponse_DST_pais", propOrder = {
    "clsFEXResponseDSTPais"
})
public class ArrayOfClsFEXResponseDSTPais {

    @XmlElement(name = "ClsFEXResponse_DST_pais", nillable = true)
    protected List<ClsFEXResponseDSTPais> clsFEXResponseDSTPais;

    /**
     * Gets the value of the clsFEXResponseDSTPais property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsFEXResponseDSTPais property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsFEXResponseDSTPais().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsFEXResponseDSTPais }
     * 
     * 
     */
    public List<ClsFEXResponseDSTPais> getClsFEXResponseDSTPais() {
        if (clsFEXResponseDSTPais == null) {
            clsFEXResponseDSTPais = new ArrayList<ClsFEXResponseDSTPais>();
        }
        return this.clsFEXResponseDSTPais;
    }

}
