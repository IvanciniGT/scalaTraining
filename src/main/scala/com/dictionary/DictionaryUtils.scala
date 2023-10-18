package com.training
package com.dictionary

import scala.io.Source

object DictionaryUtils {

  def readDictionaryFile(language:String): Map[String, Array[String]] ={
    val filename = "src/main/resources/"+language+".txt"
    val fileChannel = Source.fromFile(filename)
    val termsMap = fileChannel.getLines()
      .map( sentence => sentence.split("=") )
      .map( array => (array(0), array(1)) )
      .map( tuple => (tuple._1, tuple._2.split("\\|")))
      .toMap
    fileChannel.close()
    termsMap
  }
}
object Test {
  def main(args: Array[String]): Unit = {
    DictionaryUtils.readDictionaryFile("english")
  }
}
