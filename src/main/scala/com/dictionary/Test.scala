package com.training
package com.dictionary

object Test {
  def main(args: Array[String]): Unit = {
    val language = "spanish"
    val terms = DictionaryUtils.readDictionaryFile(language)
    val dictionary = new DictionaryImpl(language, terms)

    val word = "hotel"

    println(dictionary.exists(word))
    val optionalDefinitions = dictionary.getDefinitions(word)
    if(optionalDefinitions.isDefined)
      println(optionalDefinitions.get.toList)
    println(dictionary.getSuggestions(word).toList)
  }
}
