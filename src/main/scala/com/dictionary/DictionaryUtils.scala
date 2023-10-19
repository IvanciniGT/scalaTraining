package com.training
package com.dictionary
import scala.io.Source

object DictionaryUtils {

  val MAX_WORDS_TO_SUGGEST = 10
  val MAX_ALLOWED_DISTANCE = 3

  def normalizeWord(word:String): String = word.toLowerCase().trim()

  def readDictionaryFile(language:String): Map[String, Array[String]] ={
    val filename = "src/main/resources/"+language+".txt"
    val fileChannel = Source.fromFile(filename)
    val termsMap = fileChannel.getLines()
      .map( sentence => sentence.split("=") )
      .map( array => (normalizeWord(array(0)), array(1)) )
      .map( tuple => (tuple._1, tuple._2.split("\\|")))
      .toMap
    fileChannel.close()
    termsMap
  }
  private def minimum(i: Int*): Int = i.min

  def calculateDistance(s1: String, s2: String): Int = {
    val dist = Array.tabulate(s2.length + 1, s1.length + 1) { (j, i) => if (j == 0) i else if (i == 0) j else 0 }
    for {j <- dist.indices.tail
         i <- dist(0).indices.tail} dist(j)(i) =
      if (s2(j - 1) == s1(i - 1)) dist(j - 1)(i - 1)
      else minimum(dist(j - 1)(i) + 1, dist(j)(i - 1) + 1, dist(j - 1)(i - 1) + 1)
    dist(s2.length)(s1.length)
  }

}