package com.training
package com.dictionary

class DictionaryImpl (private val language:String , private val terms:Map[String, Array[String]]) extends Dictionary{

  override def getLanguage(): String = language

  override def exists(word: String): Boolean = terms.contains(DictionaryUtils.normalizeWord(word))

  override def getDefinitions(word: String): Option[Array[String]] = if(exists(word)) Some(terms(DictionaryUtils.normalizeWord(word))) else None

  override def getSuggestions(word: String): Array[String] = {
    // We need to apply this function to all the terms in the dictionary
    // -> this returns distances
    // We need to sort terms by distance
    // we will get ... let's say 10 terms
    val wordToCompare = DictionaryUtils.normalizeWord(word)
    // Comparing word "dictionary" with word "car"   dictionary contains 10 chars... We will compare only with words from 7 to 13 chars
    terms.keys
      .filter(term => Math.abs(term.length - wordToCompare.length) <= DictionaryUtils.MAX_ALLOWED_DISTANCE)
      .map(term => (term, DictionaryUtils.calculateDistance(wordToCompare, term)))
      .filter(tuple => tuple._2 <= DictionaryUtils.MAX_ALLOWED_DISTANCE)
      .toList
      .sortBy(tuple => tuple._2)
      .take(DictionaryUtils.MAX_WORDS_TO_SUGGEST)
      .map(tuple => tuple._1)
      .toArray

  }

}
