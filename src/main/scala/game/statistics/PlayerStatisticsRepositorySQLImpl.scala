package com.training
package game.statistics

import game.{Game, Player, Winner}

import java.sql.{Connection, DriverManager, Timestamp}

class PlayerStatisticsRepositorySQLImpl (driver: String, private val url:String, private val user:String, private val password:String) extends PlayerStatisticsRepository {

  // Load the driver if it was not loaded before
  PlayerStatisticsRepositorySQLImpl.initializeDatabase(driver, url, user, password)

  def getStatistics(player: Player): List[PlayedGame] ={
    val connection = PlayerStatisticsRepositorySQLImpl.getConnection(url, user, password)
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(s"SELECT * FROM played_games WHERE player_name = '${player.name}'")
    var playedGames: List[PlayedGame] = List()
    while(resultSet.next()){
      val gameName = resultSet.getString("game_name")
      val result = resultSet.getString("result")
      val date = resultSet.getTimestamp("date")
      playedGames = new PlayedGame( gameName, Winner.withName(result), date.toLocalDateTime) :: playedGames
    }
    resultSet.close()
    statement.close()
    connection.close()
    playedGames
  }
  def newGame(player: Player, playedGame: Game, result: Winner.Winner): Unit ={
    // We sid tht we will implement this with a Prepared Statement
    val connection = PlayerStatisticsRepositorySQLImpl.getConnection(url, user, password)
    val statement = connection.prepareStatement("INSERT INTO played_games (player_name, game_name, result, date) VALUES (?, ?, ?, ?)")
    statement.setString(1, player.name)
    statement.setString(2, playedGame.getGameName())
    statement.setString(3, result.toString)
    statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()))
    statement.executeUpdate()
    statement.close()
    connection.close()
  }
}

// Object companion
object PlayerStatisticsRepositorySQLImpl{

  private var driverLoaded = false

  private def createDatabaseTable(url: String, user: String, password: String): Unit = {
    val connection = getConnection(url, user, password)
    val statement = connection.createStatement()
    statement.executeUpdate("CREATE TABLE IF NOT EXISTS played_games (player_name VARCHAR(255), game_name VARCHAR(255), result VARCHAR(255), date TIMESTAMP)")
    statement.close()
    connection.close()
  }

  private def initializeDatabase(driver:String, url:String, user:String, password:String): Unit = {
    if(!driverLoaded){          // To make sure we don't synchronize unnecessarily, as it is an expensive operation
      this.synchronized {       // To make sure that only one thread at a time is executing this code
        if (!driverLoaded) {    // To make sure that the driver is only loaded once
          Class.forName(driver)
          driverLoaded = true
          createDatabaseTable(url, user, password)
        }
      }
    }
  }

  def getConnection(url:String, user:String, password:String): Connection = {
    DriverManager.getConnection(url, user, password)
  }

}