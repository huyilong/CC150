/* 
 Remove duplicates from an unsorted linked list.
 What if a temporary buffer is not allowed?
 Need to know: 
 1. single or double list, but single list makes problem more interesting here
 Approach:
 1. use hashtable 
 2. two pointers, one traversing each node and another traversing remaining nodes
*/
 
 import java.util.*;
 public class AnotherRemoveDup {
 	public static void main(String[] args){
        SingleList l1 = new SingleList(new int[] {1,2,3,4});
        l1.printList();
        removeDup2(l1);
        l1.printList();

        SingleList l2 = new SingleList(new int[] {1,2,1,3});
        l2.printList();
        removeDup2(l2);
        l2.printList();

        SingleList l3 = new SingleList(new int[] {2,1,1,2,1});
        l3.printList();
        removeDup2(l3);
        l3.printList();

 	}
    
    //use hashtable
    //time O(n), space O(n)
 	public static void removeDup(SingleList list){
 		//immediate result
 		if(list.head==null || list.head.next==null){
 			return;
 		}
 		//hashmap to store (value, index) pairs
 		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
 		map.put(list.head.val, 1);
        //two pointers for current and previous node
 		Node prev = list.head;
 		Node curr = list.head.next;
 		int pos = 2;
 		while(curr.next != null){
            //continue if not duplicate
            if(!map.containsKey(curr.val)){
            	map.put(curr.val, pos);
                prev = prev.next;
                pos ++;
            //remove duplicate
            }else{
                prev.next = curr.next;
            }
            curr = curr.next;
 		}
        //check tail
 		if(map.containsKey(curr.val)){
 			prev.next = null;
 		}

 	}
    
    //two pointers
    //time O(n^2), space O(1)
    public static void removeDup2(SingleList list){
        //immediate result
        if(list.head==null || list.head.next==null){
            return;
        }
        Node n = list.head;
        Node explore = n;
        //keep exploring if n is not the last node
        while(n != null){
            int val = n.val;
            explore = n;
            //pointer explore keep going until the end
            while(explore.next != null){
                //find duplicate and remove it
                //be careful to case when duplicates occur continuously
                if(explore.next.val == val){
                    explore.next = explore.next.next;
                }else{
                   explore = explore.next;
                }
            }
            n = n.next;
        }
    }


 }