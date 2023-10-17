# Scala

Programming language (grammar: syntax + semantics)

emojis... they serve to communicate things too!
But are emojis considered a language? NO ... they are an alphabet

SCALA language defines a syntax... a semantics... to create (develop) software


## Compiled vs interpreted languages

- Compiled language: compiled
- Interpreted language: JS, PYTHON

Java is weird... its is both a compiled and interpreted language... at the same time.

.java -> compile -> .class -> interpreted by Java Virtual Machine (oracleJDK, openJDK, Amazon Correto, Eclipse Temurin)
^
byte-code

As a language, JAVA has a bunch of nonsense things in its syntax.
In addition... In earliest 2000.... most people wanted to learn JAVA... but also JAVA was used to create any kind of apps.
- Webapp -> Java
- Desktop -> Java
- Android app -> Java
- Embed system -> Java

Nowadays... it's not the case anymore.
The most used program language nowadays is js. Python is the second one.
- Webapp
    - frontend -> JS / TS
    - backend -> JAVA (Spring)
- Desktop -> vb, c++. c#
- Android app -> kotlin
- Embed systems -> C, Go, Rust, Python

JAVA had a huge problem: Oracle

Java was created by Sun Microsystems
Oracle bought Sun Microsystems... why? Oracle just wanted Sun microsystems Hardware
IBM that produces software and hardware
HP... same thing

And ... Oracle is a company who destroys which ever software they touch... but its database:

- MySQL --> MariaDB
- OpenOffice (Sun project... Paid version: StartOffice) --> LibreOffice
- Hudson --> Jenkins
- Java

IntelliJ <- JetBrains

Eclipse was the official environment to create Android apps.
At certain point Google did sign an agreement with JetBrains.. to create a small version of intelliJ -> Android Studio
Buy also they created a new Language (grammar) to create apps for Android: KOTLIN
.kt -> compile -> .class -> JVM
^
bytecode

Kotlin is an alternative language to JAVA to produce byte-code
Same thing is SCALA: BigData

    .scala -> compiled -> .class    -> JVM
                           ^
                           bytecode

## Static typed languages / Dynamically typed programming languages

- Static typed languages (JAVA, C)
  Variables are typed

- Dynamically typed programming languages (Python, JS)
  Variables are not typed

```java
String text = "Hello";
text = 3; // This won't compile at all!
```
- "hello"           We place a new object of type String in the RAM memory... holding value "hello"
- String text       We create a variable called "text" which can oly point to "String" objects in memory
- =                 We assign the the variable "text" to the value "HELLO"

```js
var text = "Hello";
text = 3;
```

```java
var text = "Hello"; // From version 11 on! Type inference
text = 3; // This won't compile at all!
```

But be carefull!... Java keeps being an static types p.l.

This is one thing that we also have in scala.
In scala vars are defined:
```scala
    var text:String = "hello";
    var anotherText = "byte"; // Type is inferenced
```
In java we also have the keyword "final" that we can apply to a var. -> CONSTANT
In scala we can do the same thing:
```scala
    val text:String = "hello";
    val anotherText = "byte"; // Type is inferenced
```


## Functions
                                          Returned type
                                            vv
def myFunction(arg1:String, arg2:Double):String = {

}

def myFunction(arg1:String, arg2:Double = -4):String = {

}

To achieve this functionality in JAVA: We have to overload a function

String def myFunction(String arg1, Double arg2) {

}
String def myFunction(String arg1) {
return myFunction(arg1, --4);
}

---

void myFunction(String arg1){

}
Returned type
vv
def myFunction(arg1:String):Unit = {

}
---

def triple(number:Integer): Integer = {
return number * 3;
}
def triple(number:Integer): Integer = {
number * 3; // The value returned by the last line of code executed within a function is automatically considered its returned value
}
def specialFunction(number:Integer): Integer = {
if (number > 0)
number * 2;
else
number * 3;
}

def specialFunction(number:Integer): Integer =  number * if (number > 0) 2 else 3;
---


## In JAVA we can define interfaces and classes

### Regular classes in scala

```java
public class Person {

    private String surName;
    private String lastName;
    private int age;

    public Person(String surName,String lastName,int age){
        setSurName(surName);
        setLastName(lastName);
        setAge(age);
    }

    public String getSurName(){
        return this.surName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public int getAge(){
        return this.age;
    }
    public void setSurName(String value){
        this.surName = value;
    }
    public void setLastName(String value){
        this.lastName = value;
    }
    public void setAge(int value){
        if(newAge <0) throw new IllegalArgumentException("Age cannot be negative");
        this.age = value;
    }

}

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {

    private String surName;
    private String lastName;
    private int age;

    public Person(String surName,String lastName,int age){
        setSurName(surName);
        setLastName(lastName);
        setAge(age);
    }
}



Person p = new Person("Ivan", "Osuna", 44);
System.out.println(p.getSurName());
p.setAge(45);
System.out.println(p.getAge());
```
---
// Define this day 1
public class PersonV2 {

    public String surName;
    public String lastName;
    private int age;

    public Person(String surName,String lastName,int age){
        this.surName=surName;
        this.lastName=lastName;
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int newAge){
        if(newAge <0) throw new IllegalArgumentException("Age cannot be negative");
        this.age = newAge;
    }

}
// People starts using my class from day 2 to day 100... just like this vvvv
PersonV2 p = new PersonV2("Ivan", "Osuna", 44);
System.out.println(p.surName);
p.setAge(45);
System.out.println(p.getAge());
// Day 101... I decide that age cannot be negative
// ... but if do implementa that functionality... What all these people that were using my class need to do?

// In order to make it easy to add more functionality to (maybe) my class in the future... not sure if I will... but just in case I need that any day...
// TODAY ... I have to define setters and getters... so that if in the future (not sure sure... just maybe o maybe not)
// I decide to add a validation... for example.
---
// SCALA VERSION
public class Person (var surName: String, var lastName: String, var age:Integer)
// ^^ public
//      ^^ class
//           ^^ Name of the class
//                   ^^ This right here is the constructor... or at least... part of it...
// Im telling Scala... In order to create a new Person.. those 3 args needs to be provided (constructor signature)
// As I am definen them as var.. you(scala) have to create a private field for each one... and also public getter and setter

public class Person (surName: String, lastName: String, age: Integer){

    // Start of the constructor code
    // Here do things with my vars... // Here I would write my constructor code.. just In cas I needed
    if(age < 0) throw new Exception();
    // End of the constructor code

}
// ^^^^ In that case, surName, lastName, age would only be available in that constructor code
public class Person (val surName: String, private val lastName: String, val age: Integer):
// In this case, I am capturing those vars as values for public read only (final) properties of my class
// I mean... It like like if in java I have written:

```java
    public class Person {

        private final String surName;
        private final String lastName;
        private final int age;

        public Person(String surName,String lastName,int age){
            this.surName=surName;
            this.lastName=lastName;
            this.age = age;
        }

        public String getSurName(){
            return this.surName;
        }
        private String getLastName(){
            return this.lastName;
        }
        public int getAge(){
            return this.age;
        }

    }
```

Let's say... In the future I decide to made a check in the age field:
// VERSION 1:
public class Person (var surName: String, var lastName: String, var age:Integer)

// Version 2:
public class Person (var surName: String, var lastName: String, age:Integer) {
private var _age ;
this.age = age; // This is what I woould have stored in my constuctor
def age():Integer = this._age;
def age(newAge:Integer):Unit = {
if(age < 0) throw new Exception();
this._age = newAge;
}
}

//The point here is that people would still be able to use this syntax:
val p = new Person("Ivan","osuna",44);
p.age = 45; // But this is going to call my age function


Let me tell you that in SCALA we don't have the STATIC WORD

I JAVA (Java sucks) we can define static functions within a class... Why?
What is the purpose of that?
In java I cannot define a function outside a class...
Imagine that I want to define a function to calculate the triple of a number

// JAVA CODE
public interface UtilityInterface {
public static int triple (int number) {
return number * 3;
}
}
UtilityInterface.triple(5)
// SCALA VERSION
public object UtilityInterface {
private val lastNumber;
def triple (number: Integer):Integer = { // this is the equivalent version of a static method in Java
this.lastnumber = number;
number * 3;
}
}
// What an Object is in Scala?

An object is a class that can only have 1 single Instance : Singleton
An object is a singleton in java...
And actually I can refer to that instance by the object name:
UtilityInterface.triple(5);

// In JAVA in order to make a singleton:

public class MySingleton {

    private final volatile MySingleton instance=null;

    private MySingleton(){
    }

    public static MySingleton getInstance(){
        if(this.instance == null){          // Is here to avoid the lock (synchronized) in case the var is already initialized... which is going to be the 99.9999999% of times this method is called
            synchonized(MySingleton.class){ // to make sure that that if is only reached by one thread at at time
                if(this.instance == null){ // This if is here because maybe 2 threads can execute at the same moment of time this line of code... 
                                           // And both access inside the if... In that case 2 instances would be created.
                    this.instance = new MySingleton();
                }
            }
        }
        return this.instance;
    }

}
MySingleton.getInstance()

// Scala version:
public object MySingleton;
MySingleton





--- PYTHON
def triple (number):
return number * 3;
---










I can do that in scala too.. but also I can define "object"