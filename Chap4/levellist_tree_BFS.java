//different from the DFS
//when using BFS/level traversal of the binary tree we only need a queue to implement it
//because we only move to the next level when we finish the traversal of current level

//not like the recursive need a GUI interface and a void running interface
//here we only need a running interface with the final result return type
ArrayList< LinkedList<Node> > levellist(Node root)
//all that user needs to do is type in a root of a given binary tree
{
	ArrayList< LinkedList<Node> > result = new ArrayList< LinkedList<Node> > ();

	//the first level of the result needs to be initialized before going into the iteration
	//working as a basic condition
	LinkedList<Node> current = new LinkedList<Node> ();
	if(root!=null)//judge whether the user typed in a valid input root
	{
		current.add(root);
		//the first level of the linkedlist is thus finished because it must only contain the root
	}

	//simulate the operation of queue using the linkedlist
	while(current.size()>0)
	{
		//adding 1d list into 2d matrix
		//this is the very first thing whenever going into the next round of the iteration
		result.add(current);
		//before going to the next level, we initialize the current to be the parents of the next level
		LinkedList<Node> parents = current;

		for(Node parent : parents)//after : must be the name of the container
		{
			//visit the children of the old current, i.e. the parent, level node
			if(parent.left != null)
			{
				current.add(parent.left);
			}
			//be very careful!!! do not use else if!! because we must check the both sides of the parent!
			if(parent.right != null)
			{
				current.add(parent.right);
			}
		}
	}

	//when it goes out of the iteration above, the BFS has done and we only need to return the result
	return results;
}