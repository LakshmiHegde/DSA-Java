/*
Count, no of 1s set, in range of 1 to n.
 */
package RBR_DSA;

public class SumOfSetBits {
    public static int countSetBits(int n){
        //find largest 2 power number, < n
        if(n == 0)
            return 0;

        int largestPower = largePowerComputing(n);//O(logn)
        int lastNumberSortedForCount = (1<<(largestPower-1)) * largestPower ;
        int restCountSorted = n - (1<<largestPower) + 1;
        int restToBeCounted = n - (1<<largestPower);
        int ans= lastNumberSortedForCount+restCountSorted+countSetBits(restToBeCounted);//T(n)=T(rest)+1
        return ans;

    }
    public static  int largePowerComputing(int n)//O(logn)
    {
        int i=0;
        while((1 << i) <= n)
        {
            i++;
        }
        return i-1;
    }
    public static void main(String[] args)
    {
        System.out.println("Total set bits in binary representation of decimals from 1 to 10 is "+ countSetBits(10));
        System.out.println("Total set bits in binary representation of decimals from 1 to 88 is "+ countSetBits(88));
        System.out.println("Total set bits in binary representation of decimals from 1 to 20 is "+ countSetBits(20));
        System.out.println("Total set bits in binary representation of decimals from 1 to 108 is "+ countSetBits(108));
    }
}
