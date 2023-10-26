package com.training
package game.srh.impl

import game.{Winner}
object ClassicSRHGameLogic extends AbstractClassicSRHGameLogic{

  super.setPossibleGuesses(List("Scissors", "Rock", "Paper"))
  super.setCombinationsMatrix(Array(Array(Winner.Tie, Winner.Computer, Winner.Player),
    Array(Winner.Player, Winner.Tie, Winner.Computer),
    Array(Winner.Computer, Winner.Player, Winner.Tie)))
}
