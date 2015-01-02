//check if there is a duplicate : do not try to use arrays or several flags/cursors
//using a hashset could easily resolve this
import java.util.*;
public class RemoveDup{
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

//this will not work because the default API does not have any node implementation

void deleteDups(LinkedList n){
	HashSet<Integer> set = new HashSet<Integer> ();
	LinkedListNode previous = null;
	while(n!=null){
		if(set.contains(n.data)){
			previous.next = n.next;
		}else{
			set.add(n.data);
			//move forward the cursor privious
			previous = n;
		}

		n = n.next;
		//previous is just used as deleting 
		//n is used to scan the whole linkedlist
	}
}

public static void main(String[] args){
	LinkedList l =new LinkedList();
	l.add(1);
	l.add(2);
	l.addFirst(3);
	l.add(4);
	l.add(3);
	l.add(2);
	l.add(999);
	System.out.println(l);

}

}
