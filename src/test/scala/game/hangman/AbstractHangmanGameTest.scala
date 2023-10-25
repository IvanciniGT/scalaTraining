package com.training
package game.hangman

import org.scalatest.funspec.FunSpec
import game.Player
import game.Winner

object HangmanGameLogicFake extends HangmanGameLogic {
  var word: String = null
  override def startGame(setOfAllowedWords: List[String]): HangmanGameStatus = {
    word = setOfAllowedWords(0)
    new HangmanGameStatus(word, 5)
  }

  override def newChar(newChar: Char, currentStatus: HangmanGameStatus): HangmanGameStatus = {
    if(!word.contains(newChar))
      currentStatus.remainingAttempts -= 1
    currentStatus.newPlayedChar(newChar)
    currentStatus.remainingAttempts match {
      case 0 => currentStatus.winner = Winner.Computer
      case _ => if (currentStatus.targetWord.forall(currentStatus.playedChars().contains(_))) currentStatus.winner = Winner.Player
    }
    currentStatus
  }
}
object HangmanGameUIFake extends HangmanGameUI {
    var word: String = ""
  var counter: Int = 0
  override def gameStart(gameStatus: HangmanGameStatus): Unit = {}
  override def gameEnd(gameStatus: HangmanGameStatus): Unit = {}
  override def askForNewChar(): Char = {
    val toReturn = word.charAt(counter)
    counter += 1
    toReturn
  }
  override def provideCharFeedBack(char: Char, gameStatus: HangmanGameStatus): Unit = {}
  override def showGameStatus(gameStatus: HangmanGameStatus): Unit = {}
}

class HangmanGame extends AbstractHangmanGame( HangmanGameLogicFake, HangmanGameUIFake ) {
  override def play(player: Player): Winner.Winner = Winner.Computer
  override def getGameName(): String = "Hangman"
}

class AbstractHangmanGameTest extends FunSpec {

  describe("play") {
    it("should return Player, if the player guess the word") {
      val game = new HangmanGame()
      val player = new Player("Player1")
      HangmanGameUIFake.word = "waorryd"

      val winner = game.play(player: Player, List("word"))
      assert(winner == Winner.Player)
    }
    it("should return Computer, if the player does not guess the word") {
      val game = new HangmanGame()
      val player = new Player("Player1")
      HangmanGameUIFake.word = "abcdefghklamdhja"

      val winner = game.play(player: Player, List("word"))
      assert(winner == Winner.Computer)
    }
  }
}
