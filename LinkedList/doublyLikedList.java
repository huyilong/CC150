/* 
 simple single linked list implementation
*/

public class DoubleList {
	Node head;
    
    //build the list only use the head
	public DoubleList(Node head){
		this.head = head;
	}
    
    //build the list given an array of elements
	public DoubleList(int[] arr){
		if(arr == null || arr.length<=0){
			return;
		}
        //make a head
		this.head = new Node(arr[0],null,null);
		//fill in elements
		Node curr = this.head;
		for(int i=1; i<arr.length; i++){
			curr.next = new Node(arr[i], curr, null);
			curr = curr.next;
		}
	}
    
    //insert a new node with val
    public Node insert(int val){
       Node tail = new Node(val,null,null);
       Node curr = this.head;
       while(curr.next != null){
            curr = curr.next;
        }
        curr.next = tail;
        tail.prev = curr.next;
        return this.head;
    }

    //delete head of the list
    //return current head
    public Node deleteHead(){
        if(this.head == null){
        	return null;
        }
        this.head = this.head.next;
        if(this.head != null){
            this.head.prev = null;
        }
        return this.head;
    }


    //delete the last element in the list
    //return current head
    public Node deleteTail(){
    	//special case
    	if(this.head == null || this.head.next == null){
    		return null;
    	}
    	//two pointers
        Node fast = this.head.next;
        Node target = this.head;
        //pointer fast is always one step ahead of target
        while(fast.next != null){
            fast = fast.next;
            target = target.next;
        }
        //pointer target is not at second last element
        //delete the tail
        target.next = null;
        return this.head;
    }
    
    //delete node with val
    public Node delete(int val){
        Node curr = this.head;
        if((curr.val) == val){
            return this.deleteHead();
        }

        while(curr.next != null){
            if((curr.next.val) == val){
                curr.next = curr.next.next;
                if(curr.next.next != null){
                    curr.next.next.prev = curr;
                }
                return this.head;
            }
            curr = curr.next;
        }

        if((curr.val) == val){
            return this.deleteTail();
        }
        return this.head;
    }
	

	//check if list contains node with val
	public boolean contains(int val){
		Node curr = this.head;
		while(curr.next != null){
			if(curr.val == val){
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
    


   //print the list
    public void printList(){
         if(this.head == null){
            System.out.println();
            return;
         }
         Node curr = this.head;
         while(curr.next != null){
            System.out.print(curr.val);
            System.out.print("->");
            curr = curr.next;
         }
         System.out.print(curr.val);
         System.out.println();
     }

}