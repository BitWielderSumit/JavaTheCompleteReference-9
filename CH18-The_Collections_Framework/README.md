# The Collections Framework


## Collections Overview

* The Java Collections Framework standardizes the way in which groups of objects are handled by your programs
* The Collections Framework was designed to meet several goals. First, the framework had to be high-performance.
* Algorithms are another important part of the collection mechanism. Algorithms operate on collections and are defined as static methods within the Collections class.
* Each collection class need not implement its own versions. The algorithms provide a standard means of manipulating collection


## The Collection Interfaces


Collection --> Enables you to work with groups of objects; it is at the top of the collections hierarchy.
Deque -->  Extends Queue to handle a double-ended queue.
List -->   Extends Collection to handle sequences (lists of objects).
NavigableSet -->  Extends SortedSet to handle retrieval of elements based on closest-match searches.
Queue -->  Extends Collection to handle special types of lists in which elements are removed only from the head.
Set --> Extends Collection to handle sets, which must contain unique elements.
SortedSet -->  Extends Set to handle sorted sets.


In addition to the collection interfaces, collections also use:
Comparator --> defines how two objects are compared; 
Iterator, ListIterator, and Spliterator --> enumerate the objects within a collection. 
RandomAccess --> a list indicates that it supports efficient, random access to its elements.

## The Collection Interface

The Collection interface is the foundation upon which the Collections Framework is built because it must be implemented by any class that defines a collection. Collection is a generic interface that has this declaration:

interface Collection<E>

Collection extends the Iterable interface. This means that all collections can be cycled through by use of the for-each style for loop. (Recall that only classes that implement Iterable can be cycled through by the for.)

Exceptions:
UnsupportedOperationException --> occurs if a collection cannot be modified.
ClassCastException --> one object is incompatible with another
NullPointerException --> attempt is made to store a null object and null elements are not allowed in the collection.
IllegalArgumentException --> invalid argument is used.
IllegalStateException -->  is thrown if an attempt is made to add an element to a fixed-length collection that is full.





