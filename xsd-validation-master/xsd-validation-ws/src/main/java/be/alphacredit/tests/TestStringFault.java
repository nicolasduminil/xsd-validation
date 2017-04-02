
package be.alphacredit.tests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="testFault" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "testFault"
})
@XmlRootElement(name = "testStringFault")
public class TestStringFault {

    @XmlElement(required = true)
    protected String testFault;

    /**
     * Obtient la valeur de la propriété testFault.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestFault() {
        return testFault;
    }

    /**
     * Définit la valeur de la propriété testFault.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestFault(String value) {
        this.testFault = value;
    }

}
