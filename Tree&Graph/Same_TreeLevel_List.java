//instead of using a DFS like the pre-order traversal, etc, which need to pass "level"
//to the next round of recursion
//we use the BFS -> which is designed for going to next level only if visited all the nodes
//on the current level

ArrayList<LinkedList< Node<Integer> > >  createLevelLinkedList(Node<Integer> root){
	ArrayList< LinkedList<Node<Integer> > >  result =new ArrayList< LinkedList<Node<Integer> > >();

	LinkedList<Node<Integer>> current_level = new LinkedList<Node<Integer>>();
	if(root!= null){
		current_level.add(root);
	}

	while(current_level.size() > 0){
		//the following statement is actually storing the previous level
		result.add(current_level);
		LinkedList<Node<Integer>> parents_level = current_level;
		//preparing for going to the next level
		current_level = new LinkedList<Node<Integer>>();
		//simulating the popping queue and visited all the popped node to add their children
		for(Node<Integer> parent_node : parents_level){
			//try to be as semantic as possible
			if(parent_node.left!=null){
				current_level.add(parent_node.left);
			}
			//attention!!!!!!!!!
			//whenever it comes to write if and else
			//must think carefully whether to use else
			//because if and else once could only be visited once in two
			//here we should both check the left child and the right child and thus we should not use else
			if(parent_node.right !- null){
				current_level.add(parent_node.right)
			}
		}
	}
}