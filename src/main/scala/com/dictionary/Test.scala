package com.training
package com.dictionary

object Test {
  def main(args: Array[String]): Unit = {
    val language = "spanish"
    val terms = DictionaryUtils.readDictionaryFile(language)
    val dictionary = new DictionaryImpl(language, terms)

    val word = "avion"

    println(dictionary.exists(word))
    val optionalDefinitions = dictionary.getDefinitions(word)
    if(optionalDefinitions.isDefined)
      println(optionalDefinitions.get.toList)
  // calulate distance 200 times to warm up the JVM
    for(i <- 1 to 200)
      dictionary.getSuggestions(word).toList
    // Measure times
    val start = System.currentTimeMillis()
    println(dictionary.getSuggestions(word).toList)
    val end = System.currentTimeMillis()
    println("Time: "+(end-start))
  }
}
