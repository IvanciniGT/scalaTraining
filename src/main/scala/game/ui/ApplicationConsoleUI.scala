package com.training
package game.ui

import game.ApplicationUI

import scala.io.StdIn
object ApplicationConsoleUI extends ApplicationUI {

  def getPlayerName(): String = {
    println("Please enter your name:")
    val playerName = StdIn.readLine()
    playerName
  }
}
