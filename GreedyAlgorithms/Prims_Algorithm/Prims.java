/*
Minimum spanning tree using Prims algorithm
Time = O(ElogV)
Space = O(V) for key, parent , partoftree array
 */
package RBR_DSA.GreedyAlgorithms.Prims_Algorithm;
import java.util.*;

class Adjacency_List
{
    Map<Integer,LinkedList<AdjListNode>> m=new HashMap<>();
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
        m.get(src).addFirst(new AdjListNode(dest,cost));//O(1)
        if(undrctd == true)
        {
            m.get(dest).addFirst(new AdjListNode(src,cost));
        }
    }
}


public class Prims {
    public static int mst_prims(Adjacency_List l,int source)
    {
        int n=l.m.size();
        Integer key[] =new Integer[n];
        Arrays.fill(key,Integer.MAX_VALUE);
        Integer parent[] =new Integer[n];
        Arrays.fill(parent,-1);
        key[source]=0;
        Integer partOfTree[] =new Integer[n];
        Arrays.fill(partOfTree,0);
        int sum=0;
        for(Integer x:key)
            System.out.print(x+"  ");
        System.out.println();
        for(int i=0;i<n;i++)
        {
            int u=min_key(key,partOfTree);
            System.out.println(u);
            if(u == -1)
                break;
            partOfTree[u]=1;
            sum+=key[u];
            for(Adjacency_List.AdjListNode x:l.m.get(u))
            {
                if(partOfTree[x.vertex] == 0 && key[x.vertex] > x.cost)
                {
                    key[x.vertex]=x.cost;
                    parent[x.vertex]=u;
                }
            }
        }
        return sum;

    }
    public static int min_key(Integer[] key,Integer partOfTree[])
    {
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int i=0;i<key.length;i++)
        {
            if(partOfTree[i]==0 && key[i]<min)
            {
                min=key[i];
                min_index=i;
            }

        }
        return min_index;
    }
    public static void main(String[] args)
    {
        Adjacency_List list=new Adjacency_List(7);
        list.addEdge(0,1,28,true);
        list.addEdge(0,5,10,true);
        list.addEdge(5,4,25,true);
        list.addEdge(1,6,14,true);
        list.addEdge(1,2,16,true);
        list.addEdge(4,6,24,true);
        list.addEdge(4,3,22,true);
        list.addEdge(3,2,12,true);
        list.addEdge(3,6,18,true);
        System.out.println(mst_prims(list,0));
    }
}
