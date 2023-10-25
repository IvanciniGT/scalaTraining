package com.training
package game

import ui.ApplicationConsoleUI
import hangman.impl.ClassicalConsoleHangmanGameCountriesEdition
object  GameConsoleApplication extends GameApplication ( ApplicationConsoleUI ){

  val games = List(
    ClassicalConsoleHangmanGameCountriesEdition
  )

  def main(args: Array[String]): Unit = {
    startPlaying(games)
  }
}
