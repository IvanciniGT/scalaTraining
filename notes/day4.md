
Levestein distance

It calculates how many chars needs to be replaced, added or removed in a word to get another word.


---

Java is both a compiled and interpreted language.
Scala is the same

.java -> compilation -> .class -> interpreted -> JVM
JAVA                    BYTE-CODE
.scala -> compilation ->.class -> interpreted -> JVM
SCALA                   BYTE-CODE


Inside the JVM we have the JIT (Just in time) compiler that compiles the byte-code to machine code.
Since Java v1.2 the JIT compiler is part of the JVM and it has what is called a HotSpot compiler that caches the most used code (machine code)

---

Java has 2 version with huge improvements:
- JAVA 1.8 -> Functional programming
- JAVA 1.9 -> Modularization (Jigsaw)

Until java 1.8 we could create only classes and interfaces.

public class interface MyInterface {
    public void myMethod();
}

public class MyClass implements MyInterface {
    public void myMethod() {
        System.out.println("Hello World");
    }
}

In Java 9, they added the possibility to define modules:

module myModule {
    exports myPackage;
}

---

API: dictionary.jar

    package com.dictionary;

    public interface Dictionary {
        String getLanguage();
        boolean exists(String word);
        String getDefinition(String word);
        Optional<String[]> getSuggestions(String word);
    }

    module dictionary {
        exports com.dictionary;
    }

Implementation of that dictionary.jar working with files... Maybe in the future we may want to have a Data base

    package com.dictionary;

    public interface DictionaryFactory {
        static Dictionary getInstance(String language) { // JAVA 1.8
            return new DictionaryImpl(language);
        }
    }
    
    package com.dictionary.impl;

    public class DictionaryImpl implements Dictionary {
        public DictionaryImpl(String language) {
            // A BUNCH OF CODE
        }
        // A BUNCH OF CODE
    }

    module dictionary.impl {
        exports com.dictionary;
        requires dictionary;
        provides com.dictionary.Dictionary with com.dictionary.impl.DictionaryImpl;
    }

Let's create an app, using a dictionary

    package com.app;

    import com.dictionary.Dictionary;
    import com.dictionary.DictionaryFactory;
    // import com.dictionary.impl.DictionaryImpl; // THIS THIS WE HAVE DONE ... I MEAN ... THIS LINE OF CODE
                                               // IS COMPLETLY FORBIDDEN. THIS IS THE MOST HORRIBLE THING I COULD DO IN MY LIFE

    public class App {
        public static void main(String[] args) {
            String language = args[0];
            String word = args[1];
            //Dictionary dictionary = DictionaryFactory.getDictionary(language); // THIS IS OK
            Dictionary dictionary = ServiceLoader.load(Dictionary.class).findFirst().orElseThrow(); // JAVA 9
            //Dictionary dictionary = new DictionaryImpl(language);  FORBIDDEN 
            boolean exists = dictionary.exists(word);
            // To do something
        }
    }

Have your heard about SOLID principles? 5 principles that help us to write better code, but also more maintainable code.
The fifth principle is called Dependency Inversion Principle (DIP)
    It says that a high order class cannot depend on a low order component implementation, It has to depend on an abstraction (interface)

A way of respecting the DIP is by using that programming strategy called Dependency Injection (DI)

DI: Is just that a class is not going to create instances of objects it needs... Those are going to be provided to the class  ç


In JAVA we have the most huge framework (200 libraries) ever called Spring
Spring is an IoC container (Inversion of Control)
IoC is just a programming strategy that allows us to respect the DIP by making easy to inject dependencies into a class


 SCISSORS ROCK HAND GAME !
 SCISSORS ROCK HAND SPOCK LIZARD GAME !
