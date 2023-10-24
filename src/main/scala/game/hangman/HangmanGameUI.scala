package com.training
package game.hangman

import game.GameStatus
trait HangmanGameUI {
    def gameStart(gameStatus:HangmanGameStatus): Unit
    def gameEnd(gameStatus: HangmanGameStatus): Unit
    def askForNewChar(): Char
    def provideCharFeedBack(char: Char, gameStatus: HangmanGameStatus): Unit
    def showGameStatus(gameStatus: HangmanGameStatus): Unit
}
