package com.training
package com.dictionary

import org.scalatest.funspec.FunSpec

class DictionarySpecTest extends FunSpec {

  describe("A language dictionary") {
    describe("when the language exists") {
      var dictionary: Option[Dictionary] = None
      it("should be retrieved") {
        val language = "spanish"
        dictionary= Dictionary.getDictionary(language)
        assert(dictionary.isDefined)
        assert(dictionary.get.getLanguage() == language)
      }
      it("should be able to check if a word exists") {
        assert(dictionary.get.exists("lkjadkl"))
      }
      it("should be able to check if a word does not exist") {
        assert(!dictionary.get.exists("askljhdsjkhga"))
      }
    }
    describe ("when the language does not exists") {
      it("should not be retrieved") {
        val language = "non-existing-language"
        val dictionary = Dictionary.getDictionary(language)
        assert(dictionary.isEmpty)
      }
    }
  }

}