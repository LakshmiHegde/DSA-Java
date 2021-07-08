package RBR_DSA.ArrayProblems;
import java.util.*;
public class MinimizeHeights {
    static int getMinDiff(int[] arr, int n, int k)
    {
        Arrays.sort(arr);
        int ans=arr[n-1] - arr[0];
        int min=arr[0]+k;
        int max=arr[n-1]-k;
        int min_c,max_c;

        for(int i=0;i<n-1;i++)
        {
            int add=arr[i]+k;
            int sub=arr[i+1]-k;
            min_c=Math.min(min,sub);
            max_c=Math.max(max,add);
            if(min_c <0)
                continue;
            ans=Math.min(ans, (max_c - min_c));
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr={1, 8, 5, 10};
        System.out.println("Maximum difference between two towers = "+ getMinDiff(arr,4,3));
        int[] arr2={3, 9, 16, 12, 20};
        System.out.println("Maximum difference between two towers = "+ getMinDiff(arr2,5,6));
        int[] arr3={10,4};
        System.out.println("Maximum difference between two towers = "+ getMinDiff(arr3,2,4));
    }
}
