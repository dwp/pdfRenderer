PDF Renderer Microservice
=========================

The PDF Renderer is a self contained microservice that converts the CADS
claim XML into either a HTML or PDF equivalent of the paper form. It
uses the supplied XML data and a Jasper report file to define the
output.  The Jasper report files are versioned and included in the PDF
Renderer.  The version of the report to use is specified inside the
claim XML.

The PDF Renderer does not require a servlet or application container as
it uses Spring Boot to deploy an embedded server from a single jar file.

The PDFs generated are PDF1a format (archival format)

Binaries:
=========

The pdfRenderer binary releases are stored in artifactory
(<https://build.3cbeta.co.uk/artifactory/webapp/home.html>, contact Ian
Ellis at CADS for login credentials)

at [libs-snapshot-local:gov/dwp/carers/p1/](https://build.3cbeta.co.uk/artifactory/simple/libs-snapshot-local/gov/dwp/carers/p1/)

e.g.

  **executable jar with embedded webserver**   [libs-snapshot-local:gov/dwp/carers/p1/3.00-SNAPSHOT/p1-3.00-SNAPSHOT-full.jar](https://build.3cbeta.co.uk/artifactory/simple/libs-snapshot-local/gov/dwp/carers/p1/3.00-SNAPSHOT)
  -------------------------------------------- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  **class files**                              [libs-snapshot-local:gov/dwp/carers/p1/3.00-SNAPSHOT/p1-3.00-SNAPSHOT.jar](https://build.3cbeta.co.uk/artifactory/simple/libs-snapshot-local/gov/dwp/carers/p1/3.00-SNAPSHOT)

Sourcecode:
===========

The pdfRenderer project is available from the git repository:

git@build.3cbeta.co.uk:/home/git/pdfRenderer.git

(Contact Ian Ellis at CADS for access.)

To checkout the repository locally, execute in the parent directory:

git clone git@build.3cbeta.co.uk:/home/git/pdfRenderer.git

this will create a pdfRenderer directory in the current directory,
create a local repository and get the latest copy of the project.

The project requires Java 8
(<https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html>)
and uses gradle to build
(<https://docs.gradle.org/current/userguide/installation.html>)

Using the PDF Renderer
======================

Call the renderer supplying only the claim XML.  The report version is
determined from the XML itself.

e.g.

[claim.xml](file://localhost/download/attachments/2329224/claim.xml%3Fversion=2&modificationDate=1467891361375&api=v2)

&lt;DWPBody
xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance
file:/future/0.21/schema/ca/CarersAllowance\_Schema.xsd"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:ds="http://www.w3.org/2000/09/xmldsig\#"
xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"&gt;

&lt;Version&gt;0.22&lt;/Version&gt;

&lt;DWPCATransaction id="TEST432"&gt;

&lt;TransactionId&gt;TEST432&lt;/TransactionId&gt;

&lt;DateTimeGenerated&gt;12-07-2014 22:07&lt;/DateTimeGenerated&gt;

&lt;DWPCAClaim&gt;

&lt;DateOfClaim&gt;&lt;QuestionLabel&gt;Claim
date&lt;/QuestionLabel&gt;&lt;Answer&gt;01-02-2014&lt;/Answer&gt;&lt;/DateOfClaim&gt;

&lt;Claimant&gt;

&lt;Surname&gt;&lt;QuestionLabel&gt;Last
name&lt;/QuestionLabel&gt;&lt;Answer&gt;IKPvMGWBEXLaPgir4slqqGuawjPtwGtO9MvsVebzNpaRUrOKJi0mvIwqWizctB12&lt;/Answer&gt;&lt;/Surname&gt;

...

...

&lt;/DWPBody

Note: Some of the fields, notably the personal data fields such as NINO,
postcode etc. are encrypted.  The PDF Renderer decrypts the fields
before the report (Jasper) is run, using a locally configured keystore
(see below)

Configuration Parameters
------------------------

**all parameters are optional**

\# env.name is used in the logs as the environment name (e.g. lab,
preview, production)

env.name = preview

\# server.port is the port that the embedded server listens on (http
only)

server.port=9010

\# Health Check

\# The health check writes to the log file periodically
(health.logging.frequency minutes)

\# when turned on (via health.logging.frequency) and always responds on
.../report/health

health.logging = true

health.logging.frequency = 1

Configuring the keystore (for decrypting the data)
==================================================

The keystore must be defined using the -Dcarers.keystore property,
either globally using \_JAVA\_OPTIONS or when starting the pdfService.

e.g. -Dcarers.keystore=/Users/&lt;username&gt;/carerskeystore

    [example
carerskeystore](file://localhost/download/attachments/2329224/carerskeystore%2520%25281%2529%3Fversion=1&modificationDate=1467889446139&api=v2)

Starting the pdfRender
======================

java -jar pdfRenderer.jar

It logs to the console unless you override the logging config, and the
last two lines when it starts successfully are:

 

*    2016-07-08 09:28:20,136 - \[INFO\] - \[main\] -
o.s.b.c.e.j.JettyEmbeddedServletContainer - Jetty started on port(s)
9010 (http/1.1)*

    2016-07-08 09:28:20,143 - \[INFO\] - \[main\] -
controllers.PdfServiceApplication - Started PdfServiceApplication in
5.316 seconds (JVM running for 5.901)

Stopping the pdfRenderer
========================

Ctrl-C

Is it alive
===========

To check if the pdfRenderer is alive and reachable, it can be pinged at:

http://&lt;server name&gt;:&lt;server.port&gt;/ping, e.g.

    <http://localhost:9010/ping>

The health check can be reached at:

http://&lt;server name&gt;:&lt;server.port&gt;/report/health e.g.

    <http://localhost:9010/report/health>

which returns a json response, e.g.

**json**

{

"application name" : "p1",

"version" : "3.00",

"name" : "p1-check",

"Result" : {

"isHealthy" : "true",

"message" : "",

"error" : ""

}

}

Use PDF Renderer to render a PDF file :
---------------------------------------

POST http:\\\\&lt;server name&gt;:&lt;port number&gt;\\**print** &lt;xml
as request body&gt; with a content-type of **text/xml**

which returns a PDF as a byte stream.

Use PDF Renderer to render a HTML file
--------------------------------------

POST http:\\\\&lt;server name&gt;:&lt;port number&gt;\\**show** &lt;xml
as request body&gt;with a content-type of **application/xml**

which returns HTML as a byte stream 

Testing the PDF Renderer
------------------------

There are a number of tools that can be used to make sending specific
requests to the service easier:

**postman** (for chrome - <https://www.getpostman.com/>), which is
friendly and easy to use, but cannot save the responses to a file (so
you cannot easily look at the pdf version)

**curl** (<https://curl.haxx.se/docs/manpage.html>), which is much less
friendly and unix only (including mac and cygwin), but uses a command
line, so can be saved in a file, fully scripted, re-used much more
easily and can be used to write the response to a file.

### Rendering HTML using curl

curl --request POST --header "Content-Type:**application/xml**" --data
@claim.xml --output claim.html http://127.0.0.1:9010/**show**

### Rendering a PDF using curl

curl --request POST --header "Content-Type:**text/xml**" --data
@claim.xml --output claim.pdf http://127.0.0.1:9010/**print**

### **Example Files**

**[claim.xml](file://localhost/download/attachments/2329224/claim.xml%3Fversion=2&modificationDate=1467891361375&api=v2)
 input**

**[claim.html](file://localhost/download/attachments/2329224/claim.html%3Fversion=1&modificationDate=1467897393286&api=v2)
 output**

**[claim.pdf](file://localhost/download/attachments/2329224/claim.pdf%3Fversion=1&modificationDate=1467897393990&api=v2)
  output**

Reports
=======

The reports used to render the data are included in the pdfRenderer
executable jar (/config/&lt;report version&gt;/...)

The version required is determined from
the &lt;DWPBody&gt;/&lt;Version&gt; tag.

Logging
=======

The pdfRenderer uses logback for itself and the spring boot wrapper
(which is used to make the jar self contained and executable).

The logging configuration can be overridden by setting the system
property to the new configuration location (typically *logback.xml),
e.g*.

        java **-Dlogback.configurationFile=/path/to/config.xml** for the
application logging

&lt;TODO&gt; for the spring boot logging

Next Steps
==========

The code is awaiting code review, so there will be some tidying up to
make it clearer, more consistent and adhere to best practices etc.

The end artefact will be made more general and more flexible, e.g being
able to define the reports externally
