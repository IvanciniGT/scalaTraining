package com.training
package game.hangman.impl

import game.Winner
import game.hangman.HangmanGameUI
import game.hangman.HangmanGameStatus

import scala.io.StdIn

object HangmanGameConsoleUI extends HangmanGameUI {
    def gameStart(gameStatus: HangmanGameStatus): Unit={
        println("Welcome to Hangman Game" )
        println("You have to guess a word")
        println("You have "+gameStatus.remainingAttempts+" attempts to guess the word")
        println("Let's start the game")
    }
    def gameEnd(gameStatus: HangmanGameStatus): Unit = {
        gameStatus.winner match {
            case Some(Winner.Player) => println("Congratulations, you won the game")
            case Some(Winner.Computer) => println("Sorry you lost the game. The word was: "+gameStatus.targetWord)
        }
    }
    def askForNewChar(): Char = {
        println("Enter a new character")
        StdIn.readChar()
    }
    def provideCharFeedBack(char: Char, gameStatus: HangmanGameStatus) = {
        if (!gameStatus.targetWord.contains(char)) {
            println("The character "+char+" is not in the word")
        } else
            println("The character "+char+" is in the word")

    }

    def showGameStatus(gameStatus: HangmanGameStatus): Unit = {
        println("The word to guess is: "+gameStatus.targetWord.map(
            c => if (gameStatus.playedChars().contains(c.toUpper) || c == ' ') c else '_').mkString("") )
        println("You played: "+gameStatus.playedChars().mkString(" "))
        println("You have "+gameStatus.remainingAttempts+" attempts left")
    }
}
