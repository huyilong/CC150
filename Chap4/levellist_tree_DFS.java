//DFS or BFS both will work in adding all the nodes in the same level into the list
//standard:: 
//using one basic beginning method to get the input, call the recursive and return the final result
//using another void return type of the same name as the overloading and recursive down to the road 

//basic interface with final return type
//Note: in the basic interface we only need one parameter, i.e. the root 
ArrayList< LinkedList< Node > > levellist(Node root)
{
	//results contain all the linkedlists containing all the nodes on each level of the tree
	ArrayList< LinkedList< Node > > results = new ArrayList< LinkedList< Node > > ();
	//basic condition for the following built-in calling of recursive
	levellist(root, results, 0);
	//because results is used as a parameter in the recursive and then we all need to return the output
	return results;
}


//following interface with void type
//in this overloaded function we need three parameters passed from the basic GUI interface
void levelList(Node root, ArrayList< LinkedList< Node > > results, int level)
{
	if(root == null) return; // base case: the outlet of the recursive

	LinkedList<Node> list = null; // initialize list with null, i.e. we did not create it yet

	//because we use the DFS therefore we must pass the level as one of the parameter
	//to pinpoint the level for the current position
	if(results.size() == level)
		//now we are visiting a new level we did not visit before
	{
		list = new LinkedList<Node>();//now we create a new element which will be stored in results later
		results.add(list);
	}else{
		//else we have already visited this level and all we need to do is get out of the level 
		//to add the new node into it
		list = results.get(level);
	}

	//ok. now is the kernel operation, i.e. after we locate the level we will add the node anyway
	list.add(root);

	//now we can go to the next recursive condition
	//do not forget to increase the level as the new parameter for the next round
	levellist(root.left, results, level+1);
	levellist(root.right, results, level+1);
}