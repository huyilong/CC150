//one straightforward method is to store the output of the in-order traversal of BST
//and check if that array is sorted (ascending / descending)
//the only problem is that it could not deal with duplicates:: 
//valid BST: leftchild <= root < rightchild

public static int index =0;
//we need global static variable to offset the negative effect of recursion
public static void copyBST(Node<Integer> root, int[] arr){
	if(root == null)
		return;//for void type method if we do not want to do anything
	//then just use "return;" to indicate for now the method should be terminated
	//and should not go down anymore , eg. corner condition / base case

	copyBST(root.left, arr);

	//this block of memory is allocated in the other function 
	//and passed in here
	//int[] arr = new int[root.size];
	arr[index] = root.data;
	index++;
	copyBST(root.right, arr);
	//the statements above is actually the modification of in-order traversal

}

public static boolean checkBST(Node<Integer> root){
	//actually here we are using the dynamic array???
	int[] arr = new int[root.size];
	copyBST(root, arr);
	//every time get back the arr to check if it satisfies the requirements of BST
	for(int i=1; i<arr.length; ++i){
		if(arr[i] <= arr[i-1])
			return false;
	}

	return true;
}