/*
0/1 Knapsack
Time = O(min(2^n , nw))
Space = O(nw)
 */
package RBR_DSA.DynamicProgramming.Knapsack_01;

class Item
{
    int weight, profit;
    Item(int w,int p)
    {
        weight=w;
        profit=p;
    }
}

public class Using_BottomUpImplementation {
    public static int knapsack(Item[] arr,int items,int bagcap)
    {
        int[][] ks=new int[items+1][bagcap+1];
        for(int i=0;i<=items;i++)
            ks[i][0]=0;
        for(int i=0;i<=bagcap;i++)
            ks[0][i]=0;

        for(int i=1;i<=items;i++)
        {
            int max=Integer.MIN_VALUE;
            int wi=arr[i-1].weight;
            int pi=arr[i-1].profit;
            for(int j=1;j<=bagcap;j++)
            {
                if(wi <= j)
                    ks[i][j]=Math.max(pi+ks[i-1][j-wi] ,ks[i-1][j]);
                else
                    ks[i][j]=ks[i-1][j];
            }
        }
        return ks[items][bagcap];
    }
    public static void main(String[] args)
    {
        Item[] arr=new Item[7];
        arr[0]=new Item(2,10);
        arr[1]=new Item(3,5);
        arr[2]=new Item(5,15);
        arr[3]=new Item(7,7);
        arr[4]=new Item(1,6);
        arr[5]=new Item(4,18);
        arr[6]=new Item(1,3);
        System.out.println("Max profit acheivable = "+knapsack(arr,7,15));

        Item[] arr2=new Item[3];
        arr2[0]=new Item(1,10);
        arr2[1]=new Item(2,12);
        arr2[2]=new Item(4,28);
        System.out.println("Max profit acheivable = "+knapsack(arr2,3,6));
    }
}
