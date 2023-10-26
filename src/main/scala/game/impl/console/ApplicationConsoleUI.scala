package com.training
package game.impl.console

import game.{Game, PlayAgainResponse}

import scala.io.StdIn
import game.ApplicationUI
import game.statistics.PlayedGame

import java.time.format.DateTimeFormatter
object ApplicationConsoleUI extends ApplicationUI {

  def askToPlayAgain(): PlayAgainResponse.Response = {
    println("Do you want to play again his game? [Y=Yes/N=No/S=Show statistics] (S)")
    val response = StdIn.readLine()
    if (response.toUpperCase() == "S" || response.isEmpty) {
      PlayAgainResponse.SHOW_STATISTICS
    } else if (response.toUpperCase() == "Y") {
      PlayAgainResponse.SAME_GAME
    } else {
      println("Do you want to play another game? [Y/N] (N)")
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

  override def showStatistics(value: List[PlayedGame]): Unit = {
    // We will print Game (Max 50 chars) | Result (Max 15 chars) | Date (Max 20 chars) in forma: dd-MM-yyyy HH:mm
    println("".padTo(50 + 15 + 20, '-'))
    println("Game".padTo(50, ' ') + "Winner".padTo(15, ' ') + "Date".padTo(20, ' '))
    println("".padTo(50 + 15 + 20, '-'))
    value.foreach { playedGame => {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
        val date = playedGame.date.format(formatter)
        println(playedGame.game.padTo(50, ' ')  + playedGame.result.toString.padTo(15, ' ')  + date.padTo(20, ' '))
      }
    }
    println("".padTo(50 + 15 + 20, '-'))
  }
}
