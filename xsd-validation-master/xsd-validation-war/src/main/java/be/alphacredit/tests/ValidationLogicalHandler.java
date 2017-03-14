package be.alphacredit.tests;

import java.util.*;

import javax.wsdl.*;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.*;
import javax.wsdl.xml.*;
import javax.xml.*;
import javax.xml.namespace.*;
import javax.xml.soap.*;
import javax.xml.transform.dom.*;
import javax.xml.validation.*;
import javax.xml.ws.handler.*;
import javax.xml.ws.soap.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class ValidationLogicalHandler implements LogicalHandler<LogicalMessageContext>
{
  private Validator validator = null;
  private javax.xml.validation.Schema schema = null;
  private SchemaFactory schemaFactory = null;
  private DOMSource[] domSources = null;

  @Override
  public void close(MessageContext ctx)
  {
  }

  @Override
  public boolean handleFault(LogicalMessageContext ctx)
  {
    return true;
  }

  @Override
  public boolean handleMessage(LogicalMessageContext ctx)
  {
    try
    {
      getValidator().validate(ctx.getMessage().getPayload());
    }
    catch (SAXParseException ex)
    {
      try
      {
        SOAPFactory soapFactory = SOAPFactory.newInstance();
        SOAPFault soapFault = soapFactory.createFault("SOAP validation failure", new QName("http://schemas.xmlsoap.org/soap/envelope/", "Server"));
        soapFault.setFaultString(ex.getMessage());
        throw new SOAPFaultException(soapFault);
      }
      catch (SOAPException ex1)
      {
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return true;
  }

  private Validator getValidator() throws Exception
  {
    if (validator == null)
    {
      validator = getSchema().newValidator();
    }
    return validator;
  }

  private javax.xml.validation.Schema getSchema() throws Exception
  {
    if (schema == null)
    {
      schema = getSchemaFactory().newSchema(getDomSource());
    }
    return schema;
  }

  private SchemaFactory getSchemaFactory()
  {
    if (schemaFactory == null)
      schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    return schemaFactory;
  }

  private DOMSource[] getDomSource() throws Exception
  {
    if (domSources == null)
    {
      WSDLFactory wsdlFactory = WSDLFactory.newInstance();
      WSDLReader reader = wsdlFactory.newWSDLReader();
      Definition wsdlDefinition = reader.readWSDL("http://cac40:9080/xsd-validation-war/TestService?wsdl");
      ArrayList<Element> wsdlSchemas = new ArrayList<Element>();
      for (Object o : wsdlDefinition.getTypes().getExtensibilityElements())
        if (o instanceof Schema)
          wsdlSchemas.add(((Schema) o).getElement());
      ArrayList<DOMSource> asrcs = new ArrayList<DOMSource>();
      for (Element e : wsdlSchemas)
        asrcs.add(new DOMSource(e));
      domSources = asrcs.toArray(new DOMSource[0]);
    }
    return domSources;
  }
}
