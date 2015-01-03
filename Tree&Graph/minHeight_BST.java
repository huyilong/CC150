TreeNode<Integer> createMinBST(int arr[]){
	return createMinBST(arr, 0, arr.length - 1);
}

TreeNode<Integer> createMinBST(int arr[], int start, int end){
	if(end<start){
		return null;
	}//this is actually the base case, if it is touchdown then let the
	//leaf node of the tree's children be null

	int mid =(start+end)/2;
	//each time choose the middle large number in sorted array 
	//and recursively get the left part into the left subtree
	//and right part into the right subtree
	//which is similar to the merge sort :: touchdown to the smallest pair (subgroup) in the array
	TreeNode<Integer> node = new TreeNode<Integer>(arr[mid]);

	//in tree if you want to construct a tree by inserting a node
	//remember to let the returned value given to the parent node
	n.left = createMinBST(arr, start, mid-1);
	n.right = createMinBST(arr, mid+1, end);
	//because mid is already used

	return n;//do not forget to return n in the end
}