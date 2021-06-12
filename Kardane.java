/*
Time= O(n)
Space = O(n)
 */
package RBR_DSA.KardaneAlgorithm;

public class Kardane {
    public void maxSum(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        int current_sum=0;//Don't initialize, current_sum with MIN_VALUE, as the addition inside loop, when array element is negative, may result in overflow and, becomes positive, which will be considered as itself a maximum current sum. Just check by doing so
        for(int x: arr)
        {
                current_sum=Math.max(current_sum+x , x);//if(cs<0), then cs will be x. else, include x and enlarge subarray, by making sum, cs+x
                max=Math.max(max,current_sum);//Finds the maximum of all current sums. Each time current sum is updated, keep track of the maximum till then ,
                // if not, at last, the current sum at that point will be returned, and no count will be taken regarding maximum.
        }
        System.out.println(max);
    }
    public static void main(String[] args)
    {
        Kardane k=new Kardane();
        int[] a={-3,1,2,-3,4};
        int[] p={10,11,2,5};
        int[] n={-11,-10,-13,-1,-5};
        k.maxSum(a);
        k.maxSum(p);
        k.maxSum(n);
    }
}
