package com.training
package game.statistics


import game.Player
import game.Game
import game.Winner
trait PlayerStatisticsRepository {
  def getStatistics(player: Player): List[PlayedGamed]
  def newGame(player: Player, playedGame: Game, result: Winner.Winner): Unit
}
