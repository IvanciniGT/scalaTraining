package com.training
package  hangman
import game.GameLogic

trait HangmanGameLogic extends GameLogic {
  def startGame(setOfAllowedWords: List[String]):HangmanGameStatus
  def newChar(newChar:Char, currentStatus:HangmanGameStatus):HangmanGameStatus
}
