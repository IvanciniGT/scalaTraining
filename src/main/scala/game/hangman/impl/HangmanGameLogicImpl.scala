package com.training
package game.hangman.impl

import game.hangman.HangmanGameStatus
import game.hangman.HangmanGameLogic

import game.Winner

import scala.util.Random

object HangmanGameLogicImpl extends HangmanGameLogic {

  private val MAX_FAILURES: Int = 6
  // HEAD, BODY, ARMS x2  LEGS x2

  def startGame(setOfAllowedWords: List[String]):HangmanGameStatus={
    val selectedWord = setOfAllowedWords(Random.nextInt(setOfAllowedWords.size))
    new HangmanGameStatus(selectedWord, MAX_FAILURES)
  }
  def newChar(newChar:Char, currentStatus:HangmanGameStatus):HangmanGameStatus={
    if(currentStatus.isGameOver()) throw new IllegalStateException("Game is over")
    currentStatus.newPlayedChar(newChar)
    if (!currentStatus.targetWord.contains(newChar)) {
      currentStatus.remainingAttempts -= 1
    }
    currentStatus.targetWord.count(c => !currentStatus.playedChars().contains(c) && c != ' ') match {
      case 0 => currentStatus.winner = Winner.Player
      case _ => if (currentStatus.remainingAttempts == 0) currentStatus.winner = Winner.Computer
    }
    currentStatus
  }
}
