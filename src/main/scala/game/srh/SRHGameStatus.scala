package com.training
package game.srh

import game.GameStatus
class SRHGameStatus (val possibleGuesses:List[String], val computerGuess: String) extends GameStatus{

  var playerGuess: String = null;
}
