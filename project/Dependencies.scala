import sbt._

object Dependencies {

  val circeVersion = "0.14.1"
  val pureconfigVersion = "0.17.3"
  val catsVersion = "2.7.0"
  val sttpVersion = "3.3.18"
  val loggingVersion = "3.9.4"
  val scalaTestVersion = "3.2.10"
  val openaiVersion = "0.2.0"

  lazy val scalaTest = Seq(
    "org.scalatest" %% "scalatest" % scalaTestVersion % Test
  )

  lazy val core = Seq(
    // cats FP libary
    "org.typelevel" % "cats-core_3" % catsVersion,

    // zio-openai
    "dev.zio" %% "zio-openai" % openaiVersion,
    
    // support for JSON formats
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,

    // support for typesafe configuration
    "com.github.pureconfig" %% "pureconfig-core" % pureconfigVersion,
    
    // logging
    "com.typesafe.scala-logging" %% "scala-logging" % loggingVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.3"
  )
}
