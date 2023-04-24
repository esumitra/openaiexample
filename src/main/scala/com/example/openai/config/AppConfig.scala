/**
  * Configuration utils
  */

package com.example.openai.config

import pureconfig._
import pureconfig.generic.derivation.default._

import scala.reflect.ClassTag

object ConfigUtils:
  def loadConfigAtPath[A: ConfigReader: ClassTag] (path: String): A =
    ConfigSource.default.at(path).loadOrThrow[A]
