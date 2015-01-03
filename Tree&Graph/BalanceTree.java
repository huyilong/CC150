public static int getHeight(Node<Integer> root){
	if(root == null)
		return 0;
	//base case

	return Math.max(getHeight(root.left),getHeight(root.right))+1;

}

//the heights of the two subtrees of any node never differ by more than one
public static boolean isBalanced(Node<Integer> root){
	if(root == null)
		return true; // base case

	int diff = getHeight(root.left) - getHeight(root.right);
	if(Math.abs(diff) > 1){
		return false;
	}else{
		//will combine the boolean returned by left subtree and right subtree
		return isBalanced(root.left)&&isBalanced(root.right);
	}
}

//here we touchdown every node in the tree, which is not necessary 
//therefore we actually would better check the root and if it is not isBalanced directly return -1