import java.util.*;

/*
 *  @author hu.yilong@wustl.edu
 */
public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s

    /**
     * Computes the vertices in graph G that are
     * connected to the source vertex s.
     * @param G the graph
     * @param s the source vertex
     */

    //similar to the c++ standard
    //use a public name of the recursive base condition to make it run in the constructor
    //then use the private recursive following conditions and has a void type
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    // depth first search from v
    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        //which is different from BFS to get all the neighbors into the queue
        //here whenever we get a neighbor we will recursively get the deepest of this path then 
        //return to the base level to find the next neighbor
        for (int w : G.adj(v)) 
        {
            if (!marked[w]) 
            {
                dfs(G, w);
            }
        }
    }

    /**
     * Is there a path between the source vertex s and vertex v?
     * @param v the vertex
     * @return true if there is a path, false otherwise
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * Returns the number of vertices connected to the source vertex s.
     * i.e. the outgoing or ingoing "degree" of the node in an undirected graph.
     * @return the number of vertices connected to the source vertex s.
     */
    public int count() {
        return count;
    }

    /**
     * Unit tests the DepthFirstSearch data type.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);

        Graph G = new Graph(in);

        int s = Integer.parseInt(args[1]);

        DepthFirstSearch search = new DepthFirstSearch(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        System.out.println();

        if (search.count() != G.V())
         StdOut.println("NOT connected");
        else                         
            StdOut.println("connected");
    }

}
