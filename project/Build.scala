import sbt._
import sbt.Keys._
import com.typesafe.config._
import org.scalastyle.sbt.ScalastylePlugin

object ApplicationBuild extends Build {

  val appName = "p1"
  val appVersion = "1.1-SNAPSHOT"

  var repo: Seq[Def.Setting[_]] = Seq(resolvers += "Carers repo" at "http://build.3cbeta.co.uk:8080/artifactory/repo/")


  val appDependencies = Seq(
    "me.moocar"             % "logback-gelf"          % "0.12",
    "org.specs2"            %% "specs2"               % "2.3.13"     % "test",
    "net.sf.jasperreports"  % "jasperreports"         % "5.2.0",
    "com.lowagie"           % "itext"                 % "4.2.1",
    "com.itextpdf"          % "itextpdf"              % "5.4.4",
    "org.codehaus.groovy"   % "groovy-all"            % "2.3.7",
    "xalan"                 % "xalan"                 % "2.7.2",
    "com.dwp.carers"        %% "carerscommon"         % "6.2"
  )

  val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()

  val cleanjspr = TaskKey[Unit]("clean-j", "Cleans jasper reports compiled files")

  val cleanjsprTask = cleanjspr := {
    val jasperFolder    = conf.getString("jasper.folder")
    for (i <- 1 to 100) {
      try {
        new File(s"jasperFolder/0.$i").listFiles().filter(_.name.endsWith(".jasper")).filter(_.delete)
      } catch {
        case e: Exception => // do nothing. deleted all current versions
      }
    }
  }

  var sJ: Seq[Def.Setting[_]] = Seq(javaOptions in Test += "-Djava.awt.headless=true")
  var sV: Seq[Def.Setting[_]] = Seq(scalaVersion := "2.10.4")
  val compilerSettings: Seq[Def.Setting[_]] = Seq(scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8","-feature"))

  var vS: Seq[Def.Setting[_]] = Seq(version := appVersion, libraryDependencies ++= appDependencies)

  var appSettings: Seq[Def.Setting[_]] = repo ++ sV ++ compilerSettings ++ sJ ++ ScalastylePlugin.Settings ++ vS ++ cleanjsprTask


  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(appSettings: _*)

//  val main = Project(appName, appVersion, appDependencies).settings(appSettings: _*)

}