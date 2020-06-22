# Lambda Expressions.

## What is lambda expression?
Lambda expression in itself is an anonymous method i.e. a method with no name which is used to provide implementation of the method defined by a functional interface.

```
(optional) (Arguments) -> body
```

## What is a functional interface?

A functional interface is an interface with only one abstract method. A functional interface is also known as SAM type where SAM stands for (Single Abstract Method).

## Explain target typing with an example.

* Lambda expression doesn't have a type of its own. A lambda expression provides implementation of the abstract method defined by the functional interface. Thus the functional interface specifies its target type.
* Lambda supports "target typing" which infers the object type from the context in which it is used.

## Explain target typing with an example.

```
interface IMyFunc {
    int getValue(int num);
}

public class LambdaDemo {

    public static void main(String[] args) {
    // lambda expression
        IMyFunc myFactorialFunc = (num) -> {
            int fact = 1;
            for(int i = 1; i <= num; i++){
                fact = i * fact;
            }
            return fact;
        };
        System.out.println("Factorial of 7 is " + myFactorialFunc.getValue(7));
    }
}

```

## Check if lambda expression is valid
(int x, y) -> x + y; is this a valid lambda expression?








