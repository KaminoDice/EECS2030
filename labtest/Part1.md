1, 1, 1, 1, 0.5, 1, 0, 0.75, 0, 2, 0, 2

---

## Multiple-Choice or Similar Questions (9 questions, 1 point each)

---

> Q1.	Assuming the following two (static) functions are correctly implemented elsewhere:
> void swap (List `<T>` list, int pos1, int pos2): swaps positions pos1 and pos2 in list
>
> int findMinPosRecursive(List `<T>` list): returns an int index of the smallest element in list
>
> the following recursive implementation of selection sort (ignore the header part which deals with the generics)

```java

public static <T extends Comparable <? super T>> void selectionSortRecursive(List `<T>` list){
		if(list.size() > 1){
			swap (list, 0, findMinPosRecursive(list));
			selectionSortRecursive(list.subList(0, list.size() - 1));
		}
	}
```

will...

A.	generate a run-time error
B.	not terminate (will enter an infinite loop)
**C.	work incorrectly (the list may not be sorted properly at the end)**
D.	work correctly for any legal Lists - of proper types, as long as the lists are small enough to not cause any overflows
E.	work correctly for any Lists of proper types
F.  not compile; the code contains a syntax error

Q1 Answer (one choice): C

---

> Q2.	True or false: "iterative algorithms typically require more memory space during the execution than the recursive ones"?

Q2 Answer (T/F): F

---

> Q3.	Consider the following class that represents a line segment connecting two points (its start point and its end point):

```java
public final class Line {
		private final Point2 start;
		private final Point2 end;

    public Line(Point2 p1, Point2 p2) {
			this.start = p1;
			this.end = p2;
		}
		// remainder of class not shown
}
```

Which statement best describes the class Line?

A. Line is a composition of two points
B. Line is immutable
C. Line is a superclass of another class
**D. Line is an aggregation of two points**

Q3 Answer (one choice): D

---

> Q4.	When a class has fields that are not of primitive type, we often need to consider using
> composition instead of aggregation. Why is composition often required instead of aggregation?

A.	It's difficult  to use constructor chaining otherwise
B.	It's hard to share data between classes otherwise
C.	It's difficult to make the classes mutable otherwise
D.	To maintain class invariants, or to prevent changes in state from outside of the class

Q4 Answer (one choice): D

---

> Q5.	Assuming a class Vector3 stores x, y, z values in an array private double [] v,
> and the class must be immutable, which implementation of getElements() method returning
> the vector's x, y, z points as an array (of 3 doubles) is the most appropriate?

A.	return Arrays.copyOf(this.v);
B.	for(double element : this.v) {return element;}
C.	return {v[0], v[1], v[3]};
D.	return new double(this.v);
E.	none of the above;

Q5 Answer (one choice): A

---

> Q6.	The easiest way to create a defensive copy of an ArrayList containing Date objects is ...

A. copy list's reference into a new final variable
B. create a new reference to this list
**C. make a deep copy of the list**
D. invoke the list's copy constructor with the original list as a parameter

Q6 Answer (one choice): C

---

> Q7. Consider the following Java statement:

```java
Alpha a = new Beta ();
```

Which of the following could be true?
**A.	Beta is a descendant of Alpha**
B.	Beta is an ancestor of Alpha
C.	Beta is a superclass to Alpha
D.	Such a statement is illegal, regardless of class relationships

Q7 Answer (one choice): C

---

> Q8.	Consider the following inheritance hierarchy:
> A inherits from neither B nor from C
> B inherits from A
> C inherits from B

If class A has a protected field, which classes are allowed to access that field directly by name?

Q8 Answer (list the classes: e.g., "C only"): BC A

---

> Q9.	Consider the following inheritance hierarchy (same as in Q8):
> A inherits from neither B nor from C
> B inherits from A
> C inherits from B

Assuming we have a method

```java
public static void someMethod(B a) { // IMPLEMENTATION NOT SHOWN }
```

which variable types can be used as its argument?

Q9 Answer (list all the types, e.g., "ABC"):  BC

---

## Short-answer Questions (3 questions, 2 points each)

> Q10.	(2 points) In one of the labs, you were expected to implement a recursive sorting
> algorithm. How does the recursive implementation compare with the non-recursive one in terms
> of its advantages and/or disadvantages (one or two sentences)?

Q10 Answer: Advantages of Recurisve: code is more readable and maintainable;
Disadvantages of Recurisve: use more memory and time.

---

> Q11.	(2 points) Consider the following code fragment:

```java
List `<Point2>` list = new LinkedList `<Point2>`();
list.add(new Point2 (1.0, 0.0));
list.add(new Point2 (1.0, 1.0));
list.add(new Point2 (1.0, 2.0));
```

How many (additional) objects will be created if you make a shallow copy of the list object? Explain your answer.

Q11 Answer: 1, if I make a shallow copy, I just copy the reference of these objects in the list without creating new objects.

---

> Q12.	(2 points) Assuming we have the following Java classes and interfaces:

```java
public class Animal
public class Bird
public class Pigeon

public interface Flying
public interface Singing

Is the following definition of class Creature valid (from the Java perspective only)? Explain your answer.

public class Creature extends Flying implements Bird, Animal{
   //implementation omitted
}
```


Q12 Answer: Is not valid, because cannot extends an interface and implement from a class.
