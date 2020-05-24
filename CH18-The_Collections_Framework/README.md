# The Collections Framework


## Collections Overview

* The Java Collections Framework standardizes the way in which groups of objects are handled by your programs
* The Collections Framework was designed to meet several goals. First, the framework had to be high-performance.
* Algorithms are another important part of the collection mechanism. Algorithms operate on collections and are defined as static methods within the Collections class.
* Each collection class need not implement its own versions. The algorithms provide a standard means of manipulating collection


## The Collection Interfaces


* Collection --> Enables you to work with groups of objects; it is at the top of the collections hierarchy.
* Deque -->  Extends Queue to handle a double-ended queue.
* List -->   Extends Collection to handle sequences (lists of objects).
* NavigableSet -->  Extends SortedSet to handle retrieval of elements based on closest-match searches.
* Queue -->  Extends Collection to handle special types of lists in which elements are removed only from the head.
* Set --> Extends Collection to handle sets, which must contain unique elements.
* SortedSet -->  Extends Set to handle sorted sets.


In addition to the collection interfaces, collections also use:
* Comparator --> defines how two objects are compared; 
* Iterator, ListIterator, and Spliterator --> enumerate the objects within a collection. 
* RandomAccess --> a list indicates that it supports efficient, random access to its elements.

## The Collection Interface

The Collection interface is the foundation upon which the Collections Framework is built because it must be implemented by any class that defines a collection. Collection is a generic interface that has this declaration:

interface Collection<E>

Collection extends the Iterable interface. This means that all collections can be cycled through by use of the for-each style for loop. (Recall that only classes that implement Iterable can be cycled through by the for.)

Exceptions:
* UnsupportedOperationException --> occurs if a collection cannot be modified.
* ClassCastException --> one object is incompatible with another
* NullPointerException --> attempt is made to store a null object and null elements are not allowed in the collection.
* IllegalArgumentException --> invalid argument is used.
* IllegalStateException -->  is thrown if an attempt is made to add an element to a fixed-length collection that is full.

![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab18-1.jpg)
![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab18-1a.jpg)


## The List Interface

* The List interface extends Collection and declares the behavior of a collection that stores a sequence of elements. Elements can be inserted or accessed by their position in the list, using a zero-based index. A list may contain duplicate elements. List is a generic interface that has this declaration:

```
interface List<E>
```

Exceptions:
* IndexOutOfBoundsException --> if an invalid index is used.

![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab18-2.jpg)

## The Set Interface

* The Set interface defines a set. It extends Collection and specifies the behavior of a collection that does not allow duplicate elements. Therefore, the add( ) method returns false if an attempt is made to add duplicate elements to a set. It does not specify any additional methods of its own.
interface Set<E>

## The SortedSet Interface

* The SortedSet interface extends Set and declares the behavior of a set sorted in ascending order.

```
interface SortedSet<E>
```

* SortedSet defines several methods that make set processing more convenient. To obtain the first object in the set, call first( ). To get the last element, use last( ). You can obtain a subset of a sorted set by calling subSet( ), specifying the first and last object in the set. If you need the subset that starts with the first element in the set, use headSet( ). If you want the subset that ends the set, use tailSet( ).

![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab18-3.jpg)

## The NavigableSet Interface

* The NavigableSet interface extends SortedSet and declares the behavior of a collection that supports the retrieval of elements based on the closest match to a given value or values. NavigableSet is a generic interface that has this declaration:

```
interface NavigableSet<E>
```

![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab18-4.jpg)

Questions.
What exactly ceiling and floor methods are used for ( use cases )

## The Queue Interface

The Queue interface extends Collection and declares the behavior of a queue, which is often a first-in, first-out list. However, there are types of queues in which the ordering is based upon other criteria. Queue is a generic interface that has this declaration:

interface Queue<E>

* Despite its simplicity, Queue offers several points of interest. First, elements can only be removed from the head of the queue. Second, there are two methods that obtain and remove elements: poll( ) and remove( ). The difference between them is that poll( ) returns null if the queue is empty, but remove( ) throws an exception. Third, there are two methods, element( ) and peek( ), that obtain but don’t remove the element at the head of the queue. They differ only in that element( ) throws an exception if the queue is empty, but peek( ) returns null. Finally, notice that offer( ) only attempts to add an element to a queue. Because some queues have a fixed length and might be full, offer( ) can fail.

![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab18-5.jpg)

## The Deque Interface

The Deque interface extends Queue and declares the behavior of a double-ended queue. Double-ended queues can function as standard, first-in, first-out queues or as last-in, first-out stacks. Deque is a generic interface that has this declaration:

interface Deque<E>

![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab18-6.jpg)
![tab](https://github.com/SumitAgrawal03071989/JavaTheCompleteReference-9/blob/master/Resources/tab18-6a.jpg)

## The Collection Classes

Now that you are familiar with the collection interfaces, you are ready to examine the standard classes that implement them. Some of the classes provide full implementations that can be used as-is. Others are abstract, providing skeletal implementations that are used as starting points for creating concrete collections. As a general rule, the collection classes are not synchronized, but as you will see later in this chapter, it is possible to obtain synchronized versions.


AbstractCollection --> Implements most of the Collection interface.
AbstractList --> Extends AbstractCollection and implements most of the List interface.
AbstractQueue --> Extends AbstractCollection and implements parts of the Queue interface.
AbstractSequentialList --> Extends AbstractList for use by a collection that uses sequential rather than random access of its elements.
LinkedList --> Implements a linked list by extending AbstractSequentialList.
ArrayList --> Implements a dynamic array by extending AbstractList.
AbstractSet --> Extends AbstractCollection and implements most of the Set interface.
EnumSet --> Extends AbstractSet for use with enum elements.
HashSet --> Extends AbstractSet for use with a hash table.
LinkedHashSet --> Extends HashSet to allow insertion-order iterations.
PriorityQueue --> Extends AbstractQueue to support a priority-based queue.
ArrayDeque --> Implements a dynamic double-ended queue by extending AbstractCollection and implementing the Deque interface.
TreeSet --> Implements a set stored in a tree. Extends AbstractSet.



interface Collection
    interface List
    interface Set
        interface SortedSet
        interface NavigableSet
    interface Queue 
        interface Dequeue

    Class AbstractCollection implements Collection
        Class AbstractList extends ... implements List
            Class AbstractSequentialList extends ...
                Class LinkedList extends ... implements List, Dequeue, Queue
            Class ArrayList extends ... implements List 
        Class AbstractQueue extends ... implements Queue
            Class PriorityQueue extends ... implements Queue
        Class ArrayDeque extends ... implements Deque
        Class AbstractSet extends ... implements Set
            Class EnumSet extends ... implements Set
            Class HashSet extends ... implements Set
                Class LinkedHashSet extends ... 
            Class TreeSet extends ... implements NavigableSet


## Accessing a Collection via an Iterator

## MAP

* A map is an object that stores associations between keys and values, or key/value pairs. Given a key, you can find its value. Both keys and values are objects. The keys must be unique, but the values may be duplicated. Some maps can accept a null key and null values, others cannot.
* There is one key point about maps that is important to mention at the outset: they don’t implement the Iterable interface. This means that you cannot cycle through a map using a for-each style for loop. Furthermore, you can’t obtain an iterator to a map. However, as you will soon see, you can obtain a collection-view of a map, which does allow the use of either the for loop or an iterator.

## The Map Interfaces

Map --> Maps unique keys to values.
Map.Entry --> Describes an element (a key/value pair) in a map. This is an inner class of Map.
NavigableMap --> Extends SortedMap to handle the retrieval of entries based on closest-match searches.
SortedMap --> Extends Map so that the keys are maintained in ascending order.


## The Map Classes

interface Map
interface Map.Entry
    interface SortedMap
        interface NavigableMap


    Class AbstractMap implements Map
        Class EnumMap extends ... implements Map
        Class HashMap extends ... 
            Class LinkedHashMap extends ...
        Class TreeMap extends ...
        Class WeakHashMap extends ...
        Class IdentityHashMap extends ...














































