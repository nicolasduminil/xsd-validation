package be.alphacredit.tests;

import static org.junit.Assert.*;

import java.io.*;
import java.math.*;
import java.net.*;

import javax.xml.ws.*;

import org.jboss.arquillian.container.test.api.*;
import org.jboss.arquillian.junit.*;
import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.spec.*;
import org.junit.*;
import org.junit.runner.*;

@RunWith(Arquillian.class)
public class TestArquillian
{
  private static TestService testService; 

  @Deployment
  public static Archive<?> createTestArchive()
  {
    return ShrinkWrap.createFromZipFile(WebArchive.class, new File("target/xsd-validation-war.war"));
  }
  
  @Before
  public void before() throws Exception
  {
    testService = new TestService(new URL("http://cac40:9080/xsd-validation-war/TestService?wsdl"));
  }

  @Test
  public void testShouldPass() throws TestOperationException
  {
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Audi");
    testStringInput.setFiveDigits(new BigInteger("99999"));
    testStringInput.setRange(110);
    TestStringOutput testStringOutput = testService.getTestServicePort().testOperation(testStringInput);
    assertNotNull(testStringOutput);
    assertTrue(testStringOutput.testOutput.length() > 0);
    assertEquals(testStringOutput.testOutput, ">> SERVICE: SEI Test Input String " + testStringInput.getRange() + " " + testStringInput.getEnum() + " " + testStringInput.getFiveDigits());
  }

  @Test
  public void testShouldFailEnumInvalid() throws Exception
  {
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Dacia");
    testStringInput.setFiveDigits(new BigInteger("99999"));
    testStringInput.setRange(110);
    try
    {
      testService.getTestServicePort().testOperation(testStringInput);
    }
    catch (WebServiceException ex)
    {
      fail();
    }
  }

  @Test
  public void testShouldFailRangeInvalidInvalid() throws Exception
  {
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Audi");
    testStringInput.setFiveDigits(new BigInteger("99999"));
    testStringInput.setRange(999);
    try
    {
      testService.getTestServicePort().testOperation(testStringInput);
    }
    catch (WebServiceException ex)
    {
      fail();
    }
  }

  @Test
  public void testShouldFailFiveDigitsInvalid() throws Exception
  {
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Audi");
    testStringInput.setFiveDigits(new BigInteger("999999"));
    testStringInput.setRange(110);
    try
    {
      testService.getTestServicePort().testOperation(testStringInput);
    }
    catch (WebServiceException ex)
    {
      fail();
    }
  }
}
