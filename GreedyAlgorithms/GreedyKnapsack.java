package RBR_DSA.GreedyAlgorithms;

import java.util.*;
class Item
{
    int weight, profit;
    Item(int w,int p)
    {
        weight=w;
        profit=p;
    }

}
public class GreedyKnapsack {
    public static double knapsack(Item[] items,int bagCap)
    {
        //compute pi/wi
        UnitPrice[] prc=new UnitPrice[items.length];
        for(int i=0;i<items.length;i++)
        {
            prc[i]=new UnitPrice(items[i].weight,items[i].profit);
        }
        Arrays.sort(prc, new Comparator<UnitPrice>() {
            @Override
            public int compare(UnitPrice o1, UnitPrice o2) {
                double u1= o1.unit;
                double u2=o2.unit;
                if(u1 < u2)
                    return 1;
                else if(u1 > u2)
                    return -1;
                else
                    return 0;
            }
        });

        int i=0;
        double maxProfit=0;
        while (bagCap>0)
        {
            if(prc[i].weight <= bagCap)
            {
                maxProfit+=prc[i].profit;
                bagCap-=prc[i].weight;
            }
            else
            {
                break;
            }
            i++;
        }
        if(bagCap> 0)
        {
            maxProfit+=(prc[i].unit * (double) bagCap);
        }

        return maxProfit;
    }
    static class UnitPrice
    {
        int weight, profit;
        double unit=0.0;
        UnitPrice(int w,int p)
        {
            weight=w;
            profit=p;
            unit=(float) profit/(float) weight;
        }
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

        System.out.println(knapsack(arr,15));

    }
}
