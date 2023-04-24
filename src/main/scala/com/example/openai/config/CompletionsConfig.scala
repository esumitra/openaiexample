package com.example.openai.config
import pureconfig._
import pureconfig.generic.derivation.default._

final case class CompletionsConfig(
  model: String,
  temperature: Double
) derives ConfigReader // using Scala 3 type class derivation See https://docs.scala-lang.org/scala3/reference/contextual/derivation.html

object CompletionsConfig:
  val confPath = "com.example.openai.completions"
  val conf = ConfigUtils.loadConfigAtPath[CompletionsConfig](confPath)

