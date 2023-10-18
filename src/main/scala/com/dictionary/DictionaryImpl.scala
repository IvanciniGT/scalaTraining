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

  }

}
