package RBR_DSA.DynamicProgramming.Bellman_Ford;


import java.util.Arrays;

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

public class Bellman_Ford {
    public static boolean shortest_path(Edge[] l, int vertices, int source)
    {
        Integer distance[]=new Integer[vertices];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source]=0;
        Integer found_shortest[]=new Integer[vertices];
        Arrays.fill(found_shortest,0);
        int edges=l.length;
        for(int i=0;i<vertices-1;i++)
        {
           for(int j=0;j<edges;j++)
           {
               //(u,v) edge, check dist(u)+cost(u,v) < distance(v)
               int u=l[j].src;
               int v=l[j].dest;
               int cost=l[j].cost;

               if(distance[u]!=Integer.MAX_VALUE && (distance[u]+cost) < distance[v])
                   distance[v]=distance[u]+cost;
           }
        }
        for(int j=0;j<edges;j++)
        {
            //(u,v) edge, check dist(u)+cost(u,v) < distance(v)
            int u=l[j].src;
            int v=l[j].dest;
            int cost=l[j].cost;
            if(distance[u]!=Integer.MAX_VALUE && (distance[u]+cost) < distance[v])
                return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Edge[] list=new Edge[10];
        list[0]=new Edge(0,1,1);
        list[1] =new Edge(0,2,7);
        list[2] = new Edge(0,5,6);
        list[3] =new Edge(1,3,1);
        list[4]= new Edge(1,5,4);
        list[5] = new Edge(2,4,2);
        list[6] = new Edge(3,5,2);
        list[7] =new  Edge(3,4,1);
        list[8] = new Edge(5,2,3);
        list[9] = new Edge(5,4,2);
        System.out.println("If negative cycle exists? " + shortest_path(list,6,0));

        //negative weight cycle exists
        Edge[] l=new Edge[3];
        l[0]=new Edge(0,1,1);
        l[1]=new Edge(1,2,2);
        l[2]=new Edge(2,1,-3);
        System.out.println("If negative cycle exists? " + shortest_path(l,3,0));


    }
}
