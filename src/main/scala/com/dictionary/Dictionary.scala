package com.training
package com.dictionary

import scala.collection.mutable
import scala.collection.parallel.CollectionConverters.ImmutableIterableIsParallelizable
import scala.io.Source

trait Dictionary {
  def getLanguage(): String
  def exists(word:String): Boolean

  // What if I ask (using the english dictionary) for the word "askljhdsjkhga"?
  // This function has a clear purpose... to bring the definitions of an existing word
  // In case a word does not exist, it could throw an exception... it could return an empty array... it could return null
  // The option word... means that it could return an array of strings or it could return nothing (nor null nor empty array)
  def getDefinitions(word:String): Option[Array[String]]  // Optional Java 1.8

  def getSuggestions(word:String): Array[String]
}

object Dictionary {
  def getDictionary(language:String): Dictionary = {
    DictionaryImpl.getDictionary(language)
  }
}

private class DictionaryImpl private (private val language:String , private val terms:Map[String, Array[String]]) extends Dictionary{

  private val termsPar = terms.keys.toList.par
  override def getLanguage(): String = language

  override def exists(word: String): Boolean = terms.contains(DictionaryImpl.normalizeWord(word))

  override def getDefinitions(word: String): Option[Array[String]] = if(exists(word)) Some(terms(DictionaryImpl.normalizeWord(word))) else None

  override def getSuggestions(word: String): Array[String] = {
    // We need to apply this function to all the terms in the dictionary
    // -> this returns distances
    // We need to sort terms by distance
    // we will get ... let's say 10 terms
    val wordToCompare = DictionaryImpl.normalizeWord(word)
    // Comparing word "dictionary" with word "car"   dictionary contains 10 chars... We will compare only with words from 7 to 13 chars
    termsPar
      .filter(term => Math.abs(term.length - wordToCompare.length) < DictionaryImpl.MAX_ALLOWED_DISTANCE)
      .map(term => (term, DictionaryImpl.calculateDistance(wordToCompare, term)))
      .filter(tuple => tuple._2 < DictionaryImpl.MAX_ALLOWED_DISTANCE)
      .toList
      .sortBy(tuple => tuple._2)
      .take(DictionaryImpl.MAX_WORDS_TO_SUGGEST)
      .map(tuple => tuple._1)
      .toArray
  }

}

private object DictionaryImpl {

  private val MAX_WORDS_TO_SUGGEST = 10
  private val MAX_ALLOWED_DISTANCE = 3

  private val cached_dictionaries: mutable.WeakHashMap[String, Dictionary] = mutable.WeakHashMap[String, Dictionary]()

  def getDictionary(language:String): Dictionary = {
    if(!cached_dictionaries.contains(language)) {
      val terms = readDictionaryFile(language)
      val newDict = new DictionaryImpl(language, terms)
      cached_dictionaries.addOne(language , newDict)
    }
    cached_dictionaries(language)
  }
  private def normalizeWord(word:String): String = word.toLowerCase().trim()


  private def readDictionaryFile(language:String): Map[String, Array[String]] ={
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

  private def calculateDistance(s1: String, s2: String): Int = {
    val dist = Array.tabulate(s2.length + 1, s1.length + 1) { (j, i) => if (j == 0) i else if (i == 0) j else 0 }
    for {j <- dist.indices.tail
         i <- dist(0).indices.tail} dist(j)(i) =
      if (s2(j - 1) == s1(i - 1)) dist(j - 1)(i - 1)
      else minimum(dist(j - 1)(i) + 1, dist(j)(i - 1) + 1, dist(j - 1)(i - 1) + 1)
    dist(s2.length)(s1.length)
  }

}