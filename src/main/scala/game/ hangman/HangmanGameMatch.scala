package com.training
package game. hangman

import hangman.HangmanGameLogic
import game.Player
import game.Winner
import game.GameMatch
class HangmanGameMatch (private val player: Player,
                        private val logic:HangmanGameLogic,
                        private val ui:HangmanGameUI,
                        private val setOfAllowedWords:List[String])
  extends GameMatch{


  override def play(): Winner.Winner = {

  }
}
