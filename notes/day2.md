```java
public class Rectangle{
    private int width;
    private int height;
    
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getArea(){
        return width * height;
    }
    public int getPerimeter(){
        return 2 * (width + height);
    }
}

public class Square extends Rectangle{
    public Square(int side){
        super(side, side);
    }
}
```

## Map Reduce

It a programming model that helps us to process data in parallel.... is based on functional programming.

The point is that we will start with a sequence of values.

We will be able to apply map and reduce like functions to that sequence of values.
Actually we will be able to apply a sequence of map like functions to a sequence of values... and finally a reduce like function.

All this is true only when we play with a special sequence of values called a stream.
We also have map/recude like functions for other types of sequences of values (collections... such as List), but they are not as powerful as the ones for streams.
In Lists or Sets we don't have that amount of map/reduce like functions... and for this king of collections we don't have the same parallelism 
capabilities nor map like functions are executed lazily. 

### Map like function

Is a function that provides a sequence of values and returns a sequence of values.
We have a bunch of map like functions that we can apply to a sequence of values:
- map
    Initial Collection  --->   .map(  mapperFunction: (T)-> R  )   --->  Final Collection
            1                           *3   (triple)                           3              
            2                                                                   6
            3                                                                   9              

    In other words... the map function allows to transform a sequence of values into another sequence of values
    by transforming each value thru the mapperFunction.

- filter
- flatMap
- distinct
- sorted
They are executed lazily, so they are not executed until we need the result.
That means that they are not going to be calculated until we need the result.

One amazing thing about map like functions is that we can stack them.

### Reduce like function

Is a function that takes a sequence of values and returns anything but a sequence of values.
We have a bunch of reduce like functions that we can apply to a sequence of values:
- reduce
- count
- collect
- sum
- foreach
Reduce like functions are executed eagerly, so they are executed immediately.
Actually... once a reduce like function is executed, all the map like functions are executed.

