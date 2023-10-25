package com.training
package game

object PlayAgainResponse extends Enumeration { // Scala 2 syntax
  type Response = Value
  val SAME_GAME, ANOTHER_GAME , QUIT = Value
}
