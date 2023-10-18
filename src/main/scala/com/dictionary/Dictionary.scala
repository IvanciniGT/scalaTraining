package com.training
package com.dictionary

trait Dictionary {
  def getLanguage(): String
  def exists(word:String): Boolean
  def getDefinitions(word:String): Array[String]
  def getSuggestions(word:String): Array[String]
}
