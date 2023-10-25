package com.training
package game.hangman.impl

import org.scalatest.funspec.FunSpec

import java.io.{ByteArrayOutputStream, StringReader}

class HangmanGameConsoleUITest extends FunSpec {

  val inChannel = new StringReader("a\n");
  val outChannel = new ByteArrayOutputStream();
  Console.withOut(outChannel){
    Console.withIn(inChannel) {
      describe("Test ask for new Char") {
        val selectedChar = HangmanGameConsoleUI.askForNewChar()
        assert(outChannel.toString.contains("Enter a new character"))
        assert(selectedChar == 'a')
      }
    }
  }

}
