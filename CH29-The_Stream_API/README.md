# The Stream API

## Stream Basics
```
* Purpose of stream is to operate on data source and not to store data source like collections.
* Stream can be used to perform sql like operations like filter, sort, map on collection of entities.
```

## Stream Interfaces
```
* Interface BaseStream (delaration and methods as below), defines basic funtionality available in all streams.
* BaseStream extends the **AutoCloseable** interface.
```

* Declaration.
```
interface BaseStream<T, S extends BaseStream<T, S>>

* Here, T specifies the type of the elements in the stream, and S specifies the type of stream that extends BaseStream.
```

![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab29-1.jpg)


### Stream interface
* Stread is Derived from basestream
```
interface Stream<T>
* Here, T specifies the type of the elements in the stream. Because it is generic, Stream is used for all reference types.
```
![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab29-2.jpg)
![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab29-2a.jpg)

**Terminal operations**
```
* A terminal operation consumes the stream.
* Once a stream has been consumed, it cannot be reused.
* Example min, max, count.
```

**Intermediate operations**
```
* Intermediate operations produce another stream
* Intermediate operations can be used to create a pipeline that performs a sequence of actions
* Intermediate operations are executed **lazily.**
* In **Stateless** operation, each element is processed independently of the others, e.g. filtering.
* In a **stateful** operation, the processing of an element depend on aspects of the other elements. e.g. sorting
```

```
* A stream can operate on object reference only, to operate on primitive types, following interfaces introduced.
1) DoubleStream
2) IntStream
3) LongStream 
```

## How to Obtain a Stream

### Obtain Stream from collection
```
* Beginning with JDK 8, the Collection interface has been expanded to include two methods that obtain a stream from a collection.
1) default Stream<E> stream( ) 
2) default Stream<E> parallelStream( )
* Because Collection is implemented by every collection, these methods can be used to obtain a stream from any collection class, such as ArrayList or HashSet.
```

### Obtain Stream from array
```
* To obtain stream from array use static method **stream** added in java 8 
```





interface Stream<T>
```

* terminal
	A terminal operation consumes the stream. It is used to produce a result, such as finding the minimum value in the stream, or to execute some action, as is the case with the forEach( ) method. Once a stream has been consumed, it cannot be reused
* intermediate
	Intermediate operations produce another stream. Thus, intermediate operations can be used to create a pipeline that performs a sequence of actions. One other point: intermediate operations do not take place immediately. Instead, the specified action is performed when a terminal operation is executed on the new stream created by an intermediate operation. This mechanism is referred to as lazy behavior

	** stateless
		In a stateless operation, each element is processed independently of the others.
		e.g. filtering

	** stateful
		In a stateful operation, the processing of an element may depend on aspects of the other elements.
		e.g. sorting


Because Stream operates on object references, it can’t operate directly on primitive types. To handle primitive type streams, the stream API defines the following interfaces:

DoubleStream
IntStream
LongStream

## How to Obtain a Stream

You can obtain a stream in a number of ways. Perhaps the most common is when a stream is obtained for a collection. Beginning with JDK 8, the Collection interface has been expanded to include two methods that obtain a stream from a collection

```
default Stream<E> stream( )
default Stream<E> parallelStream( )
```

A stream can also be obtained from an array by use of the static stream( ) method, which was added to the Arrays class by JDK 8. One of its forms is shown here:

```
static <T> Stream<T> stream(T[ ] array)

Several overloads of the stream( ) method are also defined, such as those that handle arrays of the primitive types. They return a stream of type IntStream, DoubleStream, or LongStream.
```

## A Simple Stream Example

```
/ Demonstrate several Stream operations. 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo { 
 
  public static void main(String[] args) { 
 
    // Create a list of Integer values. 
    ArrayList<Integer> myList = new ArrayList<>( ); 
    myList.add(7); 
    myList.add(18); 
    myList.add(10); 
    myList.add(24); 
    myList.add(17); 
    myList.add(5); 
 
    System.out.println("Original list: " + myList); 
 
    // Obtain a Stream to the array list. 
    Stream<Integer> myStream = myList.stream(); 
 
    // Obtain the minimum and maximum value by uses of min(), 
    // max(), isPresent(), and get(). 
    Optional<Integer> minVal = myStream.min(Integer::compare); 
    if(minVal.isPresent()) System.out.println("Minimum value: " + 
                                               minVal.get()); 
 
    // Must obtain a new stream because previous call to min() 
    // is a terminal operation that consumed the stream. 
    myStream = myList.stream(); 
    Optional<Integer> maxVal = myStream.max(Integer::compare); 
    if(maxVal.isPresent()) System.out.println("Maximum value: " + 
                                               maxVal.get()); 
 
    // Sort the stream by use of sorted(). 
    Stream<Integer> sortedStream = myList.stream().sorted(); 
 
    // Display the sorted stream by use of forEach(). 
    System.out.print("Sorted stream: "); 
    sortedStream.forEach((n) -> System.out.print(n + " ")); 
    System.out.println(); 
 
    // Display only the odd values by use of filter(). 
    Stream<Integer> oddVals =  
           myList.stream().sorted().filter((n) -> (n % 2) == 1); 
    System.out.print("Odd values: "); 
    oddVals.forEach((n) -> System.out.print(n + " ")); 
    System.out.println(); 
 
    // Display only the odd values that are greater than 5. Notice that 
    // two filter operations are pipelined. 
    oddVals = myList.stream().filter( (n) -> (n % 2) == 1) 
                             .filter((n) -> n > 5); 
    System.out.print("Odd values greater than 5: "); 
    oddVals.forEach((n) -> System.out.print(n + " ") ); 
    System.out.println(); 
  } 
}
```



## Reduction Operations
In the language of the stream API, they (min, max) represent reduction operations because each reduces a stream to a single value
By using reduce( ), you can return a value from a stream based on any arbitrary criteria. By definition, all reduction operations are terminal operations.

Stream defines three versions of reduce( ).
```
Optional<T> reduce(BinaryOperator<T> accumulator)

T reduce(T identityVal, BinaryOperator<T> accumulator)
```

accumulator is a function that operates on two values and produces a result.

identityVal is a value such that an accumulator operation involving identityVal and any element of the stream yields that element, unchanged. For example, if the operation is addition, then the identity value will be 0 because 0 + x is x. For multiplication, the value will be 1, because 1 * x is x.

BinaryOperator is a functional interface declared in java.util.function that extends the BiFunction functional interface. BiFunction defines this abstract method:
R apply(T val, U val2)
Here, R specifies the result type, T is the type of the first operand, and U is the type of second operand. Thus, apply( ) applies a function to its two operands (val and val2) and returns the result.


It is important to understand that the accumulator operation must satisfy three constraints

•  Stateless
•  Non-interfering
•  Associative


```
// Demonstrate the reduce() method. 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo2 { 
 
  public static void main(String[] args) { 
 
    // Create a list of Integer values. 
    ArrayList<Integer> myList = new ArrayList<>( ); 
 
    myList.add(7); 
    myList.add(18); 
    myList.add(10); 
    myList.add(24); 
    myList.add(17); 
    myList.add(5); 
 
    // Two ways to obtain the integer product of the elements 
    // in myList by use of reduce(). 
    Optional<Integer> productObj = myList.stream().reduce((a,b) -> a*b); 
    if(productObj.isPresent()) 
      System.out.println("Product as Optional: " + productObj.get()); 
 
    int product = myList.stream().reduce(1, (a,b) -> a*b); 
    System.out.println("Product as int: " + product); 
  } 
}
```

## Using Parallel Streams

As a general rule, any operation applied to a parallel stream must be stateless, non-interfering, associative

When using parallel streams, you might find the following version of reduce( ) especially helpful. It gives you a way to specify how partial results are combined:

```
// Demonstrate the use of a combiner with reduce() 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo3 { 
 
  public static void main(String[] args) { 
 
    // This is now a list of double values. 
    ArrayList<Double> myList = new ArrayList<>( ); 
 
    myList.add(7.0); 
    myList.add(18.0); 
    myList.add(10.0); 
    myList.add(24.0); 
    myList.add(17.0); 
    myList.add(5.0); 
 
    double productOfSqrRoots = myList.parallelStream().reduce( 
                                     1.0, 
                                     (a,b) -> a * Math.sqrt(b),                                      
                                     (a,b) -> a * b 
                                ); 
 
    System.out.println("Product of square roots: " + productOfSqrRoots); 
  } 
}
```

```
Consider elements on the list are distributed over floor, now you can pick (accumulate) two element at a time, and you have many workers to help you do the job.

now result from each worker, should be just multiplied, you again dont want to apply sqrt function on result.

hence this version of reduce is used.


```

There is one other aspect of a stream to keep in mind when using parallel execution: 

he order of the elements. Streams can be either ordered or unordered. In general, if the data source is ordered, then the stream will also be ordered. However, when using a parallel stream, a performance boost can sometimes be obtained by allowing a stream to be unordered. When a parallel stream is unordered, each partition of the stream can be operated on independently, without having to coordinate with the others. In cases in which the order of the operations does not matter, it is possible to specify unordered behavior by calling the unordered( ) method, shown here:
S unordered( )

forEach() -- UnOrdered
forEachOrdered() -- Ordered



## Mapping

Often it is useful to map the elements of one stream to another. For example, a stream that contains a database of name, telephone, and e-mail address information might map only the name and e-mail address portions to another stream. As another example, you might want to apply some transformation to the elements in a stream. To do this, you could map the transformed elements to a new stream. Because mapping operations are quite common, the stream API provides built-in support for them. The most general mapping method is map( ). 

The map function must be stateless and non-interfering.

Here map is applied first and reduce is applied afterwords.

```
// Map one stream to another. 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo4 { 
 
  public static void main(String[] args) { 
 
    // A list of double values. 
    ArrayList<Double> myList = new ArrayList<>( ); 
 
    myList.add(7.0); 
    myList.add(18.0); 
    myList.add(10.0); 
    myList.add(24.0); 
    myList.add(17.0); 
    myList.add(5.0); 
 
    // Map the square root of the elements in myList to a new stream. 
    Stream<Double> sqrtRootStrm = myList.stream().map((a) -> Math.sqrt(a)); 
 
    // Find the product to the square roots. 
    double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a,b) -> a*b); 
 
    System.out.println("Product of square roots is " + productOfSqrRoots); 
  } 
}

```

Additional versions.

```
IntStream mapToInt(ToIntFunction<? super T> mapFunc)
LongStream mapToLong(ToLongFunction<? super T> mapFunc)
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapFunc)
```

```
// Map a Stream to an intStream. 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo6 { 
 
  public static void main(String[] args) { 
 
    // A list of double values. 
    ArrayList<Double> myList = new ArrayList<>( ); 
 
    myList.add(1.1); 
    myList.add(3.6); 
    myList.add(9.2); 
    myList.add(4.7); 
    myList.add(12.1); 
    myList.add(5.0); 
 
    System.out.print("Original values in myList: "); 
    myList.stream().forEach( (a) -> { 
      System.out.print(a + " "); 
    }); 
    System.out.println(); 
 
    // Map the ceiling of the elements in myList to an InStream. 
    IntStream cStrm = myList.stream().mapToInt((a) -> (int) Math.ceil(a)); 
 
    System.out.print("The ceilings of the values in myList: "); 
    cStrm.forEach( (a) -> { 
      System.out.print(a + " "); 
    }); 
 
  } 
}

```


Before leaving the topic of mapping, it is necessary to point out that the stream API also provides methods that support flat maps. These are flatMap( ), flatMapToInt( ), flatMapToLong( ), and flatMapToDouble( ). The flat map methods are designed to handle situations in which each element in the original stream is mapped to more than one element in the resulting stream.



## Collecting

As the preceding examples have shown, it is possible (indeed, common) to obtain a stream from a collection. Sometimes it is desirable to obtain the opposite: to obtain a collection from a stream. To perform such an action, the stream API provides the collect( ) method.

<R, A> R collect(Collector<? super T, A, R> collectorFunc)

The Collectors class defines a number of static collector methods that you can use as-is. The two we will use are toList( ) and toSet( ), shown here:
static <T> Collector<T, ?, List<T>> toList( )
static <T> Collector<T, ?, Set<T>> toSet( )

```
// Demonstrate several Stream operations. 
 
import java.util.*; 
import java.util.stream.*; 
 
class StreamDemo { 
 
  public static void main(String[] args) { 
 
    // Create a list of Integer values. 
    ArrayList<Integer> myList = new ArrayList<>( ); 
    myList.add(7); 
    myList.add(18); 
    myList.add(10); 
    myList.add(24); 
    myList.add(17); 
    myList.add(5); 
 
    System.out.println("Original list: " + myList); 
 
    // Obtain a Stream to the array list. 
    Stream<Integer> myStream = myList.stream(); 
 
    // Obtain the minimum and maximum value by uses of min(), 
    // max(), isPresent(), and get(). 
    Optional<Integer> minVal = myStream.min(Integer::compare); 
    if(minVal.isPresent()) System.out.println("Minimum value: " + 
                                               minVal.get()); 
 
    // Must obtain a new stream because previous call to min() 
    // is a terminal operation that consumed the stream. 
    myStream = myList.stream(); 
    Optional<Integer> maxVal = myStream.max(Integer::compare); 
    if(maxVal.isPresent()) System.out.println("Maximum value: " + 
                                               maxVal.get()); 
 
    // Sort the stream by use of sorted(). 
    Stream<Integer> sortedStream = myList.stream().sorted(); 
 
    // Display the sorted stream by use of forEach(). 
    System.out.print("Sorted stream: "); 
    sortedStream.forEach((n) -> System.out.print(n + " ")); 
    System.out.println(); 
 
    // Display only the odd values by use of filter(). 
    Stream<Integer> oddVals =  
           myList.stream().sorted().filter((n) -> (n % 2) == 1); 
    System.out.print("Odd values: "); 
    oddVals.forEach((n) -> System.out.print(n + " ")); 
    System.out.println(); 
 
    // Display only the odd values that are greater than 5. Notice that 
    // two filter operations are pipelined. 
    oddVals = myList.stream().filter( (n) -> (n % 2) == 1) 
                             .filter((n) -> n > 5); 
    System.out.print("Odd values greater than 5: "); 
    oddVals.forEach((n) -> System.out.print(n + " ") ); 
    System.out.println(); 
  } 
}
```    

there is a second version that gives you more control over the collection process.

https://learning.oreilly.com/library/view/java-the-complete/9780071808552/ch29.html



## Iterators and Streams
The stream API supports two types of iterators. The first is the traditional Iterator. The second is Spliterator,






















