/*
Adjacency list representation of graph O(V+2E),=> O(V+E)
Adjacency matrix representation, O(V^2)
 */
package RBR_DSA.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Graph
{
    HashMap<Integer, LinkedList<Integer>> m = new HashMap<>();
    Integer adjMat[][];
    Graph(int n){
        adjMat=new Integer[n][n];
        for(Integer[] x:adjMat)
            Arrays.fill(x,0);
    }

    //function to add vertices
    //function to add edge

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
        adjMat[source-1][dest-1]=1;
        m.get(source).add(dest);//adds dest vertex to adjacency list associated with source.
        if(bidirectional == true)//if graph is undirected
        {
            m.get(dest).add(source);
            adjMat[dest-1][source-1]=1;
        }
    }
    public void displayAdjList()
    {
        for(Integer key:m.keySet())
        {
            System.out.print(key+" : ");
            for(Integer x: m.get(key))
                System.out.print(x+"     ");
            System.out.println();
        }
    }

    //Adjacency Matrix
    public void displayAdjMatrix()
    {
        System.out.print("V   ");
        for(Integer i=0;i<adjMat.length;i++)
            System.out.print(i+1+"   ");
        System.out.println();
        int v=1;
        for(Integer[] x:adjMat)
        {
            System.out.print(v+++"   ");
            for(Integer y:x)
                System.out.print(y+"   ");
            System.out.println();
        }
    }


}
public class printGraph {
        public static void main(String[] args)
        {
            Graph G=new Graph(7);
            G.addVertex(1);
            G.addVertex(2);
            G.addEdge(1,2,true);
            G.addEdge(1,3,true);
            G.addEdge(2,4,true);
            G.addEdge(2,5,true);
            G.addEdge(5,6,true);
            G.addEdge(7,6,true);
            G.addEdge(3,7,true);
            System.out.println("Adj List of graph");
            G.displayAdjList();
            System.out.println("Adj Matrix of graph");
            G.displayAdjMatrix();

            System.out.println("Input number of vertices");

            Graph G2=new Graph(8);
            G2.addEdge(1,2,false);
            G2.addEdge(2,4,true);
            G2.addEdge(3,4,true);
            G2.addEdge(5,7,false);
            G2.addEdge(5,8,false);
            G2.addEdge(5,6,false);
            System.out.println("Adj List of graph");
            G2.displayAdjList();
            System.out.println("Adj Matrix of graph");
            G2.displayAdjMatrix();

        }
}
