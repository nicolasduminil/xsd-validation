package be.alphacredit.tests;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-04-02T13:28:28.954+02:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://www.alphacredit.be/tests/", name = "TestServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TestServicePortType {

    @WebResult(name = "testStringOutput", targetNamespace = "http://www.alphacredit.be/tests/", partName = "testOutput")
    @WebMethod(action = "testOperation")
    public TestStringOutput testOperation(
        @WebParam(partName = "testInput", name = "testStringInput", targetNamespace = "http://www.alphacredit.be/tests/")
        TestStringInput testInput
    ) throws TestOperationException;
}
