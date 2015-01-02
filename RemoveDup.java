//import java.util.HashSet;
//import java.util.LinkedList;
import java.util.*;
import java.util.HashSet;
import java.io.*;

public class RemoveDup{

	public static void deleteDups(LinkedListNode n)
	{
		HashSet<Integer> set = new HashSet<Integer> ();
		LinkedListNode previous = null;
		while(n!=null)
		{
			if(set.contains(n.data)){
				previous.next = n.next; //this value is already stored in the hashset 
				//thus now the previous is pointing to the duplicate in the linkedlist
			}else{
				//Integer intObj = new Integer(i);
				int foo = Integer.parseInt(n.data);
				Integer obj = new Integer(foo);
				set.add(obj);//the data is new and thus stored in the hashset
				previous = n; //update the previous ptr to the current place
			}


			n = n.next;
		}
	}

	public static void main(String[] args)
	{
		//int million = Integer.parseInt("1,000,000".replace(",",""));

		//without using RemoveDup test = new RemoveDup() which will call the default constructor 
		//we could directly use the static method within the same class
		LinkedList test = new LinkedList();
		test.add(1);
		/*
		test.add(1);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(2);
		test.add(4);
		test.add(4);
		*/
		System.out.println("Original contents of the list are " + test);
	}
}