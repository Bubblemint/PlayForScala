name := "Slick"

version := "1.0"

scalaVersion := "2.11.1"

scalacOptions += "-deprecation"

libraryDependencies ++= List(
  "com.typesafe.slick" %% "slick" % "3.0.0",
  "ch.qos.logback" % "logback-classic" % "1.0.3",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  //  "org.slf4j" % "slf4j-api" % "1.6.4",
  "mysql" % "mysql-connector-java" % "5.1.35"
)
