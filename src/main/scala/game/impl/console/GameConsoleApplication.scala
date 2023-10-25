package com.training
package game.impl.console

object  GameConsoleApplication extends GameApplication ( ApplicationConsoleUI ){

  val games = List(
    ClassicalConsoleHangmanGameCountriesEdition
  )

  def main(args: Array[String]): Unit = {
    startPlaying(games)
  }
}
