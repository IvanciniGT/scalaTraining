package com.training
package game.hangman.impl

import scala.io.Source
import game.Player
import game.hangman.HangmanGameMatch

object ClassicalConsoleHangmanGameCountriesEdition{

  def readFileLines(file:String): List[String] = {
    val fileChannel = Source.fromFile (file)
    val lines = fileChannel.getLines().toList
    fileChannel.close ()
    lines
  }
  def wordsSet():List[String] ={
    readFileLines("src/main/resources/countries.txt")
  }

  def configureMatch(player: Player): Unit = {
    new HangmanGameMatch(player, HangmanGameLogicImpl, HangmanGameConsoleUI, wordsSet())
  }

}