package com.training
package game.impl.console

import game.GameApplication
import game.hangman.impl.ClassicalConsoleHangmanGameCountriesEdition
object  GameConsoleApplication extends GameApplication ( ApplicationConsoleUI, null){

  val games = List(
    ClassicalConsoleHangmanGameCountriesEdition
  )

  def main(args: Array[String]): Unit = {
    startPlaying(games)
  }
}
