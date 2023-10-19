package com.training
package com.dictionary

import org.scalatest.flatspec.AnyFlatSpec

class DictionaryFlatTest extends AnyFlatSpec {

  "An existent dictionary" should "be retrieved" in { // REQUIREMENTS
    val language = "spanish"
    val dictionary = Dictionary.getDictionary(language)
    assert(dictionary.isDefined)
    assert(dictionary.get.getLanguage() == language)
  }

  "A non existent dictionary" should "not be retrieved" in { // REQUIREMENTS
    val language = "non-existing-language"
    val dictionary = Dictionary.getDictionary(language)
    assert(dictionary.isEmpty)
  }

  "Word suggestions" should "be retrieved in less than 150ms, after warming the JIT" in { // REQUIREMENTS
    val language = "spanish"
    val word = "paelaa" //plane
    val dictionary = Dictionary.getDictionary(language).get

    // Warm up the jit)
    for(i <- 1 to 200)
      dictionary.getSuggestions(word).toList

    // Measure times
    val start = System.currentTimeMillis()
    dictionary.getSuggestions(word).toList
    val end = System.currentTimeMillis()
    assert(end-start < 150)
  }
}
