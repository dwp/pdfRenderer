import sbt._
import sbt.Keys._
import com.typesafe.config._

object ApplicationBuild extends Build {

  val appName = "p1"
  val appVersion = "1.0-SNAPSHOT"

  var repo: Seq[Project.Setting[_]] = Seq(resolvers += "Carers repo" at "http://build.3cbeta.co.uk:8080/artifactory/repo/")


  val appDependencies = Seq(
    "me.moocar" % "logback-gelf" % "0.9.6p2",
    "org.specs2" %% "specs2" % "2.3.6" % "test",
    "net.sf.jasperreports" % "jasperreports" % "5.2.0",
    "com.dwp.carers" %%  "carerscommon" % "5.4",
    "com.lowagie" % "itext" % "4.2.1",
    "com.itextpdf" % "itextpdf" % "5.4.4",
    "xalan" % "xalan" % "2.7.1",
    "org.codehaus.groovy" % "groovy-all" % "2.0.1"
  )

  val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()

  val cleanjspr = TaskKey[Unit]("clean-j", "Cleans jasper reports compiled files")

  val cleanjsprTask = cleanjspr := {
    val jasperFolder    = conf.getString("jasper.folder")
    val files = new File(jasperFolder).listFiles().filter(_.name.endsWith(".jasper")).filter(_.delete)
    println("Removed files:")
    files map(p=>println(p))
  }

  var sV: Seq[Project.Setting[_]] = Seq(scalaVersion := "2.10.3")
  val compilerSettings: Seq[Project.Setting[_]] = Seq(scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8","-feature"))

  var appSettings: Seq[Project.Setting[_]] = repo ++ sV ++ compilerSettings ++ cleanjsprTask

  val main = play.Project(appName, appVersion, appDependencies).settings(appSettings: _*)

}