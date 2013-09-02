package net.masterthought.cucumber.sbt

import java.io.File
import java.lang.String

case class Output(prettyReport: Boolean, htmlReport: Boolean, junitReport: Boolean, jsonReport: Boolean,
                  prettyReportFile: File, htmlReportDir: File, junitReportFile: File, jsonReportFile: File) {

  def options: List[String] = {
    (if (prettyReport) {
      prettyReportFile.getParentFile.mkdirs()
      "--format" :: "progress" :: Nil
    }
    else Nil) ++
      (if ( htmlReport) {
        htmlReportDir.mkdirs()
        "--format" :: "html:%s".format(htmlReportDir.getPath) :: Nil
      } else Nil) ++
      (if ( junitReport) {
        junitReportFile.getParentFile.mkdirs()
        "--format" :: "junit:%s".format(junitReportFile.getPath) :: Nil
      } else Nil) ++
      (if ( jsonReport) {
        jsonReportFile.getParentFile.mkdirs()
        "--format" :: "json-pretty:%s".format(jsonReportFile.getPath) :: Nil
      } else Nil)
  }
}
