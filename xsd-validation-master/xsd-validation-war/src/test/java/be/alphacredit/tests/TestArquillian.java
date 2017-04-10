package be.alphacredit.tests;

import static org.junit.Assert.*;

import java.io.*;
import java.math.*;

import javax.xml.ws.*;

import org.jboss.arquillian.container.test.api.*;
import org.jboss.arquillian.junit.*;
import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.asset.*;
import org.jboss.shrinkwrap.api.spec.*;
import org.jboss.shrinkwrap.resolver.api.maven.*;
import org.junit.*;
import org.junit.runner.*;
import org.slf4j.*;

@RunWith(Arquillian.class)
public class TestArquillian
{
  private static final Logger slf4jLogger = LoggerFactory.getLogger(TestArquillian.class);
  private TestService testService = new TestService();

  @Deployment
  public static Archive<?> createTestArchive()
  {
    return ShrinkWrap.createFromZipFile(WebArchive.class, new File("target/xsd-validation-war.war"));
    /*return (WebArchive) ShrinkWrap.create(WebArchive.class, "arquillian-test.war").setWebXML("WEB-INF/web.xml")
        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")       
        .addAsWebInfResource("WEB-INF/wsdl/test.wsdl", "wsdl/test.wsdl").addPackage("be.alphacredit.tests")
        .addAsManifestResource(new File ("src/main/webapp/META-INF/handler.xml"))
        .addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().asFile());*/
    //return ShrinkWrap.create(MavenImporter.class).loadPomFromFile("pom.xml").importBuildOutput(new AcceptScopesStrategy(ScopeType.TEST)).as(WebArchive.class);
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
