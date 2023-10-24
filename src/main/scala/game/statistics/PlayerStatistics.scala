package com.training
package game.statistics

import game.Winner
import game.Player
class PlayerStatistics (val player: Player, val playedGames: List[PlayedGamed]){

  def getWonGames(): List[PlayedGamed] = playedGames.filter( playedGame => playedGame.result == Winner.Player)

  def getLostGames(): List[PlayedGamed] = playedGames.filter( playedGame => playedGame.result == Winner.Computer)

  def getDrawGames(): List[PlayedGamed] = playedGames.filter( playedGame => playedGame.result == Winner.NoOne)

  def getWinningPercentage(): Double = getWonGames().size / getPlayedGames().size

  def getLosingPercentage(): Double = getLostGames().size / getPlayedGames().size
}
