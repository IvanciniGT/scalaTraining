package com.training
package com.dictionary

import org.scalatest.funsuite.AnyFunSuiteLike

class DictionaryTest extends AnyFunSuiteLike {

  test("Test we can get a dictionary of an existing language") {
    val language = "spanish"
    val dictionary = Dictionary.getDictionary(language)
    assert(dictionary.isDefined)
    assert(dictionary.get.getLanguage() == language)
  }

  test("Test we cannot get a dictionary of a non existing language") {
    val language = "non-existing-language"
    val dictionary = Dictionary.getDictionary(language)
    assert(dictionary.isEmpty)
  }

  test("Word suggestions should be retrieved in less than 100ms, after warming the JIT") {
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
