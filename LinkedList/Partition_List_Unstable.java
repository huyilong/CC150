//actually we do not need to create two seperate linkedlist and merge them at the end
//we could just use one linkedlist and then 
//insert the node from the head if it is smaller than the pivot
//insert the node from the tail if it is larger or equal to the pivot

Node<Integer> partition_untable(Node<Integer> node, int pivot){
	Node<Integer> head = node;
	Node<Integer> tail = node;

	while(node!=null){
		Node<Integer> next = node.next;
		//do not need to break up the node anymore

		//insert from the head
		if(node.data < pivot){
			//insert the node at the head
			node.next = head;
			head = node;
		}else{
			//insert the node at the tail
			tail.next = node;
			tail = node;
		}

		node = next;
	}

	//as for the insertion at the tail 
	//never forget to set the last tail.next = null;
	tail.next = null;

	return head;
}