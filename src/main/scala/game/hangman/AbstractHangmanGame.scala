package com.training
package game.hangman

import game.Player
import game.Winner
import game.Game

abstract class AbstractHangmanGame(
                        private val logic:HangmanGameLogic,
                        private val ui:HangmanGameUI,
                        )
  extends Game{


  def play(player: Player, setOfAllowedWords:List[String]): Winner.Winner = {
    val status=logic.startGame(setOfAllowedWords)
    ui.gameStart(status)
    while (!status.isGameOver()) {
      ui.showGameStatus(status)
      val char=ui.askForNewChar()
      logic.newChar(char, status)
    }
    ui.gameEnd(status)
    status.winner.get
  }
}

