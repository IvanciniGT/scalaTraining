package com.training
package game.srh.impl

import game.Winner

object ClassicSRHGameLogic extends AbstractClassicSRHGameLogic{

  this < List("Scissors", "Rock", "Paper")
  this << Array(Array(Winner.Tie, Winner.Computer, Winner.Player),
          Array(Winner.Player, Winner.Tie, Winner.Computer),
          Array(Winner.Computer, Winner.Player, Winner.Tie))
}
object SRPLSGameLogic extends AbstractClassicSRHGameLogic{

  this < List("Scissors", "Rock", "Paper", "Lizard", "Spock")
  this << Array(Array(Winner.Tie, Winner.Computer, Winner.Player, Winner.Player, Winner.Computer),
                Array(Winner.Player, Winner.Tie, Winner.Computer, Winner.Player, Winner.Computer),
                Array(Winner.Computer, Winner.Player, Winner.Tie, Winner.Computer, Winner.Player),
                Array(Winner.Computer, Winner.Computer, Winner.Player, Winner.Tie, Winner.Player),
                Array(Winner.Player, Winner.Player, Winner.Computer, Winner.Computer, Winner.Tie))
}
