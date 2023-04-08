import Dependencies._

ThisBuild / organization := "com.example.openai"
ThisBuild / scalaVersion := "3.2.2"
ThisBuild / semanticdbEnabled := true // enable SemanticDB
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision // use Scalafix compatible version

lazy val root = (project in file(".")).
  settings(
    name := "OpenAIExample",
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:postfixOps"
      // "-language:higherKinds", // HKT required for Monads and other HKT types
      // "-Wunused", // for scalafix
    ),
    libraryDependencies ++= Dependencies.core ++ Dependencies.scalaTest,
    assembly / mainClass := Some("com.example.openai.MainApp"),
    assembly / assemblyJarName := "OpenAIExample.jar",
    assembly / test := {},
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case "application.conf"            => MergeStrategy.concat
      case x =>
        val oldStrategy = (assembly / assemblyMergeStrategy).value
        oldStrategy(x)
    }
  )
