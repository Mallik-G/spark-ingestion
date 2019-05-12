package config

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Inspired by https://github.com/typesafehub/config/blob/master/examples/scala/simple-lib/src/main/scala/simplelib/SimpleLib.scala
  *
  * Fail fast when dealing with config values!
  */
class AppConfig(val conf: Config, val args: Map[String, String]) {

  //use default config on classpath if no config is passed here
  def this() {
    this(ConfigFactory.load(), Map.empty[String, String])
  }

  def isLocal: Boolean = args.get("--local").contains("true")
}
