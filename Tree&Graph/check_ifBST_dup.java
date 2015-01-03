//optimize:: actually we never need the whole array because
//all we need to do is just tracking the last element we saw and compare it as we go
public static Integer last = null;
public static boolean checkBST(Node<Integer> n){
	if(n==null)  
		return true;
	//base condition

	if(!checkBST(n.left))
		return false;

	//check the middle node
	if(last != null && n.data <= last){
		return false;
	}
	last=n.data; // update the rolling arr
	//1d array rolls as two variables, one is current and the other is last
	//2d array rolls as two 1d arrays, one row is for current and the other is for the last

	if(!checkBST(n.right))
		return false;

	//after all the seiving above we could eventually return true to the previous level of recursion
	return true;
}