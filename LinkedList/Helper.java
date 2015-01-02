import java.util.*;
class Startup <E> {
     Node<E> head;
     
     //inner class for the node in Startup-type linkedlist
     public class Node<E> {
        E val;
        Node<E> prev;
        Node<E> next;
        //here this is implemented as a doublylinkedlist
        public Node(E val, Node<E> prev, Node<E> next){
          this.val = val;
          this.prev = prev;
          this.next = next;
      }
    }


     public Startup(Node<E> h){
    	 this.head = h;
     }
     
     public Startup(E[] arr){
    	 if(arr == null || arr.length <= 0){
    		 return;
    	 }
    	 this.head = new Node<E>(arr[0], null, null);
    	 Node<E> curr = this.head;
    	 for(int i=1; i<arr.length; i++){
    		 curr.next = new Node<E>(arr[i], curr, null);
    		 curr = curr.next;
    	 }
     }
     
     public void print(){
    	 Node<E> cur = this.head;
    	 while (cur != null) {
    		System.out.print(cur.val);
    		if (cur.next != null) {
    			System.out.print(" -> ");
    		}
    		cur = cur.next;
         }
         System.out.println();    
     }

     
}


/*
Helper.java:64: error: cannot find symbol
    public static void removeDup(Node<Integer> head){
      */

//could only use the different files and declare both classes as public !!!Li
public class Helper{
    
   public static void main(String[] args) {
        Startup<Integer> l1 = new Startup<Integer>(new Integer[]{2,7,5,4,2,2,4,6,6});
        Startup<Integer> l2 = new Startup<Integer>(new Integer[]{2,7,5,4,2,2,4,6,6});
        
        System.out.println("Using hashset to remove duplicate...");
        l1.print();

        removeDup(l1.head);

        l1.print();
    }

    public static void removeDup(Node<Integer> head){
        //check simple case
        if(head == null || head.next == null){
            return;
        }
        
        Set<Integer> contents = new HashSet<Integer>();
        
        Node<Integer> p = head;
        
        //traverse the list
        while(p != null){
            //if duplicate exists, remove the node
            if(contents.contains(p.val)){
                p.prev.next = p.next;
                if(p.next != null){
                    p.next.prev = p.prev;
                }
            }else{
                contents.add(p.val);
            }
            p = p.next;
        }
    }
    
}
