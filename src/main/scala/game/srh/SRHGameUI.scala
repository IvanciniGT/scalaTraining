package com.training
package game.srh

trait SRHGameUI {
  def displayGameResult(gameStatus: SRHGameStatus):Unit
  def getGuess(gameStatus: SRHGameStatus):String
  def welcome(gameStatus: SRHGameStatus, gameName:String) :Unit

}
