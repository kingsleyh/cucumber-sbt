package net.masterthought.cucumber.sbt

import java.io.File

case class Options(featuresLocation: String,
                   basePackage: String,
                   extraOptions: List[String],
                   beforeFunc: () => Unit,
                   afterFunc: () => Unit) {

  def featuresPresent = featuresLocation.startsWith("classpath:") || (new File(featuresLocation).exists)
}

