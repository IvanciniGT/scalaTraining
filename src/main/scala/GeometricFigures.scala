package com.training

import scala.collection.mutable.ListBuffer

object GeometricFigures {

  def main(args: Array[String]): Unit = {
    val square = new Square(5)
    println(square.perimeter())
    println(square.area())
    println(square.side)

    val rectangle = new Rectangle(5, 10)
    println(rectangle.perimeter())
    println(rectangle.area())
    println(rectangle.width)
    println(rectangle.height)

    val parallelogram = new Parallelogram(5, 10, 45)
    println(parallelogram.perimeter())
    println(parallelogram.area())
    println(parallelogram.base)
    println(parallelogram.side)
    println(parallelogram.height)
    println(parallelogram.angleInRadians)

    val circle = new Circle(5)
    println(circle.perimeter())
    println(circle.area())
    println(circle.radius)

    var shapes = new ListBuffer[Shapes2D]();  // is mutable
                // List(square, rectangle, parallelogram, circle) is unmutable
    shapes += square
    shapes += rectangle
    shapes += parallelogram
    shapes += circle

    printShapes(shapes)
  }
  def printShapes(shapes: ListBuffer[Shapes2D]): Unit = {
    for (shape <- shapes) {  // For each loop
      println(shape.perimeter())
      println(shape.area())
    }
  }
}

trait Shapes2D { // SAME AS AN INTERFACE IN JAVA
  def perimeter(): Double
  def area(): Double
}
class Circle (val radius: Double) extends Shapes2D{
  def perimeter(): Double = 2 * Math.PI * radius
  def area(): Double = Math.PI * Math.pow(radius, 2)
}
class Parallelogram (val base: Double, val side: Double, angle: Double) extends Shapes2D { // Radians or degrees
  val angleInRadians: Double = angle * Math.PI/180
  val height:Double = side * Math.sin(angleInRadians)
  def perimeter(): Double = (base + side) * 2
  def area(): Double = base * height
}

class Rectangle ( var width: Double, height: Double) extends Parallelogram(width, height, 90)
class Square (side: Double) extends Rectangle(side, side)

