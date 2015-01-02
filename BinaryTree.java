/*
结点的数据 
typedef int tree_node_elem_t;
@brief 二叉树结点 
struct binary_tree_node_t { 
	binary_tree_node_t *left; 
	binary_tree_node_t *right; 
	tree_node_elem_t elem;  结点的数据 
};
*/

/*

public class Tree<T> {
	//here we firstly declare a new node as root of the tree
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
        //which is not necessary binary tree and therefore the children are stored in the arraylist
    }

	//within the tree class we need to define a class for the node 
    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;
    }
}
*/

/*
void level_order(const binary_tree_node_t *root, int (*visit)(const binary_tree_node_t*)) 
{
      const binary_tree_node_t *p;
      //create a queue for BFS alike
      //DFS is using recursive instead
      queue<const binary_tree_node_t *> q;
	  p = root;

      if(p != nullptr)   q.push(p);

      while(!q.empty()) 
      {
          p = q.front();//each time get one node out of the queue then it will be level or BFS
          q.pop();
          visit(p);
	    //先左后右或先右后左无所谓 
	    //whenever pop out an element, then push all its children/neighbors into the queue
        if(p->left != nullptr) 
        q.push(p->left); 
        if(p->right != nullptr) 
        q.push(p->right);
	  } 
}

*/
