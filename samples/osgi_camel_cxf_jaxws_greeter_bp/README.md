Apache Camel route with CXF endpoints sample
=================================================

This demo illustrates how to develope a simple camel-cxf
based jaxws routing scenario. It also servers as a test
case to verify if Camel's CXF endpoints and CXF's 
Jaxws are correctly enabled in your OSGi container.

This demo uses Apache Camel to route Jaxws service calls
to one of the specified target CXF services based on the content.

Building
--------
From the base directory of this sample, the pom.xml file
is used to build and run the standalone unit test.

  mvn clean install
  
Running the demo in OSGi
------------------------
After building the sample, start Karaf and install it using
Karaf command:

  install -s mvn:de.elakito.testzone.samples/osgi-cxf-jaxws-greeter-bp

This scenario includes one Camel-CXF router endpoint and
two CXF jaxws Greeter service endpoints which are
invoked from the Camel route. You can invoke the Greeter service endpoints directly
or over the router's endpoint. In the latter case, the greeting name decides to which
service the call is routed.

If the name ends with a vowel, the call is routed to the the spanisch version
of Greeter. Otherwise, the call is routed to the default english verison of Greeter.

By default, the camel-cxf router's endpoint is hosted at

  http://localhost:8181/cxf/SoapContext/router_jaxws_greeter
  
and two cxf's service endpoints are hosted at

  http://localhost:8181/cxf/SoapContext/service_jaxws_greeter_en
  http://localhost:8181/cxf/SoapContext/service_jaxws_greeter_es

If the CXF servlet is running at other than http://localhost:8181/cxf,
set the desired target endpoints in the configuration file 
me.temp.samples.osgi_camel_cxf_greeter.cfg and place it in the configuration 
directory of the OSGi container. (e.g., etc in Apache Karaf).

See
[instruction_osgi_camel_cxf_jaxws_greeter](https://github.com/elakito/testzone/blob/master/samples/instruction_osgi_camel_cxf_jaxws_greeter.txt)
