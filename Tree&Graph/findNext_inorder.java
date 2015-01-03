//it is tricky and thus needs a pseudocode to help clarify the thoughts and all the cases
//1. if the node has the right subtree : find its leftmost child in right subtree
//2. if the node does not has the right subtree but is left to its parent : find its parent
//3. if the node does not has the right subtree but is right to its parent : 
//3*** backtracking up until find the parent still have the right subtree and then visit it
//4. if the node does not has the right subtree and also right to its parent :
//4*** backtracking up to the root of the tree : it is the last node in the in-order -> return null

public Node<Integer> inorderSuccessor(Node<Integer> n){
	if(n == null)  
		return null; // case 4
	if(n.right != null)//case 1
	{
		return leftMostChild(n.right);
		//return the leftmost child in its right subtree
	}else{
		//case 2 & 3
		Node<Integer> temp = n;
		Node<Integer> backtracking = temp.parent;
		//go up until it is on left side instead of right side
		while(backtracking != null && backtracking.left != temp){
			temp = backtracking;
			backtracking = backtracking.parent;
			//find the parent could be implemented by using the threaded binary tree
			//without create the parent poniter in node structure
		}
		return backtracking;
	}
}

public Node<Integer> leftMostChild(Node<Integer> n){
	if(n == null){
		return null;
	}
	while (n.left != null){
		n = n.left;
	}

	return n;
}

/*
二叉树添加了直接指向节点的前驱和后继的指针的二叉树称为线索二叉树。
“一个二叉树通过如下的方法“穿起来”：所有应该为空的右孩子指针指向该节点在中序序列中的后继，
所有应该为空的左孩子指针指向该节点的中序序列的前驱。”[1]

对二叉树以某种遍历顺序进行扫描并为每个节点添加线索的过程称为二叉树的线索化，
进行线索化的目的是为了加快查找二叉树中某节点的前驱和后继的速度。 
那么在有N个节点的二叉树中需要利用N+1个空指针添加线索。这是因为在N个节点的二叉树中，
每个节点有2个指针，所以一共有2N个指针，除了根节点以外每一个节点都有一个指针从它的父节点指向它，
所以一共使用了N-1个指针。所以剩下2N-(N-1)个空指针。
*/