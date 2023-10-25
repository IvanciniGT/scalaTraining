package com.training
package game.ui

import game.Game
import game.PlayAgainResponse

trait ApplicationUI {
  def askToPlayAgain(): PlayAgainResponse.Response
  def getGameToPlay(games: List[Game]): Game
  def getPlayerName(): String
}
