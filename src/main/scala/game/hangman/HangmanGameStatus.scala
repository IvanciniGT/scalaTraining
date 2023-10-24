package com.training
package game.hangman

import scala.collection.mutable.ListBuffer
import game.GameStatus
/*
enum Winner { // Scala 3 syntax
  case Player
  case Computer
}
*/


class HangmanGameStatus (val targetWord: String, var remainingAttempts: Int) extends GameStatus {

  private val _playedChars: ListBuffer[Char] = ListBuffer()
  def newPlayedChar(char: Char): Unit = this._playedChars += char
  def playedChars():List[Char] = this._playedChars.toList // inmutable
}
