/*
The classification of Tree::
A binary tree is full if each node has 2 or 0 children
A binary tree is complete if only the last level has the chidren from left to the right
A binary tree is perfect if it is full and each leaf is at the same depth
That depth is O(log N)

Expression Trees::
Expression Trees are yet another way to store mathematical expressions

Decision Trees::
Left/right child represents yes/no answers to questions

We should mark the nodes already visited to avoid cycles and repetition of the nodes
*/

//Note: it may be worth discussing the trade-offs between BFS and DFS
//DFS is simpler because it just use the simple recursion
//BFS could be useful in finding shortest path, whereas DFS may traverse one adjacent node 
//very deeply before ever going onto the immediate neighbors

public enum State{
	Unvisited, Visited, Visiting;
}//similar to the #define ROW_SZ 10 in c++

public class BFS:DFS
{
	//check if there is a route between start and end, which is not necessaryly direct route
	public static boolean search(Graph g, Node start, Node end)
	{
		if(start == end)   return true;
		//use linkedlist to use as queue
		//because the linkedlist is a template rather than a specific class
		//we must explicity point out the type of the elements stored in the list
		LinkedList<Node> queue = new LinkedList<Node> ();

		for(Node each_node : g.getNodes())//after : must be a contanier(set) of the preceding element
		{
			//initialize all the nodes in the graph with unvisited state
			//for the data structure node we add a new attribute "state" for each node
			each_node.state = State.Unvisited;
		}
		//visiting state is used as the current node visited
		start.state = State.Visiting;

		q.add(start);//add a new node to the existing 
		Node current_node;
		//一开始整个队列里面只有一个start然后flooding 这个BFS 把每一个邻居都加到队列里面再一个个看他们的邻居
		//一旦在这个整个循环过程中  即队列有进有出且尚未空的状态下如果遇到了 访问到了传进来的ending point
		//则立刻prune剪枝返回 true    一旦出了这个大循环 也就是队列已经空了 BFS完成了整个图的搜索 那么就return false 
		while(!queue.isEmpty())
		{
			current_node = queue.removeFirst();//i.e. using as dequeue opetration in linkedlist -> removeFirst
			if(current_node != null)
			{
				for (Node neighbors : current_node.getAdjacent()){
					if(neighbors.state == State.Unvisited)
					{
						if(neighbors == end)
						{
							return true;
						}else{
							neighbors.state = State.Visiting;
							queue.add(neighbors);
							//using add() and removeFirst() in linkedlist to simulate operations in queue
						}
					}
				}
			}
			//after visiting all the possible neighbors for the current node
			//we should update the current node with the new state: Visited
			current_node.state = State.Visited;
		}
	}
	return false;
}