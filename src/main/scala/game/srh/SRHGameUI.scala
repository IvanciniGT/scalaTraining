package com.training
package game.srh

trait SRHGameUI {
  def displayGameResult(gameStatus: SRHGameStatus):Unit
  def getGuess():String
  def welcome() :Unit

}
