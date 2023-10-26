package com.training
package game

object Winner extends Enumeration { // Scala 2 syntax
  type Winner = Value
  val Player, Computer, Tie = Value
}