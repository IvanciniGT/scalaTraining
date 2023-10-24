package com.training
package game.hangman

import game.Player
import game.Winner
import game.GameMatch

class HangmanGameMatch  (private val player: Player,
                        private val logic:HangmanGameLogic,
                        private val ui:HangmanGameUI,
                        private val setOfAllowedWords:List[String])
  extends GameMatch{


  override def play(): Winner.Winner = {
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

