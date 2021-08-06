/*
Multistage graph, problem to find shortest path from source to destination
(n-1) subproblems, we need to find shorttest path from every vertex to destination. Time taken to solve each problem is ,Sometimes k ranges for n values, therefore n^2
Time = O(n^2) = O(v^2) = O(E)
Space = O(n)
 */
package RBR_DSA.DynamicProgramming.MultiStageGraph;

public class Multistage_graph {
    public static int shortest_path(int[][] cost,Integer source,int vertices)
    {
        Integer[] T=new Integer[vertices];
        T[vertices-1]=0;
        for(int v=vertices-2;v>=0;v--)
        {
            int min=Integer.MAX_VALUE;
            for(int k=v+1;k<vertices;k++)
            {
                if(cost[v][k] != Integer.MAX_VALUE)
                    T[v]=Math.min(cost[v][k]+T[k],min);
            }
        }
        return T[0];
    }
    public static void main(String args[])
    {
        int infinity = Integer.MAX_VALUE;
        int[][] cost={
                {infinity,1,2,5,infinity,infinity,infinity,infinity},
                {infinity,infinity,infinity,infinity,4,11,infinity,infinity},
                {infinity,infinity,infinity,infinity,9,5,16,infinity},
                {infinity,infinity,infinity,infinity,infinity,infinity,2,infinity},
                {infinity,infinity,infinity,infinity,infinity,infinity,infinity,18},
                {infinity,infinity,infinity,infinity,infinity,infinity,infinity,13},
                {infinity,infinity,infinity,infinity,infinity,infinity,infinity,2}
        };

        System.out.println("Shortest path between source and sink "+shortest_path(cost,0,8 ));

    }
}
