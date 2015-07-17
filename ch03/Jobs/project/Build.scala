import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName         = "jobs"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(

  )

  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(
    version := appVersion,
    libraryDependencies ++= appDependencies
  )

}