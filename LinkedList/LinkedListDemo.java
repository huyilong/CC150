import java.util.*;
/*
void addFirst(Object o)
Inserts the given element at the beginning of this list.

void add(int index, Object element)
Inserts the specified element at the specified position index in this list. 
Throws IndexOutOfBoundsException if the specified index is is out of range (index < 0 || index > size()).

boolean add(Object o) 
Appends the specified element to the end of this list.

boolean contains(Object o) 
Returns true if this list contains the specified element. More formally, 
returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.equals(e)).

Object get(int index)   // getFirst() // getLast()
Returns the element at the specified position in this list. Throws IndexOutOfBoundsException 
if the specified index is is out of range (index < 0 || index >= size()).

Object remove(int index)  // removeFirst() // removeLast()
Removes the element at the specified position in this list. Throws NoSuchElementException if this list is empty

*/

/*
extramely important two methods

Object set(int index, Object element) 
Replaces the element at the specified position in this list with the specified element. 
Throws IndexOutOfBoundsException if the specified index is is out of range (index < 0 || index >= size()).

Object[] toArray() 
Returns an array containing all of the elements in this list in the correct order. 
Throws NullPointerException if the specified array is null.
*/
public class LinkedListDemo {

   public static void main(String args[]) {
      // create a linked list
      LinkedList ll = new LinkedList();
      // add elements to the linked list
      ll.add("F");
      ll.add("B");
      ll.add("D");
      ll.add("E");
      ll.add("C");
      ll.addLast("Z");
      ll.addFirst("A");
      ll.add(1, "A2");
      System.out.println("Original contents of ll: " + ll);

      // remove elements from the linked list
      ll.remove("F");
      ll.remove(2);
      System.out.println("Contents of ll after deletion: "
       + ll);
      
      // remove first and last elements
      ll.removeFirst();
      ll.removeLast();
      System.out.println("ll after deleting first and last: "
       + ll);

      // get and set a value
      Object val = ll.get(2);

      ll.set(2, (String) val + " Changed");
      
      System.out.println("ll after change: " + ll);
   }
}