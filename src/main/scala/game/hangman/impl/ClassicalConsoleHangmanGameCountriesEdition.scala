package com.training
package game.hangman.impl

import scala.io.Source
import game.Player
import game.Winner
import game.hangman.AbstractHangmanGame

class ClassicalConsoleHangmanGame protected (filename:String, val name: String) extends AbstractHangmanGame (HangmanGameLogicImpl, HangmanGameConsoleUI){
  def readFileLines(file:String): List[String] = {
    val fileChannel = Source.fromFile (file)
    val lines = fileChannel.getLines().toList
    fileChannel.close ()
    lines
  }
  def wordsSet():List[String] ={
    readFileLines("src/main/resources/"+filename+".txt")
  }

  override def play(player: Player): Winner.Winner = super.play(player, wordsSet())

  override def getGameName(): String = this.name
}
object ClassicalConsoleHangmanGameCountriesEdition extends ClassicalConsoleHangmanGame ("countries", "Classical Hangman Game (Countries Edition)")