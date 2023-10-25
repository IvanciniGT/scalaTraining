package com.training
package game

trait ApplicationUI {
  def askToPlayAgain(): PlayAgainResponse.Response
  def getGameToPlay(games: List[Game]): Game
  def getPlayerName(): String
}
