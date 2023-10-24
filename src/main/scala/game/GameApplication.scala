package com.training
package game

import game.hangman.impl.ClassicalConsoleHangmanGameCountriesEdition
object GameApplication {

  def main(args: Array[String]): Unit = {
    val player = new Player("Ivan")
    ClassicalConsoleHangmanGameCountriesEdition.play(player)
  }

}
