/*

Time = O(n)
Space = O(1)
 */
package RBR_DSA.ArrayProblems.Stocks;

public class Stocks {
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        int min=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<n;i++)
        {
            if(prices[i]<min)
                min=prices[i];
            else
            if(prices[i]-min > profit)
                profit=prices[i]-min;
        }
        return profit;
    }
    public static void main(String[] args)
    {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        int[] prices2 = {7,6,5,4,3,1};
        System.out.println(maxProfit(prices2));
    }
}
