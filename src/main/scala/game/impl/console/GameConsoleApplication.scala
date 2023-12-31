package com.training
package game.impl.console

import game.GameApplication
import game.hangman.impl.ClassicalConsoleHangmanGameCountriesEdition
import game.statistics.PlayerStatisticsRepository
import game.statistics.PlayerStatisticsRepositorySQLImpl
import game.srh.impl.ClassicalConsoleSRHGame
import game.srh.impl.SRPLSConsoleGame
private class GameConsoleApplication (statisticsRepository: PlayerStatisticsRepository) extends GameApplication ( ApplicationConsoleUI, statisticsRepository) {
}

object GameConsoleApplication {

  val games = List(
    ClassicalConsoleHangmanGameCountriesEdition,
    ClassicalConsoleSRHGame,
    SRPLSConsoleGame
  )

  def main(args: Array[String]): Unit = {
    val playerStatisticsRepository = new PlayerStatisticsRepositorySQLImpl( "org.h2.Driver", "jdbc:h2:~/gameStatistics", "sa", "")
    val gameConsoleApplication = new GameConsoleApplication(playerStatisticsRepository)
    gameConsoleApplication.startPlaying(games)
  }
}
