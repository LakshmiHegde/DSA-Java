package RBR_DSA.Graph.CycleDetect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Graph
{
    HashMap<Integer, LinkedList<Integer>> m = new HashMap<>();
    Integer visited[];
    Integer[] rec_stack;
    Graph(int n){
        visited=new Integer[n];
        Arrays.fill(visited,0);
        rec_stack=new Integer[n];
        Arrays.fill(rec_stack,0);
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
public class cycle {

    public static boolean isCyclePresent(Graph G,Integer src)
    {
        if(G.rec_stack[src] == 1)
            return true;
        if(G.visited[src] == 1)
            return false;
        G.visited[src]=1;
        G.rec_stack[src]=1;
        for(Integer x:G.m.get(src))
            if(isCyclePresent(G,x))
                return true;
        G.rec_stack[src]=0;
        return false;
    }
    public static void main(String[] args)
    {
        Graph G=new Graph(7);//O(V), for visited arr initialization, fill()
        G.addEdge(0,2,true);
        G.addEdge(0,1,true);
        G.addEdge(1,4,true);
        G.addEdge(1,3,true);
        G.addEdge(4,5,true);
        G.addEdge(6,5,true);
        G.addEdge(2,6,true);
        System.out.println("Is cycle present "+isCyclePresent(G,0));

        Graph G1=new Graph(7);//O(V), for visited arr initialization, fill()
        G1.addEdge(0,1,false);
        G1.addEdge(0,4,false);
        G1.addEdge(4,1,false);
        G1.addEdge(1,2,false);
        G1.addEdge(2,3,false);
        G1.addEdge(3,6,false);
        G1.addEdge(6,5,false);
        G1.addEdge(5,1,false);
        System.out.println("Is cycle present "+isCyclePresent(G1,0));


        Graph G2=new Graph(3);//O(V), for visited arr initialization, fill()
        G2.addEdge(0,1,false);
        G2.addEdge(0,2,false);
        G2.addEdge(2,1,false);
        System.out.println("Is cycle present "+isCyclePresent(G2,0));

    }
}
