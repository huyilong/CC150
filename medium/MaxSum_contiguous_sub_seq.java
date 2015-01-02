public static int go(int[] a)
{
	//do not just directly try to use the map or other assisstant space
	//only one number could be continuously updated
	int maxsum = 0;
	int sum = 0;
	for (int i=0; i< a.length;++i)
	{
		//sum is used as to locate the local sum of the continuous subsequence
		sum + = a[i];
		if(maxsum < sum){
			//we get a new optimal value
			maxsum = sum;
		}
		else if(sum<0){
			//dump all the previous continuous subsequence
			// and actually let the current one as the new first element
			sum = 0;
		}
	}

	return maxsum;
}

//here we actually judge whether contain a substring by judge its sum
//if the sum of several numbers : the final result is still larger than 0
//then it is possible for it to used for later calculation -> do not let sum be 0
// if the sum of previous subsequence is negative, then just dump it and let the sum be 0
