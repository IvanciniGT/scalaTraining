package com.training
package game.srh.impl

import game.srh.AbstractSRHGame


object ClassicalConsoleSRHGame extends AbstractSRHGame (ClassicSRHGameLogic,SRHGameConsoleUI) {
  override def getGameName(): String = "Classic Scissors-Rock-Paper Game"
}

object SRPLSConsoleGame extends AbstractSRHGame (SRPLSGameLogic,SRHGameConsoleUI) {
  override def getGameName(): String = "Scissors-Rock-Paper-Lizard-Spock Game"
}

