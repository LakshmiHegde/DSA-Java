/*
Here we used, adj list of graph , to represent graph
Time= O(v+E)
Space = O(V) for visited arr and queue space. Map is input space to store graph, don't consider it as space.
 */
package RBR_DSA.Graph.BFS_DFS;
import java.util.*;

class Graph
{
    HashMap<Integer, LinkedList<Integer>> m = new HashMap<>();
    Integer visited[];
    Graph(int n){
        visited=new Integer[n];
        Arrays.fill(visited,0);
    }

    public void addVertex(Integer v)
    {
        m.put(v,new LinkedList<>());
    }
    public void addEdge(Integer source, Integer dest, boolean bidirectional)
    {
        //If source or dest not present , create vertex and add corresponding edge
        if(!m.containsKey(source))
        {
            addVertex(source);
        }

        if(!m.containsKey(dest))
        {
            addVertex(dest);
        }
        //Now add edge
        m.get(source).add(dest);//adds dest vertex to adjacency list associated with source.
        if(bidirectional == true)//if graph is undirected
        {
            m.get(dest).add(source);
        }
    }
}
public class BFS {
    public static void bfs_traversal(Graph g)
    {
        for(int i=0;i<g.visited.length;i++)
        {
            if(g.visited[i] == 0)
                bfs(g,i+1);
        }
    }
    public static void bfs(Graph g,Integer source)
    {
        Queue<Integer> q= new ArrayDeque<>(); //O(V) space
        g.visited[source-1]=1;

        while (true)
        {
            System.out.print(source+"   ");
            for(Integer x:g.m.get(source)) //adj list, considering altogether, for n vertices, we get 2E vertices, in worst case, therefore this loop executes, O(E) times
            {
                // mark it visited and put it in queue
                if(g.visited[x-1] == 0)
                {
                    g.visited[x-1]=1;
                    q.add(x);
                }
            }
            if(!q.isEmpty())
                source=q.poll();
            else
                break;
        }
    }
    public static void main(String[] args)
    {
        Graph G=new Graph(7);//O(V), for visited arr initialization, fill()
        G.addVertex(1);
        G.addVertex(2);
        G.addEdge(1,2,true);
        G.addEdge(1,3,true);
        G.addEdge(2,4,true);
        G.addEdge(2,5,true);
        G.addEdge(5,6,true);
        G.addEdge(7,6,true);
        G.addEdge(3,7,true);
        System.out.println("BFS of graph");
        bfs(G,1);//O(2E) entries

        Graph G2=new Graph(5);
        G2.addEdge(1,2,false);
        G2.addEdge(1,4,false);
        G2.addEdge(2,3,false);
        G2.addEdge(5,2,false);
        G2.addEdge(4,5,false);
        System.out.println("\nBFS of graph");
        bfs(G2,1);

        Graph G3=new Graph(8); //disconnected graph
        G3.addEdge(1,2,false);
        G3.addEdge(1,3,false);
        G3.addEdge(4,3,false);
        G3.addEdge(4,2,false);
        G3.addEdge(5,7,false);
        G3.addEdge(5,6,false);
        G3.addEdge(5,8,false);
        System.out.println("\nBFS of graph");
        //bfs(G3,1);//only one component gets searched, therefore use traversal
        bfs_traversal(G3);


    }
}
