PDF Renderer Microservice
=========================

The PDF Renderer is a self contained microservice that uses a supplied jasper report to convert an XML document into either a HTML or PDF report.

The PDF Renderer uses the supplied XML data and a named, versioned Jasper report file to generate the output.  The location of the jasper report files is configured using XXX (jar or directory). The name and version of the report to use is specified when the PDF Renderer is called.

Two versions of the PDF Renderer are built:
* The PDF Renderer itself without libraries or microservice infrastructure
* The self contained microservice, which includes an embedded HTTP server (Jetty), all the required libraries and other dependencies and executes from a single Jar file (using Spring Boot)

The PDFs generated are PDF1a format (archival format)

The PDF Renderer is used by the CADS project to generate the PDF equivalent of the paper form.  The claim data used in the report is captured by the customer facing application.  The PDF is then sent to DRS for processing by the carers allowance claim unit. (The paper forms are also scanned in and sent to DRS). 

Releases:
=========

PDF Renderer 4.03
-----------------
Download the Latest Release of PDF Renderer library [here](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/releases/4.03-SNAPSHOT/p1-4.03-SNAPSHOT.jar) or the microservice (executable jar with embedded webserver) [here](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/releases/4.03-SNAPSHOT/p1-4.03-SNAPSHOT-full.jar).

Get the [source](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/releases/4.03-SNAPSHOT/p1-4.03-SNAPSHOT-sources.jar), [release notes](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/docs/releaseNotes/4.04-SNAPSHOT.releaseNotes.md), [Javadoc API documents](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/javadocs/4.03-SNAPSHOT/index.html)

All Releases
--------------
All releases are available [here](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/releases)

Building the PDF Renderer:
===========
Get a local copy of the code using git clone https://github.com/Department-for-Work-and-Pensions/pdfRenderer.git

The project requires Java 8
(<https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html>)
and uses gradle to build
(<https://docs.gradle.org/current/userguide/installation.html>)

Using the PDF Renderer
======================

Call the renderer supplying only the claim XML.  The report version is
determined from the XML itself.

e.g.

[claim.xml](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/docs/examples/claim.xml)
<pre>
  &lt;DWPBody xsi:schemaLocation="http://www.govtalk.gov.uk/dwp/carers-allowance file:/future/0.21/schema/ca/CarersAllowance\_Schema.xsd"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:ds="http://www.w3.org/2000/09/xmldsig"
           xmlns="http://www.govtalk.gov.uk/dwp/carers-allowance"&lt;
      &lt;Version>0.22&lt;/Version&lt;
      &lt;DWPCATransaction id="TEST432"&gt;
      &lt;TransactionId>TEST432&lt;/TransactionId&gt;
      &lt;DateTimeGenerated&lt;12-07-2014 22:07&lt;/DateTimeGenerated&gt;
      &lt;DWPCAClaim&gt;
          &lt;DateOfClaim&gt;
              &lt;QuestionLabel&gt;Claim date&lt;/QuestionLabel&gt;
              &lt;Answer>01-02-2014&gt;/Answer>&lt;/DateOfClaim&gt;
          &lt;Claimant&gt;
              &lt;Surname&gt;
                &lt;QuestionLabel>Last name&lt;/QuestionLabel&gt;
                &lt;Answer>Karloff&lt;/Answer&gt;
              &lt;/Surname&gt;
  ...
  ...
  &lt;/DWPBody&lt;
</pre>

Configuration Parameters
------------------------
Default Configuration file

<pre>
icc.path=/config/AdobeRGB1998.icc
jasper.local.folder=../XXpdfReports/build/resources/main/config
jasper.jarfile.folder=./pdfreports
jasper.jarfile.subfolder=config
env.name=lab
server.port=9010
metrics.name=p1
metrics.frequency=1
metrics.slf4j=true
health.logging=true
health.logging.frequency=1
spring.config.name=application-info.properties
spring.config.location=/config/
</pre>


<table>
    <tr>
        <th>Parameter Name</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>icc.path</td>
        <td>Path to a font used in the pdf</td>
    </tr>
    <tr>
        <td>jasper.local.folder</td>
        <td>The folder containing the jasper reports, if both are populated this takes precedence over jasper.local.folder</td>
    </tr>
    <tr>
        <td>jasper.jarfile.folder</td>
        <td>The folder containing the jar file containing the jasper reports, if both are populated the jasper.local.folder takes precedence.  Note this is not the name of the jar file</td>
    </tr>
    <tr>
        <td>jasper.jarfile.subfolder</td>
        <td>an additional enclosing subfolder within the reports jar file (if used) that contains the reports</td>
    </tr>
    <tr>
        <td>env.name</td>
        <td>used in the logs as the environment name (e.g. lab, preview, production)</td>
    </tr>
    <tr>
        <td>server.port</td>
        <td>the port that the embedded server listens on (http
only)</td>
    </tr>
    <tr>
        <td>metrics.name</td>
        <td>? part of the metrics reporting framework</td>
    </tr>
    <tr>
        <td>metrics.frequency</td>
        <td>? part of the metrics reporting framework</td>
    </tr>
    <tr>
        <td>metrics.slf4j</td>
        <td>? part of the metrics reporting framework</td>
    </tr>
    <tr>
        <td>health.logging</td>
        <td>Whether health checks are periodically emmitted to the logs</td>
    </tr>
    <tr>
        <td>health.logging.frequency</td>
        <td>The logging period (seconds)</td>
    </tr>
    <tr>
        <td>spring.config.name</td>
        <td>?</td>
    </tr>
    <tr>
        <td>spring.config.location</td>
        <td>?</td>
    </tr>   
</table>

all parameters are optional, except **jasper.jarfile.folder**

All parameters can be overridden on the command line using. e.g.

    java -jar p1-4.03-SNAPSHOT-full.jar --jasper.jarfile.folder=./pdfreports-1.06-SNAPSHOT.jar

Starting the pdfRender
======================

    java -jar <jar name> --jasper.jarfile.folder=<location of reports>

It logs to the console unless you override the logging config, and the
last two lines when it starts successfully are:

<pre>2016-07-08 09:28:20,136 - \[INFO\] - \[main\] -
o.s.b.c.e.j.JettyEmbeddedServletContainer - Jetty started on port(s)
9010 (http/1.1)

2016-07-08 09:28:20,143 - \[INFO\] - \[main\] -
controllers.PdfServiceApplication - Started PdfServiceApplication in
5.316 seconds (JVM running for 5.901)</pre>

Stopping the pdfRenderer
========================

Ctrl-C

Is it alive
===========

To check if the pdfRenderer is alive and reachable, it can be pinged at:

http://&lt;server&nbsp;name&gt;:&lt;server.port&gt;/ping, e.g.

    http://localhost:9010/ping

The health check can be reached at:

http://&lt;server&nbsp;name&gt;:&lt;server.port&gt;/report/health e.g.

    http://localhost:9010/report/health

which returns a json response, e.g.

**json**
<pre>
{
    "application name" : "p1",
    "version" : "4.03",
    "name" : "p1-check",
    "Result" : {
        "isHealthy" : "true",
        "message" : "",
        "error" : ""
    }
}
</pre>

Use PDF Renderer to render a PDF file :
---------------------------------------

which returns a PDF as a byte stream.

Use PDF Renderer to render a HTML file
--------------------------------------

which returns HTML as a byte stream 

Testing the PDF Renderer
------------------------
There are a number of tools that can be used to make sending specific
requests to the service easier:

**Advanced REST Client** (for chrome - <https://advancedrestclient.com/>), which is
friendly and easy to use, and can save the responses to a file

Example

<table>
    <tr><td>URL</td><td>http://127.0.0.1:9010/html</td></tr>
</table>
Parameters
<table>
    <tr><td>transactionid</td><td>123456</td></tr>
    <tr><td>reportname</td><td>reportClaimWithSummary</td></tr>
    <tr><td>reportversion</td><td>0.26</td></tr>
    <tr><td>xml</td><td>paste the claim.xml into the field (it is quite large)</td></tr>
</table>

and click send, the response will come back as HTML

similarly if you change the url to http://127.0.0.1:9010/pdf

### **Example Files**

**[claim.xml](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/docs/examples/claim.xml)**

**[claim.html](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/docs/examples/claim.html)**

**[claim.pdf](https://github.com/Department-for-Work-and-Pensions/pdfRenderer/docs/examples/claim.pdf)**

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
