import sbt._
import sbt.Keys._
import com.typesafe.config._
import org.scalastyle.sbt.ScalastylePlugin
import play.sbt.Play.autoImport._
import utils.ConfigurationChangeHelper._

object ApplicationBuild extends Build {
  val appName = "p1"
  val appVersion = "2.6-SNAPSHOT"

  processConfFiles(Seq("conf/application-info.conf"), Seq("application.version" -> appVersion, "application.name" -> appName))

  var repo: Seq[Def.Setting[_]] = Seq(resolvers += "Carers repo" at "http://build.3cbeta.co.uk:8080/artifactory/repo/",
  resolvers += "Jaspersoft repo" at "http://jaspersoft.artifactoryonline.com/jaspersoft/third-party-ce-artifacts/",
  resolvers += "Jasper" at "http://jasperreports.sourceforge.net/maven2")

  val appDependencies = Seq(
    filters,
    "me.moocar"             % "logback-gelf"          % "0.12",
    "net.sf.jasperreports"  % "jasperreports"         % "5.6.1",
    "com.itextpdf"          % "itextpdf"              % "5.5.4",
    "org.codehaus.groovy"   % "groovy-all"            % "2.3.9",
    "xalan"                 % "xalan"                 % "2.7.2",
    "gov.dwp.carers"        %% "carerscommon"         % "7.7",
    "commons-io"            % "commons-io"            % "2.4",
    "org.specs2" %% "specs2-core" % "3.3.1" % "test" withSources() withJavadoc(),
    "org.specs2" %% "specs2-mock" % "3.3.1" % "test" withSources() withJavadoc(),
    "org.specs2" %% "specs2-junit" % "3.3.1" % "test" withSources() withJavadoc(),
    "com.kenshoo" % "metrics-play_2.10" % "2.4.0_0.4.0"
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
  var sV: Seq[Def.Setting[_]] = Seq(scalaVersion := "2.10.5")
  val compilerSettings: Seq[Def.Setting[_]] = Seq(scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8","-feature"))

  var vS: Seq[Def.Setting[_]] = Seq(version := appVersion, libraryDependencies ++= appDependencies)

  var appSettings: Seq[Def.Setting[_]] = repo ++ sV ++ compilerSettings ++ sJ ++ ScalastylePlugin.Settings ++ vS ++ cleanjsprTask ++ net.virtualvoid.sbt.graph.Plugin.graphSettings

  val main = Project(appName, file(".")).enablePlugins(play.sbt.PlayScala).settings(appSettings: _*)

}
