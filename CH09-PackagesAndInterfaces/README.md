# Packages and Interfaces

## Access Protection

While Java’s access control mechanism may seem complicated, we can simplify it as follows. Anything declared public can be accessed from anywhere. Anything declared private cannot be seen outside of its class. When a member does not have an explicit access specification, it is visible to subclasses as well as to other classes in the same package. This is the default access. If you want to allow an element to be seen outside your current package, but only to classes that subclass your class directly, then declare that element protected.

## Interfaces

Using the keyword interface, you can fully abstract a class’ interface from its implementation. That is, using interface, you can specify what a class must do, but not how it does it

To implement an interface, a class must provide the complete set of methods required by the interface. However, each class is free to determine the details of its own implementation. 

Interfaces are designed to support dynamic method resolution at run time.

As the general form shows, variables can be declared inside of interface declarations. They are implicitly final and static, meaning they cannot be changed by the implementing class. They must also be initialized. All methods and variables are implicitly public.


## Partial Implementations
If a class includes an interface but does not fully implement the methods required by that interface, then that class must be declared as abstract.

## Nested Interfaces

An interface can be declared a member of a class or another interface. Such an interface is called a member interface or a nested interface. A nested interface can be declared as public, private, or protected. This differs from a top-level interface, which must either be declared as public or use the default access level, as previously described. When a nested interface is used outside of its enclosing scope, it must be qualified by the name of the class or interface of which it is a member. Thus, outside of the class or interface in which a nested interface is declared, its name must be fully qualified


## Interfaces Can Be Extended


One interface can inherit another by use of the keyword extends. The syntax is the same as for inheriting classes. When a class implements an interface that inherits another interface, it must provide implementations for all methods required by the interface inheritance chain.

## Default Interface Methods

A primary motivation for the default method was to provide a means by which interfaces could be expanded without breaking existing code.

Another motivation for the default method was the desire to specify methods in an interface that are, essentially, optional, depending on how the interface is used. For example, an interface might define a group of methods that act on a sequence of elements. One of these methods might be called remove( ), and its purpose is to remove an element from the sequence. However, if the interface is intended to support both modifiable and nonmodifiable sequences, then remove( ) is essentially optional because it won’t be used by nonmodifiable sequences. In the past, a class that implemented a nonmodifiable sequence would have had to define an empty implementation of remove( ), even though it was not needed. Today, a default implementation for remove( ) can be specified in the interface that does nothing (or throws an exception). Providing this default prevents a class used for nonmodifiable sequences from having to define its own, placeholder version of remove( ). Thus, by providing a default, the interface makes the implementation of remove( ) by a class optional.

It is important to point out that the addition of default methods does not change a key aspect of interface: its inability to maintain state information. An interface still cannot have instance variables, for example. Thus, the defining difference between an interface and a class is that a class can maintain state information, but an interface cannot. Furthermore, it is still not possible to create an instance of an interface by itself. It must be implemented by a class. Therefore, even though, beginning with JDK 8, an interface can define default methods, the interface must still be implemented by a class if an instance is to be created.

It is possible to explicitly refer to a default implementation in an inherited interface by using a new form of super. Its general form is shown here:

```
InterfaceName.super.methodName( )
```

## Use static Methods in an Interface


JDK 8 added another new capability to interface: the ability to define one or more static methods. Like static methods in a class, a static method defined by an interface can be called independently of any object. Thus, no implementation of the interface is necessary, and no instance of the interface is required, in order to call a static method. Instead, a static method is called by specifying the interface name, followed by a period, followed by the method name. Here is the general form:

InterfaceName.staticMethodName







