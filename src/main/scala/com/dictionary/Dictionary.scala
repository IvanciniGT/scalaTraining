package com.training
package com.dictionary

trait Dictionary {
  def getLanguage(): String
  def exists(word:String): Boolean

  // What if I ask (using the english dictionary) for the word "askljhdsjkhga"?
  // This function has a clear purpose... to bring the definitions of an existing word
  // In case a word does not exist, it could throw an exception... it could return an empty array... it could return null
  // The option word... means that it could return an array of strings or it could return nothing (nor null nor empty array)
  def getDefinitions(word:String): Option[Array[String]]

  def getSuggestions(word:String): Array[String]
}
