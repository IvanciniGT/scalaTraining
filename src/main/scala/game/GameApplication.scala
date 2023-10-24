package com.training
package game

import game.hangman.impl.ClassicalConsoleHangmanGameCountriesEdition
object GameApplication {

  def main(args: Array[String]): Unit = {
    // Ask the player name
    val player = new Player("Ivan")
    // Ask for the game to play
    ClassicalConsoleHangmanGameCountriesEdition.play(player)
    // update player statistics
    // Ask if the player wants to play again (same game or another one)
  }

}