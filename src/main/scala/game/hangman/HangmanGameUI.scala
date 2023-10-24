package com.training
package game.hangman

import game.GameStatus
trait HangmanGameUI {
    def gameStart(gameStatus:HangmanGameStatus): Unit
    def gameEnd(gameStatus: HangmanGameStatus): Unit
    def askForNewChar(): Char
    def showGameStatus(gameStatus: HangmanGameStatus): Unit
}
