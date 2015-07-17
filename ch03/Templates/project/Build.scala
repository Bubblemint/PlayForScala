import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName         = "templates"
  val appVersion      = "0.1"

  val appDependencies = Seq(

  )

  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(
    version := appVersion,
    libraryDependencies ++= appDependencies
  )

}