
package be.alphacredit.tests;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the be.alphacredit.tests package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: be.alphacredit.tests
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TestStringInput }
     * 
     */
    public TestStringInput createTestStringInput() {
        return new TestStringInput();
    }

    /**
     * Create an instance of {@link TestStringFault }
     * 
     */
    public TestStringFault createTestStringFault() {
        return new TestStringFault();
    }

    /**
     * Create an instance of {@link TestStringOutput }
     * 
     */
    public TestStringOutput createTestStringOutput() {
        return new TestStringOutput();
    }

}
