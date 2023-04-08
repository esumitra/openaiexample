package com.example.openai

import zio.{Console, ZIO, ZIOAppDefault}
import zio.openai._
import zio.openai.model.CreateCompletionRequest.Prompt
import zio.openai.model.Temperature

object Quickstart extends ZIOAppDefault {

  def generatePrompt(animal: String): Prompt =
    Prompt.String {
      s"""Suggest three names for an animal that is a superhero.
         |
         |Animal: Cat
         |Names: Captain Sharpclaw, Agent Fluffball, The Incredible Feline
         |Animal: Dog
         |Names: Ruff the Protector, Wonder Canine, Sir Barks-a-Lot
         |Animal: ${animal.capitalize}
         |Names:""".stripMargin
    }

  def loop =
    for {
      animal <- Console.readLine("Animal: ")
      result <- Completions.createCompletion(
        model = "text-davinci-003",
        prompt = generatePrompt(animal),
        temperature = Temperature(0.6)
      )
      _ <- Console.printLine("Names: " + result.choices.flatMap(_.text.toOption).mkString(", "))
    } yield ()

  override def run =
    loop.forever.provide(Completions.default)
}