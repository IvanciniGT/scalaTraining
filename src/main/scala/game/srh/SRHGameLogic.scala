package com.training
package game.srh

trait SRHGameLogic {
  def init():SRHGameStatus
  def setPlayerGuess(currentStatus:SRHGameStatus, playerGuess:String):SRHGameStatus
}
