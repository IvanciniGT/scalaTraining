package com.training

import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.sys.process.buildersToProcess

object MapReduce {

  def main(args:Array[String]):Unit ={

    val numericList = List(1,2,3,4,5,6,7,8,9,10)
    numericList.map(      (number:Int) => number * 2  ) // We will transform each number into its double
               .map(      number => number - 5        ) // We will transform each number into its String representation
               .foreach(  println )                     // We will print each double number

    var numericStream = LazyList(1,2,3,4,5,6,7,8,9,10)
    var transformationResult = numericStream.map((number: Int) => number * 2) // We will transform each number into its double
                                            .map(number => number - 5) // We will transform each number into its String representation
    println(transformationResult)
    transformationResult.foreach(println) // We will print each double number

    numericStream = LazyList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    numericStream.map((number: Int) => number * 5) // We will transform each number into its double
                 .filter(number => number % 2 == 1) // We get only the odd numbers
                 .foreach(println)

    val sentences = LazyList("This is a sentence", "This is another sentence", "This is a third sentence")
    // I'm going to transform each sentence in a list of words
    sentences                                               // Collection of Sentences
             .map(sentence => sentence.split(" ").toList)   // Collection of a Collection of Words
             .foreach(println)

    sentences // Collection of Sentences
            .flatMap(sentence => sentence.split(" ").toList) // Is actually a map followed by a flatten . Collection of all Words together
            .foreach(println)

    //////////////////////////////////////////////////
    // let's calculate Twitter (X) Trending Topics

    val tweets = LazyList("This is a tweet #summerLove#goodVibes",
                          "This is another tweet #badVibes#fuckingSummer",
                          "This is a third tweet #friendsLove #goodVibes",
                          "This is a fourth tweet #summerLove #friendsLove #completelyInLove",
                          "This is a fifth tweet #noLoveAtAll#GoodVibes")

    val forbidenWords = List("fucking", "shit")

    // We want to transform those tweets in this table:
    //   goodVibes    3
    //   summerlove   2
    //   friendsLove  2
    // There is one restriction... You can only execute 1 single line of code!

    println("Trending TOPICS")
    // STEPS
    tweets.map( tweet => tweet.replace("#"," #"))   // 1 - If we replace "#" -> " #"                              ---> List<Tweets>
      .flatMap( tweet => tweet.split("[ ().,;:_-]+").toList)      // 2 - We can split each tweet.. Split by: " -(),.;:[]#_"     ---> Each tweet -> Array of tokens (regular words or hashtags) ---> List<Array<Token>>
                                                                       // 2.5 - Flat those lists... to pack tokens together        ---> List<Tokens>
      .filter( token => token.startsWith("#")) // 3 - We can just filter tokens... and keep only tokens starting by #    ---> List<Tokens> -> List<Hashtags>
      .map( hashtag => hashtag.substring(1))// 4 - We don't need this # symbol anymore
      .map( hashtag => hashtag.toLowerCase() )// 5 - ToUpper/LowerCase all hashtags
      .filter( hashtag => forbidenWords.forall( forbidenWord => !hashtag.contains(forbidenWord) )) // 6 - We need to remove all the hashtags containing forbidden words
    // We need to count // By hashtag
      .groupBy( hashtag => hashtag ) // 7 - We can group by hashtag
      .map( tupleHashtagRepetitions => (tupleHashtagRepetitions._1, tupleHashtagRepetitions._2.size)) // 8 - We can count the number of hashtags per group
      .toList
      .sortBy(tupleHashtagCount => tupleHashtagCount._2) // 9 - We can sort by the number of hashtags
      .reverse
      .take(3)
      .foreach( thing => println(thing))











    // In scala, we have this datatype which is called TUPLE - a pair of objects (Tuple2)

    var myTuple = Tuple2( 1, "Hello" )
        myTuple =  (1, "Hello" )
    println( myTuple._1 )
    println( myTuple._2 )
    println( myTuple )
  }

}
