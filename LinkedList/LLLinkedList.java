public class LLLinkedlist<A>{
	public Node <A> head;

	//inner class for the node in linkedlist
	//the node inner class should be declared as private and static
	//and has its own constructor

	//here we cannot declare this as private
	//because we need to similarly declare Node<A> cursor in the RemoveDup class
	public static class Node<A>{
		private A data;
		private Node<A> next;

		public Node<A> (A data, Node<A> next) {
			this.data = data;
			this.next = next;
		}
	}
		/*
		public class Node<E> {
    		 E val;
    		 Node<E> prev;
    		 Node<E> next;
     	
   	    public Node(E val, Node<E> prev, Node<E> next){
    		 this.val = val;
    		 this.prev = prev;
    		 this.next = next;
     		}
     	*/

	//constructor for the outer class, i.e. LLLinkedlist
     		//constructor does not need return type, even if it is void
     		public LLLinkedlist(A[] arr){
     			if(arr == null || arr.length <= 0){
     				return;
     			}
     			//using the inner node class stated above
     			this.head = new Node<A>(arr[0], null);

     			Node<A> cursor = this.head;
     			for(int i=1; i<arr.length; i++){
     				//avoid moving the head of current linkedlist
     				//we use a cursor instead to add nodes after head

     				cursor.next = new Node<A>(arr[i], null);
     				//update the cursor to the last node in the linkedlist
     				cursor = cursor.next;
     			}

     			//constructor does not need any return statements
     		}
     		//overload the constructor with none parameters
     		public LLLinkedList()
  			{	
    		  head = null;
  			}

  			public LLLinkedList(A data){
  				//pass the data and the next node to the inner private static node class constructor
  				this.head = new Node<A>(data, null);
  			}	

  			//without using API which could directly print the name of the linkedlist.java
  			//we need to establish our own print method here
  			public void print(){
  				//initialize a new node as the cursor here
    			 Node<A> cur = this.head;

    	 		 while (cur != null) {
    					System.out.print(cur.val);

    				if (cur.next != null) {
    					System.out.print(" -> ");
    				}

    				cur = cur.next;
         		}

         		System.out.println();
    	    
     		}

  			public static void main(String[] args){
  				//MyList<Integer> l1 = new MyList<Integer>(new Integer[]{2,7,5,4,2,2,4,6,6});
  				//using the 
  				LLLinkedlist<Integer> l = new LLLinkedlist<Integer> ( new Integer[] { 1,2,3,4,4,5,2} );
  			}
}


class RemoveDup{
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
}
}