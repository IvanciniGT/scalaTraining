package com.training
package game.srh.impl

import game.srh.SRHGameStatus
import game.srh.SRHGameUI
import game.Winner

import scala.io.StdIn
object  SRHGameConsoleUI extends  SRHGameUI {
  def displayGameResult(gameStatus: SRHGameStatus):Unit = {
    println("Computer guess: " + gameStatus.computerGuess)
    println("Your guess:     " + gameStatus.playerGuess)
    gameStatus.winner.get match {
      case Winner.Player => println("You win! Congratulations!")
      case Winner.Computer => println("You lose! Maybe next time!")
      case Winner.Tie => println("It's a tie! Good match!")
    }
  }
  def getGuess(gameStatus: SRHGameStatus):String = {
    var response : Option[String] = None
    while (response.isEmpty) {
      print("Please enter your guess: ")
      val guess = StdIn.readLine().toLowerCase

      response = gameStatus.possibleGuesses.find( possibleGuess => possibleGuess.toLowerCase().startsWith(guess))
      if (response.isEmpty) {
        print("Invalid guess, you should choose between:")
        options(gameStatus.possibleGuesses)
      }
    }
    response.get
  }
  def welcome(gameStatus: SRHGameStatus, gameName:String) :Unit = {
    println(s"Welcome to the classic ${gameName} Game")
    print("You have to choose between:")
    options(gameStatus.possibleGuesses)
  }

  private def options(options:List[String]): Unit = {
    options.foreach(guess => print(s" (${guess(0).toUpper})${guess.substring(1)}"))
    println()
  }
}
