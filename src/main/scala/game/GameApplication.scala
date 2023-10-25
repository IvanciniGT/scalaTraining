package com.training
package game

import statistics.PlayerStatisticsRepository

abstract class GameApplication protected ( val ui: ApplicationUI, val statisticsRepository: PlayerStatisticsRepository) {

  def startPlaying(games: List[Game]): Unit = {
    // Ask the player name
    val player = new Player(ui.getPlayerName())
    // Ask for the game to play
    var playAgainResponse = PlayAgainResponse.ANOTHER_GAME
    var game: Game = null

    while(playAgainResponse != PlayAgainResponse.QUIT) {
      if(playAgainResponse == PlayAgainResponse.ANOTHER_GAME)
        game = ui.getGameToPlay(games)

      val result = game.play(player)

      if(statisticsRepository != null) // TODO REMOVE THIS LINE
        statisticsRepository.newGame(player, game, result)

      playAgainResponse = ui.askToPlayAgain()
    }
  }

}
