/**
  * main entry point for application
  */

package com.example.openai

import com.example.openai.config.{ConfigUtils}
import pureconfig._
import pureconfig.generic.auto._
// import pureconfig.generic.derivation.default._
import com.typesafe.scalalogging.{LazyLogging}

case class CookieSettings(
  domain: String,
  path: String,
  ttl: Long
)

// automatic derivation not supported for scala3, need to use forProductN methods
object CookieSettings:
  given testConfigReader: ConfigReader[CookieSettings] =
    ConfigReader.forProduct3("domain", "path", "ttl")(CookieSettings.apply)

object MainApp extends LazyLogging {

  val COOKIE_CONFIG_PATH="com.example.openai.cookie"

  def hello(name: String): String = s"Hello ${name}"

  def main(args: Array[String]): Unit = {
    val cookie = ConfigUtils.loadConfigAtPath[CookieSettings](COOKIE_CONFIG_PATH)
    logger.info(s"running application version with ttl: ${cookie.ttl}")

    val message = args.length match {
      case 0 => hello("Anonymous")
      case _ => hello(args(0))
    }
    println(message)
  }
}
