//计算中序遍历拥有比较简单直观的投影法
//in - order traversal    LDR 

//using in-order traversal to store in an array:: extra storage space
//Note: it is extremely important to ask the interviewer if there are duplicates in the BST
//according to the def of the BST, leftChild < = parent < rightChild is a valid BST

//we must initialize the index with a global variable so that it will work in recursive calls
public static int index = 0; 
//basic GUI interface with return type of final result and user-friendly input
public static boolean checkBST(Node root)
{
	int[] arr = new int[root.size];
	copyBST(root, arr);
	//because we need to store in the array as we recursive, it is necessary to use it as 
	//one of our recursive parameter

	//after the recursive calling 
	//in java, array.length && string.length() , they are different usages
	for(int i=1; i< arr.length; i++)
	{
		//not satisfying the requirements of BST
		if(array[i] < = array[i-1])
			return false;
	}

	return true;
}

//following recursive with void return type and actual input
public static void copyBST(Node root, int[] arr)
{
	if(root == null) return; //base condition, i.e. when we reach the last level of the tree
	//then we have to return and return and return to get our final result

	//the new version of in-order traversal
	copyBST(root.left, arr);
	arr[index] = root.data;
	index++;
	copyBST(root.right, arr);
}

