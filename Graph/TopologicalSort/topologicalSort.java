/*
Time = O(V+E)
Space = O(V), queue and inDegree array
 */
package RBR_DSA.Graph.TopologicalSort;

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

public class topologicalSort {
    public static void topological_sort(Graph g)
    {
        int n=g.visited.length;
        Integer[] inDegree =  new Integer[n];
        for(int i=0;i<n;i++)
            inDegree[i]=0;
        for(Integer i=0;i<n;i++) //O(v+E)
        {
            for(Integer x:g.m.get(i))
            {
                inDegree[x]++;
            }
        }
        Integer src;
        Queue q=new ArrayDeque(); //O(V) space
        for(int i=0;i<n;i++) //O(V)
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        for(int i=0;i<n;i++) //O(V)
        {
            src=(Integer) q.remove();
            System.out.println(src);
            for(Integer x:g.m.get(src)) //On total we see E edges, O(E)
            {
                inDegree[x]--;
                if(inDegree[x] == 0)
                    q.add(x);

            }
            if(q.isEmpty())
                return;
        }//O(V+E)
    }
    public static void main(String[] args)
    {
        Graph G1=new Graph(5);//O(V), for visited arr initialization, fill()
        G1.addEdge(0,2,false);
        G1.addEdge(2,3,false);
        G1.addEdge(4,3,false);
        G1.addEdge(4,1,false);
        G1.addEdge(1,2,false);
        System.out.println("Topological sort");
        topological_sort(G1);


        Graph G2=new Graph(6);//O(V), for visited arr initialization, fill()
        G2.addEdge(1,0,false);
        G2.addEdge(4,0,false);
        G2.addEdge(0,2,false);
        G2.addEdge(0,3,false);
        G2.addEdge(3,2,false);
        G2.addEdge(2,5,false);
        G2.addEdge(3,5,false);
        System.out.println("Topological sort");
        topological_sort(G2);
    }
}
