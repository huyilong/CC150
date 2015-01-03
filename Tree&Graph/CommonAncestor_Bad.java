//corner condition could be very small and should be very careful
/*
divide and conquer
1、原问题可以分解为多个子问题
这些子问题与原问题相比，只是问题的规模有所降低，其结构和求解方法与原问题相同或相似。
2、原问题在分解过程中，递归地求解子问题
由于递归都必须有一个终止条件，因此，当分解后的子问题规模足够小时，应能够直接求解。
3、在求解并得到各个子问题的解后
应能够采用某种方式、方法合并或构造出原问题的解。
不难发现，在分治策略中，由于子问题与原问题在结构和解法上的相似性，用分治方法解决的问题，大都采用了递归的形式。
在各种排序方法中，如归[1] 并排序、堆排序、快速排序等，都存在有分治的思想[1] 。

分治法解题的一般步骤：
（1）分解，将要解决的问题划分成若干规模较小的同类问题；
（2）求解，当子问题划分得足够小时，用较简单的方法解决；
（3）合并，按原问题的要求，将子问题的解逐层合并构成原问题的解。
*/

//System.out.println(5<<2);//运行结果是20 将5左移2位：
/*
首先会将5转为2进制表示形式(java中，整数默认就是int类型,也就是32位):

0000 0000 0000 0000 0000 0000 0000 0101           然后左移2位后，低位补0：

0000 0000 0000 0000 0000 0000 0001 0100           换算成10进制为20
*/
Node<Integer> commonAncestorBad(Node<Integer> root, Node<Integer> p, Node<Integer> q)
{
	if(root == null){
		return null;
	}
	if(root == p || root ==q){
		return root;//??????
	}

	Node<Integer> x = commonAncestorBad(root.left, p, q);
	//already find ancestor
	if(x!=null && x!=p && x!=q)
	{
		return x;
	}

	Node<Integer> y = commonAncestorBad(root.right, p, q);
	if(y!=null && y!=p && y!=q){
		return y;
	}

	if(x!=null &&y != null){
		//p and q are in diff subtrees
		return root;

	}else if(root == p || root == q){
		return root;
	}else{
		//if either x or y is non-null, return that value
		return x = null? y:x;
	}
}