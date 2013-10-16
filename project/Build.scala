import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName = "s2"
  val appVersion = "1.0-SNAPSHOT"

  var repo: Seq[Project.Setting[_]] = Seq(resolvers += "Carers repo" at "http://build.3cbeta.co.uk:8080/artifactory/repo/")

  val appDependencies = Seq(
    "com.dwp.carers" % "carersXMLValidation" % "0.15.2",
    "me.moocar" % "logback-gelf" % "0.9.6p2",
    "org.specs2" %% "specs2" % "1.14" % "test",
    "net.sf.jasperreports" % "jasperreports" % "5.2.0",
    "com.lowagie" % "itext" % "4.2.1",
    "com.itextpdf" % "itextpdf" % "5.4.4",
    "org.codehaus.groovy" % "groovy-all" % "2.0.1",
    "xalan" % "xalan" % "2.7.1"
  )

  val sampleStringTask = System.getProperty("sbt.carers.keystore")
  var testSettings: Seq[Project.Setting[_]] = Seq(javaOptions in Test += ("-Dcarers.keystore=" + sampleStringTask))
  var sV: Seq[Project.Setting[_]] = Seq(scalaVersion := "2.10.2")
  var appSettings: Seq[Project.Setting[_]] = repo ++ testSettings ++ sV

  val main = play.Project(appName, appVersion, appDependencies).settings(appSettings: _*)

}
