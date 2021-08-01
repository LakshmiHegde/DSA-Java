/*
Minimum spanning tree using kruskal algorithm
Time = O(ElogV)
Space = O(V) for create_set , sets[] array
 */
package RBR_DSA.GreedyAlgorithms.Kruskal;

import java.util.Arrays;
import java.util.Comparator;

class Edge
{
    //lets create list of edges
    Integer src,dest,cost;
    Edge(int src, int dest,int cost)
    {
        this.cost=cost;
        this.dest=dest;
        this.src=src;
    }
}

public class Kruskal {
    public static int mst(Edge[] e,Disjoint_Set[] sets)
    {
        int sum=0;
        for(Edge ed:e)
        {
            if(Disjoint_Set.find(ed.src,sets) != Disjoint_Set.find(ed.dest,sets)) //find rep of end points of edge, which is found, in sets collection.
            {
                Disjoint_Set.union(ed.src,ed.dest,sets);
                sum+=ed.cost;
            }
        }
        return sum;
    }
    public static Disjoint_Set[] make_Vertex_as_Set(int vertices)
    {
        Disjoint_Set sets[]=new Disjoint_Set[vertices];
        for(int i=0;i<sets.length;i++)
        {
            sets[i]=new Disjoint_Set();
            sets[i].create_set(i);//make each vertex a set
        }
        return sets;
    }
    public static void sort_edges(Edge[] e)
    {
        Arrays.sort(e, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost.compareTo(o2.cost);
            }
        }); //O(E logE)
    }
    public static void main(String[] args)
    {
        Disjoint_Set[] sets=make_Vertex_as_Set(6);
        int edges=7;
        Edge[] e=new Edge[7];
        e[0]=new Edge(0,2,1);
        e[1]=new Edge(1,2,2);
        e[2]=new Edge(1,3,3);
        e[3]=new Edge(2,4,4);
        e[4]=new Edge(0,1,5);
        e[5]=new Edge(3,4,3);
        e[6]=new Edge(2,3,4);
        sort_edges(e);
        System.out.println(mst(e,sets));

        sets=make_Vertex_as_Set(7);
        Edge[] list=new Edge[9];
        list[0]=new Edge(0,1,28);
        list[1] =new Edge(0,5,10);
        list[2] = new Edge(5,4,25);
        list[3] =new Edge(1,6,14);
        list[4]= new Edge(1,2,16);
        list[5] = new Edge(4,6,24);
        list[6] = new Edge(4,3,22);
        list[7] = new Edge(3,2,12);
        list[8] = new Edge(3,6,18);
        sort_edges(list);

        System.out.println(mst(list,sets));

    }
}
