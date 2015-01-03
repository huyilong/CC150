//firstly : have to clarify that the tree could be a normal tree which is not a BST
//secondly : analysis -> if the two nodes are on the two sides then their parent
//must be the first(lowest) common ancestor because they could not possibly traverse down
//while still covering both two nodes in one "node"

//covers method 
//abstract: returns true if the input descendent is a descendent of root
//i.e. the input is contained by the subtree of the root
boolean covers(Node<Integer> descendent){
	if(root == null)  
		return false;
	if(root == descendent)
		return true;

	return covers(root.left, descendent) || covers(root.right, descendent);

}
//this function is too classic to be forgotten

Node<Integer> findCommonAncestorHelper(Node<Integer> root, Node<Integer> p, Node<Integer> q){
	if(root == null)
		return false;
	if(root == p || root == q)
		return true;//base condition->if found

	boolean is_p_on_left = covers(root.left, p);
	boolean is_q_on_left = covers(root.right, q);

	//if p and q are on the different sides of the node
	if(is_p_on_left != is_q_on_left)
		return root;

	//else they are on the same side and thus the current node is not the lowest common ancestor
	//we need to traverse one of the side
	//attention: many times we do not need to declare two variable, for both sides
	//because they are complementary: if it is not on the left -> it is on the right

	//similar problem: if we want to guarantee two numbers' sum equal sum and know one of them x
	//then we could just try to find if the list also contains sum-x is enough

	//be smart and effecient :  use the logic and the complementary to save time and code
	Node<Integer> child_side = is_p_on_left ? root.left : root.right;
	//because the precondition is that p and q are on the same side: we only need to judge 
	// one of them
	return findCommonAncestorHelper(child_side, p , q);
}

Node<Integer> findCommonAncestor(Node<Integer> root, Node<Integer> p, Node<Integer> q)
{
	if(!covers(root, p) || !covers(root,q)){
		return null;
	}

	return findCommonAncestorHelper(root, p, q);

}