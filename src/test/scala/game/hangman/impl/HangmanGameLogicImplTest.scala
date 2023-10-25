package com.training
package game.hangman.impl

import org.scalatest.funspec.FunSpec

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}
import scala.util.control._

class HangmanGameLogicImplTest extends FunSpec {

  describe("startGame") {
    it("should return a HangmanGameStatus") {
      val words = List("word1", "word2", "word3")
      //var usedWords = ListBuffer[String]()
      var usedWords = scala.collection.mutable.Set[String]()
      // 100 times
      //val loop1 = new Breaks;
      //loop1.breakable {
      breakable {
        for (i <- 1 to 100) {
          val result = HangmanGameLogicImpl.startGame(words)
          assert(result.winner.isEmpty)
          assert(!result.isGameOver())
          assert(result.targetWord != null)
          assert(result.playedChars().isEmpty)
          assert(result.remainingAttempts == 6)
          assert(words.contains(result.targetWord))
          //if (!usedWords.contains(result.targetWord)) {
            usedWords += result.targetWord
            if (usedWords.size == words.size) break // loop1.break
          //}
        }
      }
      assert(usedWords.size == words.size)
    }
  }

}
