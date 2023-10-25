package com.training
package game

trait Game {

  def play(player:Player): Winner.Winner
  def getGameName(): String

}
