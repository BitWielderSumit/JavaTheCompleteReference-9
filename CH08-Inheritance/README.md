# Inheritance


## Using super
super has two general forms. The first calls the superclass’ constructor. The second is used to access a member of the superclass that has been hidden by a member of a subclass.

```

// construct clone of an object
Box(Box ob) { // pass object to constructor
  width = ob.width;
  height = ob.height;
  depth = ob.depth;
}


 // construct clone of an object
BoxWeight(BoxWeight ob) { // pass object to constructor
  super(ob);
  weight = ob.weight;
}

```



## A Second Use for super
super.member
Here, member can be either a method or an instance variable.


## When Constructors Are Executed
When a class hierarchy is created, in what order are the constructors for the classes that make up the hierarchy executed? For example, given a subclass called B and a superclass called A, is A’s constructor executed before B’s, or vice versa? The answer is that in a class hierarchy, constructors complete their execution in order of derivation, from superclass to subclass. Further, since super( ) must be the first statement executed in a subclass’ constructor, this order is the same whether or not super( ) is used. If super( ) is not used, then the default or parameterless constructor of each superclass will be executed.



```
// Demonstrate when constructors are called.

// Create a super class.
class A {
  A() { 
    System.out.println("Inside A's constructor.");
  }
}

// Create a subclass by extending class A.
class B extends A {
  B() {
    System.out.println("Inside B's constructor.");
  }
}

// Create another subclass by extending B.
class C extends B {
  C() {
    System.out.println("Inside C's constructor.");
  }
}
  
class CallingCons {
  public static void main(String args[]) {
    C c = new C();
  }
}

OUTPUT
Inside A's constructor.
Inside B's constructor.
Inside C's constructor.
```

## Dynamic Method Dispatch

When different types of objects are referred to, different versions of an overridden method will be called. In other words, it is the type of the object being referred to (not the type of the reference variable) that determines which version of an overridden method will be executed

```
lass A {
   void callme() {
     System.out.println("Inside A's callme method");
  }
}

class B extends A {
  // override callme()
  void callme() {
    System.out.println("Inside B's callme method");
  }
}

class C extends A {
  // override callme()
  void callme() {
    System.out.println("Inside C's callme method");
  }
}

class Dispatch {
  public static void main(String args[]) {
    A a = new A(); // object of type A
    B b = new B(); // object of type B
    C c = new C(); // object of type C
    A r; // obtain a reference of type A    

    r = a; // r refers to an A object
    r.callme(); // calls A's version of callme

    r = b; // r refers to a B object
    r.callme(); // calls B's version of callme

    r = c; // r refers to a C object
    r.callme(); // calls C's version of callme
  }
}
```


## Using Abstract Classes
You can require that certain methods be overridden by subclasses by specifying the abstract type modifier. These methods are sometimes referred to as subclasser responsibility because they have no implementation specified in the superclass. Thus, a subclass must override them—it cannot simply use the version defined in the superclass.

```
abstract type name(parameter-list);
```

Any class that contains one or more abstract methods must also be declared abstract. To declare a class abstract, you simply use the abstract keyword in front of the class keyword at the beginning of the class declaration. There can be no objects of an abstract class. That is, an abstract class cannot be directly instantiated with the new operator. Such objects would be useless, because an abstract class is not fully defined. Also, you cannot declare abstract constructors, or abstract static methods. Any subclass of an abstract class must either implement all of the abstract methods in the superclass, or be declared abstract itself.




## Using final with Inheritance

Using final to Prevent Overriding

```
class A {
  final void meth() {
    System.out.println("This is a final method.");
  }
}

class B extends A {
  void meth() { // ERROR! Can't override.
    System.out.println("Illegal!");
  }
}
```

Using final to Prevent Inheritance

```
final class A {
  // ...
}

// The following class is illegal.
class B extends A { // ERROR! Can't subclass A
  // ...
}

```

## The Object Class

There is one special class, Object, defined by Java. All other classes are subclasses of Object. That is, Object is a superclass of all other classes. This means that a reference variable of type Object can refer to an object of any other class. Also, since arrays are implemented as classes, a variable of type Object can also refer to any array.
Object defines the following methods, which means that they are available in every object.



Object clone( )   --> Creates a new object that is the same as the object being cloned.
boolean equals(Object object) --> Determines whether one object is equal to another.
void finalize( ) --> Called before an unused object is recycled.
Class<?> getClass( ) --> Obtains the class of an object at run time.
int hashCode( ) --> Returns the hash code associated with the invoking object.
void notify( ) --> Resumes execution of a thread waiting on the invoking object.
void notifyAll( ) --> Resumes execution of all threads waiting on the invoking object.
String toString( ) --> Returns a string that describes the object.
void wait( ) 
void wait(long milliseconds)
void wait(long milliseconds, int nanoseconds) --> Waits on another thread of execution.






















