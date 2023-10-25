package com.training
package game


import ui.ApplicationUI
abstract class GameApplication protected ( val ui: ApplicationUI) {

  def startPlaying(games: List[Game]): Unit = {
    // Ask the player name
    val player = new Player(ui.getPlayerName())
    // Ask for the game to play
    var playAgainResponse = PlayAgainResponse.ANOTHER_GAME
    var game: Game = null

    while(playAgainResponse != PlayAgainResponse.QUIT) {
      if(playAgainResponse == PlayAgainResponse.ANOTHER_GAME)
        game = ui.getGameToPlay(games)

      game.play(player)

      // update player statistics
      playAgainResponse = ui.askToPlayAgain()
    }
  }

}
