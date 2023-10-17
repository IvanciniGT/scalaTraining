package com.training

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    sayHello("John")
    sayHello("Mary")
    println(composeHelloMessage("Ivan"))
    println(composeHelloMessage2("Cristiano", false))
    println(composeHelloMessage2("Emanuele", true))
    println(composeHelloMessage2("Marco"))
    println(composeHelloMessage3())
    println(composeHelloMessage3(polite=false))
  }

  def sayHello(name: String): Unit = {
    println(s"Hello $name!")
  }

  def composeHelloMessage(name: String): String = {
    return s"Hello $name!" // The return keyword is not necessary in scala
  }

  def composeHelloMessage2(name: String, polity: Boolean = true): String = if (polity) s"Hello $name!" else s"Hi $name!"

  def composeHelloMessage3(name: String = "my friend", polite: Boolean = true): String = {
    if (polite) {
      s"Hello $name!"
    } else {
      s"Hi $name!"
    }
  }
}