# Collections

1. Re-implement the [Bitwise Microlab](https://github.com/Zipcoder/Java-Fundamentals-Bitwise) using BitSet instead of integers.

2. Write a function that takes a BitSet and returns the number of steps needed to shift all `1` bits to the left (maintaining the same `length()` of the BitSet).

3. Write a function that takes a BitSet and returns the number of steps needed to shift all `1` bits to the right.

## Stack Microlab

A stack is a data structure that stores a list of elements. Each element is added with the `push(element)` method and the most recent element can be retreived with the `pop()` method. The `peek()` method returns the top element on the stack without removing it from the stack. The **last** element put **in** the stack is the **first** one to come **out** -- this is why it's called a **Last In First Out** (LIFO) data structure.

Create your own Stack for Strings called `StringStack` and implement these three methods.

**Part 2**: 

Generalize your StringStack to a generic Stack implementation. It should include appropriate type parameters and allow storage of any object type.

*hint*: There may be another existing collection that is useful for implementing a stack.

## Listbuilder

Create a ListBuilder interface with one method: `buildList(Array a):List`

Implement the interface and its method with the following classes:

- `ArrayListBuilder` -- Creates an ArrayList from the given array
- `LinkedListBuilder` -- Creates a LinkedList from the given array

Part 2: Override `buildList` with `buildList(Collection c):List` to take any collection type and produce the corresponding List type to the implementing class (just like part one). You may want to look at the `Collection.toArray()` method for this.


## Iterator

Create an `Iterator` that produces the Fibonacci series; call it `FibonacciIterator`. The `hasNext()` method should always return true because the Fibonacci series is an infinite set.

