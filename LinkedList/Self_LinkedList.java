/*

doublylinkedlist

public class Node<E> {
     E val;
     Node<E> prev;
     Node<E> next;
     
     public Node(E val, Node<E> prev, Node<E> next){
    	 this.val = val;
    	 this.prev = prev;
    	 this.next = next;
     }
}

*/

/*

//this is a template defined in java
//just as template<typename T> in c++
public class MyList<E> {

     Node<E> head;
     private static class Node<AnyType>
   		{
     		 private AnyType data;
     		 private Node<AnyType> next;

     		 public Node(AnyType data, Node<AnyType> next)
     		 {
        		 this.data = data;
        		 this.next = next;
     		 }
   		}

   		 
     public MyList(Node<E> h){
    	 this.head = h;
     }
     
     public MyList(E[] arr){
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

*/

public class RemoveDuplicate {

	public static void main(String[] args) {
		MyList<Integer> l1 = new MyList<Integer>(new Integer[]{2,7,5,4,2,2,4,6,6});
		MyList<Integer> l2 = new MyList<Integer>(new Integer[]{2,7,5,4,2,2,4,6,6});
		
		System.out.println("Using hashset to remove duplicate...");
		l1.print();
		removeDupTwo(l1.head);
		l1.print();
		
		System.out.println("No memory buffer used to remove duplicate...");
		l2.print();
		removeDupTwo(l2.head);
		l2.print();

	}
	
	
	public static void removeDupOne(Node<Integer> head){
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
	
	
	public static void removeDupTwo(Node<Integer> head){
		//check simple case
		if(head == null || head.next == null){
			return;
		}
		
		//two points
		Node<Integer> p1 = head;
		Node<Integer> p2 = head;
		
		//one pointer to traverse every element and another to 
		//traverse the rest of list every time to check duplicate
		while(p1 != null){
			p2 = p1.next;
			while(p2 != null){
				if(p1.val == p2.val){
					p2.prev.next = p2.next;
					if(p2.next != null){
						p2.next.prev = p2.prev;
					}
				}
				p2 = p2.next;
			}
			p1 = p1.next;
		}
	}
	
	

}