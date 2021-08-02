/*
Single source shortest path dijkstra
Time = O(ElogV), relaxing E edges, which takes logV time
Space = O(V)

 */
package RBR_DSA.GreedyAlgorithms.Dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Adjacency_List
{
    Map<Integer, LinkedList<Adjacency_List.AdjListNode>> m=new HashMap<>();
    class AdjListNode
    {
        Integer vertex,cost;
        AdjListNode(int vertex,int cost)
        {
            this.cost=cost;
            this.vertex=vertex;
        }
    }
    Adjacency_List(int n)
    {
        for(Integer i=0;i<n;i++)
            m.put(i,new LinkedList<>());
    }

    void addEdge(Integer src,Integer dest,Integer cost,boolean undrctd)
    {
        m.get(src).addFirst(new Adjacency_List.AdjListNode(dest,cost));//O(1)
        if(undrctd == true)
        {
            m.get(dest).addFirst(new Adjacency_List.AdjListNode(src,cost));
        }
    }
}

public class Dijkstra {
    public static int min_key(Integer[] key, Integer found_shortest[])
    {
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int i=0;i<key.length;i++)
        {
            if(found_shortest[i]==0 && key[i]<min)
            {
                min=key[i];
                min_index=i;
            }
        }
        return min_index;
    }
    public static void shortest_path(Adjacency_List l,int vertices,int source)
    {
        Integer distance[]=new Integer[vertices];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source]=0;
        Integer found_shortest[]=new Integer[vertices];
        Arrays.fill(found_shortest,0);
        for(int i=0;i<vertices;i++)
        {
            int u=min_key(distance,found_shortest);
            if(u == -1)
                break;
            found_shortest[u]=1;
            System.out.print(u+"   ");
            for(Adjacency_List.AdjListNode x:l.m.get(u))
            {
                //relax this edge
                if(x.cost+distance[u] < distance[x.vertex])
                    distance[x.vertex]=x.cost+distance[u];
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Adjacency_List l=new Adjacency_List(6);
        l.addEdge(0,1,1,false);
        l.addEdge(0,2,7,false);
        l.addEdge(0,5,6,false);
        l.addEdge(1,3,1,false);
        l.addEdge(1,5,4,false);
        l.addEdge(2,4,2,false);
        l.addEdge(3,5,2,false);
        l.addEdge(3,4,1,false);
        l.addEdge(5,2,3,false);
        l.addEdge(5,4,2,false);
        shortest_path(l,6,0);
        shortest_path(l,6,2);//not reachable to all vertices from source 2

    }
}

