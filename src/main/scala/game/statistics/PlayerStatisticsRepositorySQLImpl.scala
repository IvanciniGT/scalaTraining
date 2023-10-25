package com.training
package game.statistics

import game.{Game, Player, Winner}

class PlayerStatisticsRepositorySQLImpl (driver: String, private val url:String, private val user:String, private val password:String) extends PlayerStatisticsRepository {

  // Load the driver if it was not loaded before
  PlayerStatisticsRepositorySQLImpl.initializeJdbcDriver(driver)
  def getStatistics(player: Player): List[PlayedGamed] ={

  }
  def newGame(player: Player, playedGame: Game, result: Winner.Winner): Unit ={

  }
}

// Object companion
object PlayerStatisticsRepositorySQLImpl{

  def initializeJdbcDriver(driver:String) = {

  }

  def getConnection(url:String, user:String, password:String) = {

  }

}