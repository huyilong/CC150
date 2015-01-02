//if we do not know the length of the linkedlist
//we could use the fast runner & slow runner technique to locate the middle of the linkedlist
//similarly, if we want to find the kth element to the end 
//we could let the fast runner firstly move step by step for k steps
//and then let slow runner and fast runner simultaneously move step by step until the 
//fast runner hits the end of the linkedlist, here the slow runner will stop by (length-k)th element

boolean isPalindrome(Node<Integer> head){
	Node<Integer> fast_runner = head;
	Node<Integer> slow_runner = head;

	Stack<Integer> half_of_list = new Stack<Integer>();

	while(fast_runner != null&& fast_runner.next != null){

		half_of_list.push(slow_runner.data);

		slow_runner = slow_runner.next;
		fast_runner = fast_runner.next;
	}

	if(fast_runner != null)//has odd number of elements
	//then skip the middle element!!!
	{
		slow_runner = slow_runner.next;
		//slow_runner then will be used as a scanner to compare
		//so here we need to skip over the middle element if there are odd number of elements
	}

	while(slow_runner!=null){
		int reverse_seq = half_of_list.pop().intValue();

		if(reverse_seq != slow_runner.data){
			return false;
		}

		slow_runner = slow_runner.next;
	}

	//after all the checking and seiving 
	return true;
}