package com.training
package com.dictionary
import scala.collection.parallel.ParSeq

import scala.collection.mutable
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

  def calculateDistance(s1: String, s2: String):Int = levenshtein(s1, s2)(s1.length, s2.length)

  private def levenshtein(s1: String, s2: String): mutable.Map[(Int, Int), Int] = {
    val memoizedCosts = mutable.Map[(Int, Int), Int]()

    def lev: ((Int, Int)) => Int = {
      case (k1, k2) =>
        memoizedCosts.getOrElseUpdate((k1, k2), (k1, k2) match {
          case (i, 0) => i
          case (0, j) => j
          case (i, j) =>
            ParSeq(1 + lev((i - 1, j)),
              1 + lev((i, j - 1)),
              lev((i - 1, j - 1))
                + (if (s1(i - 1) != s2(j - 1)) 1 else 0)).min
        })
    }

    lev((s1.length, s2.length))
    memoizedCosts
  }


}