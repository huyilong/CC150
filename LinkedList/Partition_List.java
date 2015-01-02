//it is important to make sure if we must keep the list stable
//because it is linked list rather than the array, we could actually create two different linked lists
//rather than shift and swap the elements in array

public Node<Integer> partition(Node<Integer> node, int pivot)
{
	Node<Integer> before_head = null;
	Node<Integer> before_tail = null;
	Node<Integer> after_head =null;
	Node<Integer> after_tail = null;

	while(node! = null){
		Node<Integer> scanner = node.next;
		node.next = null;
		//break the node in the original linkedlist by make it individual .next = null

		//we are focusing on creating two new substrings
		//and thus we could alter the original linkedlist at will
		if(node.data< pivot){
			//if this is the first node of the linkedlist
			//the operation should be slightly different, i.e. the head and tail should point to the 
			//same node at this time rather than different places	
			if(before_head == null){
				before_head = node;
				before_tail = before_head;
			}else{
				//it is not the only node of the linkedlist and thus should be just 
				//move and update the tail
				before_tail.next = node;
				before_tail = node;
			}
		}else{
			//if the (node.data > = pivot)
			if(after_head == null){
				//similarly if the head at this time is null
				//the node inserted is the first node and the head and tail should both point to it
				after_head =node;
				after_tail = after_head;
			}else{
				after_tail.next = node;
				//make sure that the tail is always pointing to the end of the linkedlist
				after_tail = node;
			}
		}
		//every time for the next iteration we should move the node by scanner
		node = scanner;
	}

	//be careful! it is possible that the first part is totally null
	if(before_head == null){
		return after_head;
		//must be semantic the variables' name
	}

	//merge to linked list by using the tail and the head
	before_tail.next = after_head;
	
	return before_head;
}