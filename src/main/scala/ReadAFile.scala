package com.training;
import scala.io.Source
object ReadAFile {
  def main(args: Array[String]): Unit = {
    val filename = "src/main/resources/english.txt"
    val fileChannel = Source.fromFile(filename)
    for (line <- fileChannel.getLines()) {
      println(line)
    }
    fileChannel.close()
  }
}
