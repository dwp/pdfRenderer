name := "pdfService"  

version := "0.0.1" 

scalaVersion := "2.10.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "JasperReports Repository" at "http://jasperreports.sourceforge.net/maven2/"

libraryDependencies += "org.specs2" %% "specs2" % "1.14" % "test"

libraryDependencies += "net.sf.jasperreports" % "jasperreports" % "5.2.0"

libraryDependencies += "xalan" % "xalan" % "2.7.1"

// for debugging sbt problems
//logLevel := Level.Debug