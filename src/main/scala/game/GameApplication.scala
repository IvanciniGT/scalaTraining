package com.training
package game

import game.hangman.impl.ClassicalConsoleHangmanGameCountriesEdition
import game.ui.ApplicationConsoleUI
import scala.io.StdIn
object GameApplication {

  def main(args: Array[String]): Unit = {
    // Ask the player name
    val player = new Player(ApplicationConsoleUI.getPlayerName())
    // Ask for the game to play
    while(true) {
      ClassicalConsoleHangmanGameCountriesEdition.play(player)
      println("Do you want to play again this game? (y/n)")
      val answer = StdIn.readLine()
      if (answer != "y") {
        println("Do you want to play another game? (y/n)")
        val answer = StdIn.readLine()
        if (answer != "y") {
          println("Bye bye")
          System.exit(0)
        }
      }
    }
    // update player statistics
    // Ask if the player wants to play again (same game or another one)
  }

}
