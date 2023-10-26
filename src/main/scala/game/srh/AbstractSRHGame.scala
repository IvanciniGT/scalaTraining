package com.training
package game.srh


import game.Winner
import game.Game
import game.Player
abstract class AbstractSRHGame (
  val gameLogic: SRHGameLogic,
  val gameUI: SRHGameUI
) extends Game{
  def play(player:Player): Winner.Winner = {
    val gameStatus = gameLogic.init()
    gameUI.welcome()
    val guess = gameUI.getGuess()
    gameLogic.setPlayerGuess(gameStatus, guess)
    gameUI.displayGameResult(gameStatus)
    gameStatus.winner.get
  }

}
