package com.training
package game.ui

import scala.io.StdIn
import game.Game
import game.PlayAgainResponse
object ApplicationConsoleUI extends ApplicationUI {

  def askToPlayAgain(): PlayAgainResponse.Response = {
    println("Do you want to play again his game? (Y/N)")
    val response = StdIn.readLine()
    if (response.toUpperCase() == "Y") {
      PlayAgainResponse.SAME_GAME
    } else {
      println("Do you want to play another game? (Y/N)")
      val response = StdIn.readLine()
      if (response.toUpperCase() == "Y") {
        PlayAgainResponse.ANOTHER_GAME
      } else {
        PlayAgainResponse.QUIT
      }
    }
  }

  def getGameToPlay(games: List[Game]): Game = {
    println("Please select the game you want to play:")
    games.zipWithIndex.foreach {
      case (game, index) => println(s"${index + 1} - ${game.getGameName()}")
    }
    val gameIndex = StdIn.readInt()
    games(gameIndex - 1)
  }

  def getPlayerName(): String = {
    println("Please enter your name:")
    val playerName = StdIn.readLine()
    playerName
  }
}
