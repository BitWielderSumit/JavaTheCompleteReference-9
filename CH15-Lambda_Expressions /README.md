# Lambda Expressions

## Introducing Lambda Expressions

* A lambda expression is, essentially, an anonymous (that is, unnamed) method. However, this method is not executed on its own. Instead, it is used to implement a method defined by a functional interface. Thus, a lambda expression results in a form of anonymous class. Lambda expressions are also commonly referred to as closures.
* A functional interface is an interface that contains one and only one abstract method. Normally, this method specifies the intended purpose of the interface. Thus, a functional interface typically represents a single action. For example, the standard interface Runnable is a functional interface because it defines only one method: run( ). Therefore, run( ) defines the action of Runnable. Furthermore, a functional interface defines the target type of a lambda expression. Here is a key point: a lambda expression can be used only in a context in which its target type is specified. One other thing: a functional interface is sometimes referred to as a SAM type, where SAM stands for Single Abstract Method.

## Lambda Expression Fundamentals

lambda operator: ->

* Java defines two types of lambda bodies. One consists of a single expression, and the other type consists of a block of code.
* As stated, a functional interface is an interface that specifies only one abstract method. If you have been programming in Java for some time, you might at first think that all interface methods are implicitly abstract. Although this was true prior to JDK 8, the situation has changed. As explained in Chapter 9, beginning with JDK 8, it is possible to specify default behavior for a method declared in an interface. This is called a default method. Today, an interface method is abstract only if it does not specify a default implementation. Because nondefault interface methods are implicitly abstract, there is no need to use the abstract modifier (although you can specify it, if you like).
* As mentioned earlier, a lambda expression is not executed on its own. Rather, it forms the implementation of the abstract method defined by the functional interface that specifies its target type.

## Functional Interfaces
* As stated, a functional interface is an interface that specifies only one abstract method.
* from Java 8, Its possible for interface to have default method.

```
interface MyNumber { 
  double getValue();  
} 
```

* As mentioned earlier, a lambda expression is not executed on its own. Rather, it forms the implementation of the abstract method defined by the functional interface that specifies its target type
* When a lambda expression occurs in a target type context, an instance of a class is automatically created that implements the functional interface, with the lambda expression defining the behavior of the abstract method declared by the functional interface.
* In order for a lambda expression to be used in a target type context, the type of the abstract method and the type of the lambda expression must be compatible. For example, if the abstract method specifies two int parameters, then the lambda must specify two parameters whose type either is explicitly int or can be implicitly inferred as int by the context. In general, the type and number of the lambda expression’s parameters must be compatible with the method’s parameters; the return types must be compatible; and any exceptions thrown by the lambda expression must be acceptable to the method.


## Some Lambda Expression Examples

```
// A functional interface. 
interface MyNumber { 
  double getValue();  
} 
 
class LambdaDemo { 
  public static void main(String args[]) 
  { 
    MyNumber myNum;  // declare an interface reference 
 
    // Here, the lambda expression is simply a constant expression. 
    // When it is assigned to myNum, a class instance is 
    // constructed in which the lambda expression provides an override 
    // of the getValue() method in MyNumber. 
    myNum = () -> 123.45; 
 
    // Call getValue(), which is overridden by the previously assigned 
    // lambda expression. 
    System.out.println("A fixed value: " + myNum.getValue()); 
 
    // Here, a more complex expression is used. 
    myNum = () -> Math.random() * 100; 
 
    // These call the lambda expression in the previous line. 
    System.out.println("A random value: " + myNum.getValue()); 
    System.out.println("Another random value: " + myNum.getValue()); 
 
    // A lambda expression must be compatible with the method 
    // defined by the functional interface. Therefore, this won't work: 
//  myNum = () -> "123.03"; // Error! 
  } 
}
```

## Block Lambda Expressions
A block lambda expands the types of operations that can be handled within a lambda expression because it allows the body of the lambda to contain multiple statements. For example, in a block lambda you can declare variables, use loops, specify if and switch statements, create nested blocks, and so on. A block lambda is easy to create. Simply enclose the body within braces as you would any other block of statements.

Aside from allowing multiple statements, block lambdas are used much like the expression lambdas just discussed. One key difference, however, is that you must explicitly use a return statement to return a value. This is necessary because a block lambda body does not represent a single expression.

```
// A block lambda that computes the factorial of an int value. 
 
interface NumericFunc { 
  int func(int n); 
} 
 
class BlockLambdaDemo { 
  public static void main(String args[]) 
  { 
 
    // This block lambda computes the factorial of an int value. 
    NumericFunc factorial = (n) ->  { 
      int result = 1; 
 
      for(int i=1; i <= n; i++) 
        result = i * result; 
 
      return result; 
    }; 
 
    System.out.println("The factoral of 3 is " + factorial.func(3)); 
    System.out.println("The factoral of 5 is " + factorial.func(5)); 
  } 
}
```

One other point. When a return statement occurs within a lambda expression, it simply causes a return from the lambda. It does not cause an enclosing method to return.

## Generic Functional Interfaces

A lambda expression, itself, cannot specify type parameters. Thus, a lambda expression cannot be generic. (Of course, because of type inference, all lambda expressions exhibit some “generic-like” qualities.) However, the functional interface associated with a lambda expression can be generic. In this case, the target type of the lambda expression is determined, in part, by the type argument or arguments specified when a functional interface reference is declared.

To understand the value of generic functional interfaces, consider this. The two examples in the previous section used two different functional interfaces, one called NumericFunc and the other called StringFunc. However, both defined a method called func( ) that took one parameter and returned a result. In the first case, the type of the parameter and return type was int. In the second case, the parameter and return type was String. Thus, the only difference between the two methods was the type of data they required. Instead of having two functional interfaces whose methods differ only in their data types, it is possible to declare one generic interface that can be used to handle both circumstances. The following program shows this approach:

```
// Use a generic functional interface with lambda expressions. 
 
// A generic functional interface. 
interface SomeFunc<T> { 
  T func(T t); 
} 
 
class GenericFunctionalInterfaceDemo { 
  public static void main(String args[]) 
  { 
 
    // Use a String-based version of SomeFunc. 
    SomeFunc<String> reverse = (str) ->  { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
    }; 
 
    System.out.println("Lambda reversed is " + 
                       reverse.func("Lambda")); 
    System.out.println("Expression reversed is " + 
                       reverse.func("Expression")); 
 
    // Now, use an Integer-based version of SomeFunc. 
    SomeFunc<Integer> factorial = (n) ->  { 
      int result = 1; 
 
      for(int i=1; i <= n; i++) 
        result = i * result; 
 
      return result; 
    }; 
 
    System.out.println("The factoral of 3 is " + factorial.func(3)); 
    System.out.println("The factoral of 5 is " + factorial.func(5)); 
  } 
}
```

## Passing Lambda Expressions as Arguments

As explained earlier, a lambda expression can be used in any context that provides a target type. One of these is when a lambda expression is passed as an argument. In fact, passing a lambda expression as an argument is a common use of lambdas. Moreover, it is a very powerful use because it gives you a way to pass executable code as an argument to a method. This greatly enhances the expressive power of Java.

```
// Use lambda expressions as an argument to a method. 
 
interface StringFunc { 
  String func(String n); 
} 
 
class LambdasAsArgumentsDemo { 
 
  // This method has a functional interface as the type of 
  // its first parameter. Thus, it can be passed a reference to 
  // any instance of that interface, including the instance created 
  // by a lambda expression. 
  // The second parameter specifies the string to operate on. 
  static String stringOp(StringFunc sf, String s) { 
    return sf.func(s); 
  } 
 
  public static void main(String args[]) 
  { 
    String inStr = "Lambdas add power to Java"; 
    String outStr; 
 
    System.out.println("Here is input string: " + inStr); 
 
    // Here, a simple expression lambda that uppercases a string 
    // is passed to stringOp( ). 
    outStr = stringOp((str) -> str.toUpperCase(), inStr); 
    System.out.println("The string in uppercase: " + outStr); 
 
    // This passes a block lambda that removes spaces. 
    outStr = stringOp((str) ->  { 
                       String result = ""; 
                       int i; 
 
                       for(i = 0; i < str.length(); i++) 
                       if(str.charAt(i) != ' ') 
                         result += str.charAt(i); 
 
                       return result; 
                     }, inStr); 
 
    System.out.println("The string with spaces removed: " + outStr); 
 
 
    // Of course, it is also possible to pass a StringFunc instance 
    // created by an earlier lambda expression. For example,  
    // after this declaration executes, reverse refers to a 
    // synthetic instance of StringFunc. 
    StringFunc reverse = (str) ->  { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
    }; 
 
    // Now, reverse can be passed as the first parameter to stringOp() 
    // since it refers to a StringFunc object. 
    System.out.println("The string reversed: " + 
                       stringOp(reverse, inStr)); 
  } 
}

```

## Lambda Expressions and Exceptions

A lambda expression can throw an exception. However, it if throws a checked exception, then that exception must be compatible with the exception(s) listed in the throws clause of the abstract method in the functional interface

```
interface DoubleNumericArrayFunc { 
  double func(double[] n) throws EmptyArrayException; 
} 
 
class EmptyArrayException extends Exception { 
  EmptyArrayException() { 
    super("Array Empty"); 
  } 
} 
 
class LambdaExceptionDemo { 
 
  public static void main(String args[]) throws EmptyArrayException 
  { 
    double[] values  = { 1.0, 2.0, 3.0, 4.0 }; 
 
    // This block lambda computes the average of an array of doubles. 
    DoubleNumericArrayFunc average = (n) ->  { 
      double sum = 0; 
 
      if(n.length == 0) 
        throw new EmptyArrayException(); 
 
      for(int i=0; i < n.length; i++) 
        sum += n[i]; 
 
      return sum / n.length; 
    }; 
 
    System.out.println("The average is " + average.func(values)); 
 
    // This causes an exception to be thrown. 
    System.out.println("The average is " + average.func(new double[0])); 
  } 
}
```

## Lambda Expressions and Variable Capture

Variables defined by the enclosing scope of a lambda expression are accessible within the lambda expression. For example, a lambda expression can use an instance or static variable defined by its enclosing class. A lambda expression also has access to this (both explicitly and implicitly), which refers to the invoking instance of the lambda expression’s enclosing class. Thus, a lambda expression can obtain or set the value of an instance or static variable and call a method defined by its enclosing class.
However, when a lambda expression uses a local variable from its enclosing scope, a special situation is created that is referred to as a variable capture. In this case, a lambda expression may only use local variables that are effectively final. An effectively final variable is one whose value does not change after it is first assigned. There is no need to explicitly declare such a variable as final, although doing so would not be an error. (The this parameter of an enclosing scope is automatically effectively final, and lambda expressions do not have a this of their own.)

```
// An example of capturing a local variable from the enclosing scope. 
 
interface MyFunc { 
  int func(int n); 
} 
 
class VarCapture { 
  public static void main(String args[]) 
  { 
    // A local variable that can be captured. 
    int num = 10; 
 
    MyFunc myLambda = (n) ->  { 
      // This use of num is OK. It does not modify num. 
      int v = num + n; 
 
      // However, the following is illegal because it attempts  
      // to modify the value of num. 
//    num++; 
 
      return v; 
    }; 
 
    // The following line would also cause an error, because 
    // it would remove the effectively final status from num. 
//  num = 9; 
  } 
}
```

## Method References

There is an important feature related to lambda expressions called the method reference. A method reference provides a way to refer to a method without executing it. It relates to lambda expressions because it, too, requires a target type context that consists of a compatible functional interface. When evaluated, a method reference also creates an instance of the functional interface.

### Method References to static Methods

To create a static method reference, use this general syntax:
```
ClassName::methodName
```
Notice that the class name is separated from the method name by a double colon. The :: is a new separator that has been added to Java by JDK 8 expressly for this purpose. This method reference can be used anywhere in which it is compatible with its target type.

```
// Demonstrate a method reference for a static method. 
 
// A functional interface for string operations. 
interface StringFunc { 
  String func(String n); 
} 
 
// This class defines a static method called strReverse(). 
class MyStringOps { 
  // A static method that reverses a string. 
  static String strReverse(String str) { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
  } 
} 

class MethodRefDemo { 
 
  // This method has a functional interface as the type of 
  // its first parameter. Thus, it can be passed any instance 
  // of that interface, including a method reference. 
  static String stringOp(StringFunc sf, String s) { 
    return sf.func(s); 
  } 
 
  public static void main(String args[]) 
  { 
    String inStr = "Lambdas add power to Java"; 
    String outStr; 
 
    // Here, a method reference to strReverse is passed to stringOp(). 
    outStr = stringOp(MyStringOps::strReverse, inStr); 
 
    System.out.println("Original string: " + inStr); 
    System.out.println("String reversed: " + outStr); 
  } 
}

```

### Method References to Instance Methods

To pass a reference to an instance method on a specific object, use this basic syntax:
```
objRef::methodName
```
As you can see, the syntax is similar to that used for a static method, except that an object reference is used instead of a class name. 

```
/ Demonstrate a method reference to an instance method 
 
// A functional interface for string operations. 
interface StringFunc { 
  String func(String n); 
} 
 
// Now, this class defines an instance method called strReverse(). 
class MyStringOps { 
  String strReverse(String str) { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
  } 
}     
 
class MethodRefDemo2 { 
 
  // This method has a functional interface as the type of 
  // its first parameter. Thus, it can be passed any instance 
  // of that interface, including method references. 
  static String stringOp(StringFunc sf, String s) { 
    return sf.func(s); 
  } 
 
  public static void main(String args[]) 
  { 
    String inStr = "Lambdas add power to Java"; 
    String outStr; 
 
    // Create a MyStringOps object. 
    MyStringOps strOps = new MyStringOps( ); 
 
    // Now, a method reference to the instance method strReverse 
    // is passed to stringOp(). 
    outStr = stringOp(strOps::strReverse, inStr); 
 
    System.out.println("Original string: " + inStr); 
    System.out.println("String reversed: " + outStr); 
  } 
}
```
### Method References with Generics

Although the preceding examples show the mechanics of using method references, they don’t show their real benefits. One place method references can be quite useful is in conjunction with the Collections Framework, which is described later in Chapter 18. However, for completeness, a short, but effective, example that uses a method reference to help determine the largest element in a collection is included here.


```
// Demonstrate a method reference to a generic method 
// declared inside a non-generic class. 
 
// A functional interface that operates on an array 
// and a value, and returns an int result. 
interface MyFunc<T> { 
  int func(T[] vals, T v); 
} 
 
// This class defines a method called countMatching() that 
// returns the number of items in an array that are equal  
// to a specified value. Notice that countMatching() 
// is generic, but MyArrayOps is not. 
class MyArrayOps { 
  static <T> int countMatching(T[] vals, T v) { 
    int count = 0; 
 
    for(int i=0; i < vals.length; i++) 
      if(vals[i] == v) count++; 
 
      return count; 
  } 
}     
 
class GenericMethodRefDemo { 
 
  // This method has the MyFunc functional interface as the 
  // type of its first parameter. The other two parameters 
  // receive an array and a value, both of type T. 
  static <T> int myOp(MyFunc<T> f, T[] vals, T v) { 
    return f.func(vals, v); 
  } 
 
  public static void main(String args[]) 
  { 
    Integer[] vals = { 1, 2, 3, 4, 2 ,3, 4, 4, 5 }; 
    String[] strs = { "One", "Two", "Three", "Two" }; 
    int count; 
 
    count = myOp(MyArrayOps::<Integer>countMatching, vals, 4); 
    System.out.println("vals contains " + count + " 4s"); 
 
    count = myOp(MyArrayOps::<String>countMatching, strs, "Two"); 
    System.out.println("strs contains " + count + " Twos"); 
  } 
}
```


One way to find the largest element in a collection is to use the max( ) method defined by the Collections class. For the version of max( ) used here, you must pass a reference to the collection and an instance of an object that implements the Comparator<T> interface. This interface specifies how two objects are compared. It defines only one abstract method, called compare( ), that takes two arguments, each the type of the objects being compared. It must return greater than zero if the first argument is greater than the second, zero if the two arguments are equal, and less than zero if the first object is less than the second.

In the past, to use max( ) with user-defined objects, an instance of Comparator<T> had to be obtained by first explicitly implementing it by a class, and then creating an instance of that class. This instance was then passed as the comparator to max( ). With JDK 8, it is now possible to simply pass a reference to a comparison method to max( ) because doing so automatically implements the comparator. The following simple example shows the process by creating an ArrayList of MyClass objects and then finding the one in the list that has the highest value (as defined by the comparison method).


```
// Use a method reference to help find the maximum value in a collection. 
import java.util.*; 
 
class MyClass { 
  private int val; 
 
  MyClass(int v) { val = v; } 
 
  int getVal() { return val; } 
} 
 
class UseMethodRef { 
  // A compare() method compatible with the one defined by Comparator<T>. 
  static int compareMC(MyClass a, MyClass b) { 
    return a.getVal() - b.getVal(); 
  } 
 
  public static void main(String args[]) 
  { 
    ArrayList<MyClass> al = new ArrayList<MyClass>(); 
 
    al.add(new MyClass(1)); 
    al.add(new MyClass(4)); 
    al.add(new MyClass(2)); 
    al.add(new MyClass(9)); 
    al.add(new MyClass(3)); 
    al.add(new MyClass(7)); 
 
    // Find the maximum value in al using the compareMC() method. 
    MyClass maxValObj = Collections.max(al, UseMethodRef::compareMC); 
 
    System.out.println("Maximum value is: " + maxValObj.getVal()); 
  } 
}

```


## Constructor References

Similar to the way that you can create references to methods, you can create references to constructors. Here is the general form of the syntax that you will use:
classname::new























