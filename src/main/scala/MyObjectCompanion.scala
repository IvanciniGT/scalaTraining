package com.training

class MyObjectCompanion private (val property:String) {

    def getPropertyInUpperCase(): String = property.toUpperCase()

}
object MyObjectCompanion {

    def apply(property:String): MyObjectCompanion = new MyObjectCompanion(property)

    def main(args: Array[String]): Unit = {
        val myObject = MyObjectCompanion.apply("Hello World")
        println(myObject.getPropertyInUpperCase())
    }

}