package com.training
package game

import game.statistics.PlayedGame
trait ApplicationUI {
  def showStatistics(value: List[PlayedGame]): Unit
  def askToPlayAgain(): PlayAgainResponse.Response
  def getGameToPlay(games: List[Game]): Game
  def getPlayerName(): String
}
