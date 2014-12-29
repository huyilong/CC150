//after thinking , we find that all the use of the array 
//i.e. the extra storage space is used for the comparing relationship
//now -> we could deprecate the degraded performance of the last version and use a single variable
//to record the last element, that would be enough to work 

public static Integer last = null;
public static boolean checkBST(Node n)
{
	if(n == null) return true;
	if(!checkBST(n.left))   return false;

	if(last!=null && n.data < = last)
	{
		return false;
	}

	//update the last to the current data if satisfying
	last = n.data;

	if(!checkBST(n.right))  return false;

	return true;
}

//instead of using global static variable here, we could instead wrap it with a wrapper class 
//or in c++ we could conveniently use the reference to pass through the recursive calls