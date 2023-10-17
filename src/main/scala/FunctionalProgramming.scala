package com.training

object FunctionalProgramming {

  def main(args: Array[String]): Unit = {
    // We say that a programming language supports functional programming if it allows to reference a function from a var.
    // And later... be able to execute the function thru the var.

    var text = "hello";
    // "hello" Creates a String object in memory
    // var text Which creates a variable that can point to a String object in memory
    // = Assigns the variable to the String object in memory
    var myFunction = composeHelloMessage _ // We are creating a reference to our function
    println(myFunction("Ivan", true)) // We are executing our function thru the reference

    // The point of functional programming is that once I can do this with my language...
    // I can start supplying functions as arguments to other functions.
    // Or I can start returning functions from other functions.
    printOperationResult(5, triple)

    // In almost any functional programming language, we have the lambda operator
    // The lambda operator allows us to define a anonymous function within an statement.
    var half = (number: Double) => number / 2
              ////////////////////////////// Lambda expression.. We are defining a function that takes a Double and returns a Double
    printOperationResult(5, half)
    printOperationResult( 10, multiplyByOperation(7))

  }

  def composeHelloMessage(name: String, polite: Boolean ): String = if (polite) s"Hello $name!" else s"Hi $name!"
  def half(number: Double): Double = number / 2
  def triple(number: Double): Double = number * 3
  def printOperationResult(number: Double, operation: Double => Double): Unit = println(operation(number))
                                                   /////////// The second argument is a function... that takes an Int and returns an Int
  def multiplyByOperation(factor: Double): Double => Double = (number: Double) => number * factor
}
