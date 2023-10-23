package com.training
package game.hangman

import game.GameStatus
trait HangmanGameUI {
    def gameStart(): Unit
    def gameEnd(gameStatus: GameStatus): Unit
    def askForNewChar(): Char
    def showGameStatus(gameStatus: GameStatus): Unit
}
