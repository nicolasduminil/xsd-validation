package be.alphacredit.tests;

import javax.jws.*;

@WebService(endpointInterface = "be.alphacredit.tests.TestServicePortType", targetNamespace = "http://www.alphacredit.be/tests/", serviceName = "TestService", portName = "TestServicePort", wsdlLocation = "WEB-INF/wsdl/test.wsdl")
@HandlerChain(file="/META-INF/handler.xml")
public class TestServicePortImpl
{
  public TestStringOutput testOperation(TestStringInput parameter)
  {
    TestStringOutput testStringOutput = new TestStringOutput();
    testStringOutput.setTestOutput(">> SERVICE: SEI Test Input String " + parameter.getRange() + " " + parameter.getEnum() + " " + parameter.getFiveDigits());
    System.out.println(">> SERVICE: SEI Test JAX-WS Service: Request received.");
    System.out.println(testStringOutput.getTestOutput());
    return testStringOutput;
  }
}
