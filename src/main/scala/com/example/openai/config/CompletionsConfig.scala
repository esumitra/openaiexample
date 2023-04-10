package com.example.openai.config
import pureconfig._
import pureconfig.generic.auto._

final case class CompletionsConfig(
  model: String,
  temperature: Double
)

object CompletionsConfig:
  given testConfigReader: ConfigReader[CompletionsConfig] =
    ConfigReader.forProduct2("model", "temperature")(CompletionsConfig.apply)
  val confPath = "com.example.openai.completions"
  val conf = ConfigUtils.loadConfigAtPath[CompletionsConfig](confPath)

