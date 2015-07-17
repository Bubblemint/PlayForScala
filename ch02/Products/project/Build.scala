import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName         = "products"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "net.sf.barcode4j" % "barcode4j" % "2.0"
  )

  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(
    version := appVersion,
    libraryDependencies ++= appDependencies
  )

}