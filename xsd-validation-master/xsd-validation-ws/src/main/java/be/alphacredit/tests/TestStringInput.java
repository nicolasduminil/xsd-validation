
package be.alphacredit.tests;

import java.math.BigInteger;
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
 *         &lt;element name="range">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="enum">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Audi"/>
 *               &lt;enumeration value="Golf"/>
 *               &lt;enumeration value="BMW"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fiveDigits">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;pattern value="[0-9][0-9][0-9][0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
    "range",
    "_enum",
    "fiveDigits"
})
@XmlRootElement(name = "testStringInput")
public class TestStringInput {

    protected int range;
    @XmlElement(name = "enum", required = true)
    protected String _enum;
    @XmlElement(required = true)
    protected BigInteger fiveDigits;

    /**
     * Obtient la valeur de la propriété range.
     * 
     */
    public int getRange() {
        return range;
    }

    /**
     * Définit la valeur de la propriété range.
     * 
     */
    public void setRange(int value) {
        this.range = value;
    }

    /**
     * Obtient la valeur de la propriété enum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnum() {
        return _enum;
    }

    /**
     * Définit la valeur de la propriété enum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnum(String value) {
        this._enum = value;
    }

    /**
     * Obtient la valeur de la propriété fiveDigits.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFiveDigits() {
        return fiveDigits;
    }

    /**
     * Définit la valeur de la propriété fiveDigits.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFiveDigits(BigInteger value) {
        this.fiveDigits = value;
    }

}
