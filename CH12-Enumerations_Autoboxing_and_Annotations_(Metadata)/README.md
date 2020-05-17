# Enumerations_Autoboxing_and_Annotations_(Metadata)

## Enumerations
* In its simplest form, an enumeration is a list of named constants. 
* By making enumerations into classes, the capabilities of the enumeration are greatly expanded. For example, in Java, an enumeration can have constructors, methods, and instance variables.

```
enum Apple {  
  Jonathan, GoldenDel, RedDel, Winesap, Cortland 
}
```
The identifiers Jonathan, GoldenDel, and so on, are called enumeration constants.
Each is implicitly declared as a public, static final member of Apple.

Once you have defined an enumeration, you can create a variable of that type. However, even though enumerations define a class type, you do not instantiate an enum using new. Instead, you declare and use an enumeration variable in much the same way as you do one of the primitive types. For example, this declares ap as a variable of enumeration type Apple:

```
Apple ap;
```

Because ap is of type Apple, the only values that it can be assigned (or can contain) are those defined by the enumeration

```
ap = Apple.RedDel
```

Two enumeration constants can be compared for equality by using the = = relational operator.

An enumeration value can also be used to control a switch statement. 

## The values( ) and valueOf( ) Methods

public static enum-type [ ] values( )
public static enum-type valueOf(String str )

```
/ Use the built-in enumeration methods. 
 
// An enumeration of apple varieties. 
enum Apple {  
  Jonathan, GoldenDel, RedDel, Winesap, Cortland 
} 
 
class EnumDemo2 { 
  public static void main(String args[])  
  { 
    Apple ap; 
 
    System.out.println("Here are all Apple constants"); 
 
    // use values() 
    Apple allapples[] = Apple.values(); 
    for(Apple a : allapples) 
      System.out.println(a); 
 
    System.out.println(); 
    
    // use valueOf() 
    ap = Apple.valueOf("Winesap"); 
    System.out.println("ap contains " + ap); 
 
  } 
}
```

## Java Enumerations Are Class Types
As explained, a Java enumeration is a class type. Although you don’t instantiate an enum using new, it otherwise has much the same capabilities as other classes. The fact that enum defines a class gives the Java enumeration extraordinary power. For example, you can give them constructors, add instance variables and methods, and even implement interfaces.

It is important to understand that each enumeration constant is an object of its enumeration type. Thus, when you define a constructor for an enum, the constructor is called when each enumeration constant is created. Also, each enumeration constant has its own copy of any instance variables defined by the enumeration


```
enum Apple { 
  Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8); 
 
  private int price; // price of each apple 
 
  // Constructor 
  Apple(int p) { price = p; } 
 
  int getPrice() { return price; } 
} 
```

This version of Apple adds three things. The first is the instance variable price, which is used to hold the price of each variety of apple. The second is the Apple constructor, which is passed the price of an apple. The third is the method getPrice( ), which returns the value of price.

Here are two restrictions that apply to enumerations. First, an enumeration can’t inherit another class. Second, an enum cannot be a superclass. This means that an enum can’t be extended. Otherwise, enum acts much like any other class type. The key is to remember that each of the enumeration constants is an object of the class in which it is defined.

## Enumerations Inherit Enum

Although you can’t inherit a superclass when declaring an enum, all enumerations automatically inherit one: java.lang.Enum. This class defines several methods that are available for use by all enumerations.

```
/ Demonstrate ordinal(), compareTo(), and equals(). 
 
// An enumeration of apple varieties. 
enum Apple {  
  Jonathan, GoldenDel, RedDel, Winesap, Cortland 
} 
 
class EnumDemo4 { 
  public static void main(String args[])  
  { 
    Apple ap, ap2, ap3; 
 
    // Obtain all ordinal values using ordinal(). 
    System.out.println("Here are all apple constants" + 
                       " and their ordinal values: "); 
    for(Apple a : Apple.values()) 
      System.out.println(a + " " + a.ordinal()); 
 
    ap =  Apple.RedDel; 
    ap2 = Apple.GoldenDel; 
    ap3 = Apple.RedDel; 
 
    System.out.println(); 
 
    // Demonstrate compareTo() and equals() 
    if(ap.compareTo(ap2) < 0) 
      System.out.println(ap + " comes before " + ap2); 
 
    if(ap.compareTo(ap2) > 0) 
      System.out.println(ap2 + " comes before " + ap); 
 
    if(ap.compareTo(ap3) == 0) 
      System.out.println(ap + " equals " + ap3); 
   
    System.out.println(); 
 
    if(ap.equals(ap2)) 
      System.out.println("Error!"); 
 
    if(ap.equals(ap3)) 
      System.out.println(ap + " equals " + ap3); 
 
    if(ap == ap3) 
      System.out.println(ap + " == " + ap3); 
 
  } 
}

```

## Type Wrappers

Despite the performance benefit offered by the primitive types, there are times when you will need an object representation. For example, you can’t pass a primitive type by reference to a method. Also, many of the standard data structures implemented by Java operate on objects, which means that you can’t use these data structures to store primitive types. To handle these (and other) situations, Java provides type wrappers, which are classes that encapsulate a primitive type within an object.


## Autoboxing

Beginning with JDK 5, Java added two important features: autoboxing and auto-unboxing. Autoboxing is the process by which a primitive type is automatically encapsulated (boxed) into its equivalent type wrapper whenever an object of that type is needed. There is no need to explicitly construct an object. Auto-unboxing is the process by which the value of a boxed object is automatically extracted (unboxed) from a type wrapper when its value is needed. There is no need to call a method such as intValue( ) or doubleValue( ).



## Annotation Basics
// I am not getting use cases / basic purpose of this.
// Get this understood from different source.


















