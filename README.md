# xsd-validation
Demonstrate using XSD validation rules in JAX-WS services

A WSDL file contains references to XSD grammars, either in-line or included as separated files. These XSD grammars define the data structures which can be sent to the service over SOAP. In an XSD, one may define validation rules, for example numeric or alphabetic fields, email addresses type, phone numbers types, etc.

When the web server hosting a web service is called, it receives a SOAP envelope which tells it which web service is being called. It could validate the body of the SOAP message against the XSD in the WSDL. However, this behaviour is not the default one, for performances reasons. So, the validation of the SOPA payloads against their associated XSD has to be activated explicitly.

In JAX-WS 2.2 this happens by simply using the @SchemaValidation annotation. However, IBM WebShere 8.5.5, still uses an old release of Apache Axis 2 as JAX-WS stack and it doesn't support the @SchemaValidator annotation. One work-around would be to deploy Apache CXF with the service's WAR but this approach isn't recommended as it exposes us to the WebSphere class-loading hell.

This project demonstrates how to use the JAX-WS SOAP payload validation against its schema with WebSphere 8.5.5. It consists in a WSDL defining the following validation rules:
  - a range between 0 and 120
  - an enumerated field which accepted values are: Audi, Golf, BMW
  - a 5 digits number
  
In order to run the project:
  - clone the repository
  - start the application server (WebSphere 8.5.5)
  - ammend the file ${PROJECT_ROOT}/xsd-validation-master/xsd-validation-war/ws-ant.xml such that to reflect your environment. Make sure that the properties hostName, connType, connPort, userId, password, wasHome, node and server are correctly defined.
  - in the directory ${PROJECT_ROOT}/xsd-validation-master, run mvn clean install
  - test the deployed service using a SoapUI project on http://[server]:[port]/xsd-validation-war/TestService
