//if want to determine a binary 
//at least need to know the in-order traversal and one of the pre-order/post-order
//or we could use the level-traversl and in-order traversal to recover the tree

boolean containsTree(TreeNode tree, TreeNode subtree)
{
	if(subtree == null){
		//the empty tree is the subtree of any tree
		return true;
	}

	return subTree(tree, subtree);
}

boolean subTree(TreeNode tree, TreeNode subtree){
	if(tree == null){
		return false;
	}
	//for every eligible possible "root node" in tree
	//we need to call the recursion call to see if they are really identical trees
	if(tree.data == subtree.data){
		if( matchTree(tree, subtree) )
			return true;
	}

	//it does not matter whether the identical tree is found in the left or right
	return subTree(tree.left, subtree) || subTree(tree.right, subtree); 
}

boolean matchTree(TreeNode tree, TreeNode subtree){
	if(tree == null && subtree ==null)//touchdown and we concurrently get to the leaf node
	{
		return true;
	}

	//if they do not touchdown simultaneously
	//this if is placed under the if above 
	//will rule out the possiblility that both are null!!!   logic!!!!
	if(tree == null || subtree == null)
	{
		return false;
	}

	if(tree.data != subtree.data)
	{
		return false; // data does not match
		//in this case we do not need to compare until the last level
	}

	return matchTree(tree.left, subtree.left) && matchTree(tree.right, subtree.right);
}