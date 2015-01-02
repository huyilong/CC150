
/*

abstract function === pure virtual methods
if a class has a pure virtual methods then it becomes an abstract class in java
i.e. it must be override to be instantiated

Instead, virtual just offers a choice for polymorphism, the subclass could use the parent
version and could also choose not to do so. i.e. virtual functions do not make the class
an abstract class, it could still be directly instantiated.

pure virtual methods == abstract function will prevent the class from being instantiated.
*/

//we could use linkedlist to simulate the queue or stack, which would be faster
//"first in, first out" :: 1. oldest in all animal (the collection of 2.)  2. oldest cat or dog

public abstract class Animal{
	//no one else could alter the order via the program directly without mutator
	//using accessor and mutator to get reach to the private elements
	private int order;
	//therefore the protected could be seen in the subclasses
	protected String name;
	//constructor
	public Animal(String n)
	{
		name = n;
	}

	//mutator
	public void setOrder(int ord)
	{
		order = ord;
	}

	//accessor
	public int getOrder()
	{
		return order;
	}

	public boolean isOlderThan(Animal a)
	{
		return this.order < a.getOrder();
	}

}

public class Dog extends Animal{
	//using the constructor in base class
	public Dog(String n)
	{
		super(n);
	}
}

public class Cat extends Animal{
	public Cat(String n)
	{
		super(n);
	}
}

//in java and c++  for templates we must point out explicitly the type of elements stored in the container
public class AnimalQueue{
	LinkedList<Dog> dogs = new LinkedList<Dog> ();
	LinkedList<Cat> cats = new LinkedList<Cat> ();
	private int order = 0; // timestamp
	//polymorphism with Animal 
	public void enqueue(Animal a)
	{
		a.setOrder(order);
		order++;

		if(a instance)
	}
}