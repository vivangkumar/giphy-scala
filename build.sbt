name := "giphy-scala"

version := "0.0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.scalaj" %% "scalaj-http" % "1.1.4",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.json4s" %% "json4s-native" % "3.2.11"
)