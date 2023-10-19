package com.training

object NiceSyntax {

  def niceFunction(number:Int, odd:Boolean = true)(operation: Int=>Int):Boolean = {
    if(odd)
      operation(number) % 2 == 0
    else
      operation(number) % 2 != 0
  }

  def main(args: Array[String]): Unit = {
    niceFunction(3) {
      number => number * 2
    }
  }
}
