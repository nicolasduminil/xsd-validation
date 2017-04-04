package be.alphacredit.tests;

import java.io.*;

import org.jboss.arquillian.container.test.api.*;
import org.jboss.arquillian.junit.*;
import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.spec.*;
import org.jboss.shrinkwrap.resolver.api.maven.*;
import org.junit.*;
import org.junit.runner.*;
import org.slf4j.*;

@RunWith(Arquillian.class)
public class TestXSDValidationArquillian
{
  private static final Logger slf4jLogger = LoggerFactory.getLogger(TestXSDValidationArquillian.class);
  
  @Deployment
  public static Archive<?> createTestArchive()
  {
    //slf4jLogger.info("Loading pom.xml");
    System.out.println("Loading pom.xml");
    PomEquippedResolveStage mavenResolver =  Maven.resolver().loadPomFromFile("pom.xml");
    //slf4jLogger.info("pom.xml loaded. Now importing dependencies");
    System.out.println("pom.xml loaded. Now importing dependencies");
    File[] libs = mavenResolver.importRuntimeAndTestDependencies().resolve().withTransitivity().asFile();
    //slf4jLogger.info("Dependencies loaded. Creating web archive");
    System.out.println("Dependencies loaded. Creating web archive");
    WebArchive war = ShrinkWrap.create(WebArchive.class, "arquillian-test.war");
    //slf4jLogger.info("Web archive created. Now, adding files to the archive");
    System.out.println("Web archive created. Now, adding files to the archive");
    for (File file : libs) 
      war.addAsLibrary(file);
    //slf4jLogger.info("Web archive created");
    System.out.println("Web archive created");
    return war;
  }
  
  @Test
  public void test1(){}
}
