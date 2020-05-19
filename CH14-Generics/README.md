# Generics

Through the use of generics, it is possible to create classes, interfaces, and methods that will work in a type-safe manner with various kinds of data. Many algorithms are logically the same no matter what type of data they are being applied to. For example, the mechanism that supports a stack is the same whether that stack is storing items of type Integer, String, Object, or Thread. With generics, you can define an algorithm once, independently of any specific type of data, and then apply that algorithm to a wide variety of data types without any additional effort. The expressive power generics added to the language fundamentally changed the way that Java code is written.


## What Are Generics?
* At its core, the term generics means parameterized types. Parameterized types are important because they enable you to create classes, interfaces, and methods in which the type of data upon which they operate is specified as a parameter. Using generics, it is possible to create a single class, for example, that automatically works with different types of data. A class, interface, or method that operates on a parameterized type is called generic, as in generic class or generic method.
* It is important to understand that Java has always given you the ability to create generalized classes, interfaces, and methods by operating through references of type Object. Because Object is the superclass of all other classes, an Object reference can refer to any type object. 
* Generics added the type safety that was lacking. They also streamlined the process, because it is no longer necessary to explicitly employ casts to translate between Object and the type of data that is actually being operated upon. With generics, all casts are automatic and implicit. Thus, generics expanded your ability to reuse code and let you do so safely and easily.

```
// A simple generic class.  
// Here, T is a type parameter that 
// will be replaced by a real type 
// when an object of type Gen is created. 
class Gen<T> { 
  T ob; // declare an object of type T 
   
  // Pass the constructor a reference to  
  // an object of type T. 
  Gen(T o) { 
    ob = o; 
  } 
 
  // Return ob. 
  T getob() { 
    return ob; 
  } 
 
  // Show type of T. 
  void showType() { 
    System.out.println("Type of T is " + 
                       ob.getClass().getName()); 
  } 
} 
 
// Demonstrate the generic class. 
class GenDemo { 
  public static void main(String args[]) { 
    // Create a Gen reference for Integers.  
    Gen<Integer> iOb;  
 
    // Create a Gen<Integer> object and assign its 
    // reference to iOb.  Notice the use of autoboxing  
    // to encapsulate the value 88 within an Integer object. 
    iOb = new Gen<Integer>(88); 
 
    // Show the type of data used by iOb. 
    iOb.showType(); 
 
    // Get the value in iOb. Notice that 
    // no cast is needed. 
    int v = iOb.getob(); 
    System.out.println("value: " + v); 
 
    System.out.println(); 
 
    // Create a Gen object for Strings. 
    Gen<String> strOb = new Gen<String>("Generics Test"); 
 
    // Show the type of data used by strOb. 
    strOb.showType(); 
 
    // Get the value of strOb. Again, notice 
    // that no cast is needed. 
    String str = strOb.getob(); 
    System.out.println("value: " + str); 
  } 
}
```

## Generics Work Only with Reference Types
When declaring an instance of a generic type, the type argument passed to the type parameter must be a reference type. You cannot use a primitive type, such as int or char. For example, with Gen, it is possible to pass any class type to T, but you cannot pass a primitive type to a type parameter.

## Generic Types Differ Based on Their Type Arguments
A key point to understand about generic types is that a reference of one specific version of a generic type is not type compatible with another version of the same generic type.

## How Generics Improve Type Safety
 generics automatically ensure the type safety of all operations involving Gen. In the process, they eliminate the need for you to enter casts and to type-check code by hand.

```
// NonGen is functionally equivalent to Gen 
// but does not use generics.  
class NonGen {  
  Object ob; // ob is now of type Object 
    
  // Pass the constructor a reference to   
  // an object of type Object 
  NonGen(Object o) {  
    ob = o;  
  }  
  
  // Return type Object. 
  Object getob() {  
    return ob;  
  }  
 
  // Show type of ob.  
  void showType() {  
    System.out.println("Type of ob is " +  
                       ob.getClass().getName());  
  }  
}  
  
// Demonstrate the non-generic class.  
class NonGenDemo {  
  public static void main(String args[]) {  
    NonGen iOb;   
  
    // Create NonGen Object and store 
    // an Integer in it. Autoboxing still occurs. 
    iOb = new NonGen(88);  
  
    // Show the type of data used by iOb. 
    iOb.showType(); 
 
    // Get the value of iOb. 
    // This time, a cast is necessary. 
    int v = (Integer) iOb.getob();  
    System.out.println("value: " + v);  
  
    System.out.println();  
  
    // Create another NonGen object and  
    // store a String in it. 
    NonGen strOb = new NonGen("Non-Generics Test");  
  
    // Show the type of data used by strOb. 
    strOb.showType(); 
 
    // Get the value of strOb. 
    // Again, notice that a cast is necessary.  
    String str = (String) strOb.getob();  
    System.out.println("value: " + str);  
 
    // This compiles, but is conceptually wrong! 
    iOb = strOb; 
    v = (Integer) iOb.getob(); // run-time error! 
  }  
}
```

## Bounded Types
In the preceding examples, the type parameters could be replaced by any class type. This is fine for many purposes, but sometimes it is useful to limit the types that can be passed to a type parameter. For example, assume that you want to create a generic class that contains a method that returns the average of an array of numbers. Furthermore, you want to use the class to obtain the average of an array of any type of number, including integers, floats, and doubles. Thus, you want to specify the type of the numbers generically, using a type parameter. To create such a class, you might try something like this:

```
/ Stats attempts (unsuccessfully) to  
// create a generic class that can compute 
// the average of an array of numbers of 
// any given type. 
// 
// The class contains an error! 
class Stats<T> {  
  T[] nums; // nums is an array of type T 
    
  // Pass the constructor a reference to   
  // an array of type T. 
  Stats(T[] o) {  
    nums = o;  
  }  
  
  // Return type double in all cases. 
  double average() {  
    double sum = 0.0; 
 
    for(int i=0; i < nums.length; i++)  
      sum += nums[i].doubleValue(); // Error!!! 
 
    return sum / nums.length; 
  }  
}

```

To handle such situations, Java provides bounded types. When specifying a type parameter, you can create an upper bound that declares the superclass from which all type arguments must be derived. This is accomplished through the use of an extends clause when specifying the type parameter, as shown here:


## Using Wildcard Arguments

```
// Use a wildcard.  
class Stats<T extends Number> {   
  T[] nums; // array of Number or subclass  
     
  // Pass the constructor a reference to    
  // an array of type Number or subclass.  
  Stats(T[] o) {   
    nums = o;   
  }   
   
  // Return type double in all cases.  
  double average() {   
    double sum = 0.0;  
  
    for(int i=0; i < nums.length; i++)   
      sum += nums[i].doubleValue();  
  
    return sum / nums.length;  
  } 
 
  // Determine if two averages are the same. 
  // Notice the use of the wildcard. 
  boolean sameAvg(Stats<?> ob) { 
    if(average() == ob.average())  
      return true; 
 
    return false; 
  } 
}   
   
// Demonstrate wildcard. 
class WildcardDemo {   
  public static void main(String args[]) {   
    Integer inums[] = { 1, 2, 3, 4, 5 };  
    Stats<Integer> iob = new Stats<Integer>(inums);    
    double v = iob.average();  
    System.out.println("iob average is " + v);  
  
    Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };  
    Stats<Double> dob = new Stats<Double>(dnums);    
    double w = dob.average();  
    System.out.println("dob average is " + w);  
  
    Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };  
    Stats<Float> fob = new Stats<Float>(fnums);    
    double x = fob.average();  
    System.out.println("fob average is " + x);  
  
    // See which arrays have same average. 
    System.out.print("Averages of iob and dob "); 
    if(iob.sameAvg(dob)) 
      System.out.println("are the same.");  
    else 
      System.out.println("differ.");  
 
    System.out.print("Averages of iob and fob "); 
    if(iob.sameAvg(fob)) 
      System.out.println("are the same.");  
    else 
      System.out.println("differ.");  
  }   
}
```


## Bounded Wildcards
```
// Bounded Wildcard arguments. 
 
// Two-dimensional coordinates. 
class TwoD { 
  int x, y; 
 
  TwoD(int a, int b) { 
    x = a; 
    y = b; 
  } 
} 
 
// Three-dimensional coordinates. 
class ThreeD extends TwoD { 
  int z; 
   
  ThreeD(int a, int b, int c) { 
    super(a, b); 
    z = c; 
  } 
} 
 
// Four-dimensional coordinates. 
class FourD extends ThreeD { 
  int t; 
 
  FourD(int a, int b, int c, int d) { 
    super(a, b, c); 
    t = d;  
  } 
} 
 
// This class holds an array of coordinate objects. 
class Coords<T extends TwoD> { 
  T[] coords; 
 
  Coords(T[] o) { coords = o; } 
} 
 
// Demonstrate a bounded wildcard. 
class BoundedWildcard { 
  static void showXY(Coords<?> c) { 
    System.out.println("X Y Coordinates:"); 
    for(int i=0; i < c.coords.length; i++) 
      System.out.println(c.coords[i].x + " " + 
                         c.coords[i].y); 
    System.out.println(); 
  } 
 
  static void showXYZ(Coords<? extends ThreeD> c) { 
    System.out.println("X Y Z Coordinates:"); 
    for(int i=0; i < c.coords.length; i++) 
      System.out.println(c.coords[i].x + " " + 
                         c.coords[i].y + " " + 
                         c.coords[i].z); 
    System.out.println(); 
  } 
 
  static void showAll(Coords<? extends FourD> c) { 
    System.out.println("X Y Z T Coordinates:"); 
    for(int i=0; i < c.coords.length; i++) 
      System.out.println(c.coords[i].x + " " + 
                         c.coords[i].y + " " + 
                         c.coords[i].z + " " + 
                         c.coords[i].t); 
    System.out.println(); 
  } 
 
  public static void main(String args[]) { 
    TwoD td[] = { 
      new TwoD(0, 0), 
      new TwoD(7, 9), 
      new TwoD(18, 4), 
      new TwoD(-1, -23) 
    }; 
 
    Coords<TwoD> tdlocs = new Coords<TwoD>(td);     
 
    System.out.println("Contents of tdlocs."); 
    showXY(tdlocs); // OK, is a TwoD 
//  showXYZ(tdlocs); // Error, not a ThreeD 
//  showAll(tdlocs); // Error, not a FourD 
 
    // Now, create some FourD objects. 
    FourD fd[] = { 
      new FourD(1, 2, 3, 4), 
      new FourD(6, 8, 14, 8), 
      new FourD(22, 9, 4, 9), 
      new FourD(3, -2, -23, 17) 
    }; 
 
    Coords<FourD> fdlocs = new Coords<FourD>(fd);     
 
    System.out.println("Contents of fdlocs."); 
    // These are all OK. 
    showXY(fdlocs);  
    showXYZ(fdlocs); 
    showAll(fdlocs); 
  } 
}
```


```
In general, to establish an upper bound for a wildcard, use the following type of wildcard expression:
<? extends superclass>
where superclass is the name of the class that serves as the upper bound. Remember, this is an inclusive clause because the class forming the upper bound (that is, specified by superclass) is also within bounds.
You can also specify a lower bound for a wildcard by adding a super clause to a wildcard declaration. Here is its general form:
<? super subclass>
In this case, only classes that are superclasses of subclass are acceptable arguments. This is an inclusive clause.
```


## Creating a Generic Method
As the preceding examples have shown, methods inside a generic class can make use of a class’ type parameter and are, therefore, automatically generic relative to the type parameter. However, it is possible to declare a generic method that uses one or more type parameters of its own. Furthermore, it is possible to create a generic method that is enclosed within a non-generic class.

```
// Demonstrate a simple generic method. 
class GenMethDemo {  
 
  // Determine if an object is in an array. 
  static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) { 
 
    for(int i=0; i < y.length; i++) 
      if(x.equals(y[i])) return true; 
 
    return false; 
  } 
 
  public static void main(String args[]) {  
 
    // Use isIn() on Integers. 
    Integer nums[] = { 1, 2, 3, 4, 5 }; 
 
    if(isIn(2, nums)) 
      System.out.println("2 is in nums"); 
 
    if(!isIn(7, nums)) 
      System.out.println("7 is not in nums"); 
 
    System.out.println(); 
 
    // Use isIn() on Strings. 
    String strs[] = { "one", "two", "three", 
                      "four", "five" }; 
 
    if(isIn("two", strs)) 
      System.out.println("two is in strs"); 
 
    if(!isIn("seven", strs)) 
      System.out.println("seven is not in strs"); 
 
    // Opps! Won't compile! Types must be compatible. 
//    if(isIn("two", nums)) 
//      System.out.println("two is in strs"); 
  }  
}
```

## Generic Constructors

```
class GenCons { 
  private double val; 
 
  <T extends Number> GenCons(T arg) { 
    val = arg.doubleValue(); 
  } 
 
  void showval() { 
    System.out.println("val: " + val); 
  } 
} 
 
class GenConsDemo { 
  public static void main(String args[]) { 
 
    GenCons test = new GenCons(100); 
    GenCons test2 = new GenCons(123.5F); 
 
    test.showval(); 
    test2.showval(); 
  } 
}
```

## Generic Interfaces

```
// A Min/Max interface. 
interface MinMax<T extends Comparable<T>> { 
  T min(); 
  T max(); 
} 
 
// Now, implement MinMax 
class MyClass<T extends Comparable<T>> implements MinMax<T> { 
  T[] vals; 
 
  MyClass(T[] o) { vals = o; } 
 
  // Return the minimum value in vals. 
  public T min() { 
    T v = vals[0]; 
 
    for(int i=1; i < vals.length; i++) 
      if(vals[i].compareTo(v) < 0) v = vals[i]; 
 
    return v; 
  } 
 
  // Return the maximum value in vals. 
  public T max() { 
    T v = vals[0]; 
 
    for(int i=1; i < vals.length; i++) 
      if(vals[i].compareTo(v) > 0) v = vals[i]; 
 
    return v; 
  } 
} 
```



















