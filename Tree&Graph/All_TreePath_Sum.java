//simplify and generalize approach
//firstly try to think about just from the root 
//and when list some examples to clarify all the cases
//generalize it to any node in the tree
//attention:  even if we find a sum path we could not stop traversing because subsequently
//it is possible that the later sum could be 0 and thus added one more path


void findSum(TreeNode node, int sum){
	int depth = depth(node);
	int[] path = new int[depth];
	findSum(node, sum, path, 0);
}

void findSum(TreeNode node, int sum, int[] path, int level)
{
	if(node == null)
		return;
	//this is an example of doing nothing returned back in recursion
	//because we only need to like adding 1 at some node -> the operation itself would be enough

	path[level] = node.data;

	//change your mind
	//look for paths with a sum that ends at (rather than starts from this point) this node
	int check_sum_ended_now = 0;
	for(int i=level; i>=0; --i){

		//this is the key statement
		check_sum_ended_now = check_sum_ended_now + path[i];

		if(check_sum_ended_now == sum){
			//whenever it is the case, call the print method
			print(path, i ,level);
		}
	}

	//then search the nodes beneath this node
	findSum(node.left, sum, path, level+1);
	findSum(node.right, sum, path, level+1);

	//remove current node from the path
	path[level] = Integer.MIN_VALUE;

}



void depth(TreeNode node){
	if(node == null){
		return 0;
	}else{
		return 1 + Math.max(depth(node.left), depth(node.right));
	}
}

void print(int[] path, int start, int end){
	for(int i = start; i<=end; i++){
		System.out.print(path[i]+" ");
	}

	System.out.println();
}