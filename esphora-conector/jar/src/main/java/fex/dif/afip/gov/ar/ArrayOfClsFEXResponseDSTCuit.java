
package fex.dif.afip.gov.ar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClsFEXResponse_DST_cuit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsFEXResponse_DST_cuit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClsFEXResponse_DST_cuit" type="{http://ar.gov.afip.dif.fex/}ClsFEXResponse_DST_cuit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsFEXResponse_DST_cuit", propOrder = {
    "clsFEXResponseDSTCuit"
})
public class ArrayOfClsFEXResponseDSTCuit {

    @XmlElement(name = "ClsFEXResponse_DST_cuit", nillable = true)
    protected List<ClsFEXResponseDSTCuit> clsFEXResponseDSTCuit;

    /**
     * Gets the value of the clsFEXResponseDSTCuit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsFEXResponseDSTCuit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsFEXResponseDSTCuit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsFEXResponseDSTCuit }
     * 
     * 
     */
    public List<ClsFEXResponseDSTCuit> getClsFEXResponseDSTCuit() {
        if (clsFEXResponseDSTCuit == null) {
            clsFEXResponseDSTCuit = new ArrayList<ClsFEXResponseDSTCuit>();
        }
        return this.clsFEXResponseDSTCuit;
    }

}
