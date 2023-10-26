package com.training
package game.statistics

import game.Winner
import game.Player

import java.io.Serializable
class PlayerStatistics (val player: Player, val playedGames: List[PlayedGame]) extends Serializable{

  def getWonGames(): List[PlayedGame] = playedGames.filter(playedGame => playedGame.result == Winner.Player)

  def getLostGames(): List[PlayedGame] = playedGames.filter(playedGame => playedGame.result == Winner.Computer)

  def getDrawGames(): List[PlayedGame] = playedGames.filter(playedGame => playedGame.result == Winner.NoOne)

  def getWinningPercentage(): Double = getWonGames().size / playedGames.size

  def getLosingPercentage(): Double = getLostGames().size / playedGames.size
}
