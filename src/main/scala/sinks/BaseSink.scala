package sinks

import config.AppConfig
import org.apache.spark.sql.{DataFrame, SparkSession}

trait BaseSink {
  def put(spark: SparkSession, config: AppConfig, data: DataFrame): Boolean
}

object BaseSink {
  def apply(config: AppConfig): BaseSink = {
    val sinkType: String = config.conf.getConfig("source").getString("type")
    sinkType match {
      case "dummy" => DummySink
    }
  }
}