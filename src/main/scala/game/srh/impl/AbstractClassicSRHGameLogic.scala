package com.training
package game.srh.impl

import game.srh.SRHGameStatus
import game.srh.SRHGameLogic

import scala.util.Random
import game.Winner
class AbstractClassicSRHGameLogic extends SRHGameLogic {

  private var possibleGuesses:List[String] = null
  private var combinationsMatrix:Array[Array[Winner.Winner]] = null

  def setPossibleGuesses(possibleGuesses:List[String]):Unit = {
    this.possibleGuesses = possibleGuesses
  }
  def setCombinationsMatrix(combinationsMatrix:Array[Array[Winner.Winner]]):Unit = {
    this.combinationsMatrix = combinationsMatrix
  }

  def init():SRHGameStatus = {
    new SRHGameStatus(possibleGuesses,possibleGuesses(Random.nextInt(possibleGuesses.size)))
  }
  def setPlayerGuess(currentStatus:SRHGameStatus, playerGuess:String):SRHGameStatus = {
    currentStatus.playerGuess = playerGuess
    // We need to calculate the winner
    val computerIndex=possibleGuesses.indexOf(currentStatus.computerGuess)
    val playerIndex=possibleGuesses.indexOf(currentStatus.playerGuess)
    currentStatus.winner = combinationsMatrix(playerIndex)(computerIndex)
    currentStatus
  }
}


/*
  var combinationsMap = Array.ofDim[Winner.Winner](3,3)
  initCombinations()
  private def initCombinations(): Unit = {
    this.combinationsMap(0) = Array(Winner.Tie, Winner.Computer, Winner.Player)
    this.combinationsMap(1) = Array(Winner.Player, Winner.Tie, Winner.Computer)
    this.combinationsMap(2) = Array(Winner.Computer, Winner.Player, Winner.Tie)
//    this.combinationsMap(2)(0) = Winner.Computer
  }
   */