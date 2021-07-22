/*
Program to find median of row-wise sorted matrix
Works for all elements inside matrix ,that are positive
Uses binary search implementation
Time = O(32 * r*logC)
Space=O(1)
 */
package RBR_DSA.ArrayProblems;
public class medianOfRowWiseSorted {
    public static int eleLessThanMiddle(int[] arr,int target)
    {
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid] > target)
                high=mid-1;
            else if(arr[mid] <= target)
                low=mid+1;
        }
        return low;
    }
    public static int median(int[][] arr,int m,int n)
    {
        int min=arr[0][0],max=arr[0][n-1],mid;
        int count=0;
        for(int i=1;i<m;i++)
        {
            if(arr[i][0] < min)
                min=arr[i][0];
            if(arr[i][n-1] > max)
                max=arr[i][n-1];
        }
        int half=(m*n)/2;

        while(min<=max)
        {
            count=0;
            //System.out.print("Start "+min+"  "+max+"\n");
            mid=(min+max)/2;
            //System.out.println("Mid = "+mid);
            for(int i=0;i<m;i++)
            {
                count+=eleLessThanMiddle(arr[i],mid);
            }
            //System.out.println("Count ="+count);
            if(count> half)
                max=mid-1;
            else if(count<= half)
                min=mid+1;
            //System.out.println("\n");
        }
        return min;
    }
    public static void main(String[] args)
    {
        int[][] arr={
                {2,5,9,10,13},
                {1,3,6,11,12},
                {-1,0,7,10,13}
        };
        // -1,0,1,2,3,5,6,7,9,10,10,11,12,13,13
        System.out.print(median(arr,3,5) + "   \n ");


        int[][] arr3={
                {2, 2, 6, 11, 11, 11, 14, 19, 19}
        ,{2, 8, 12, 13, 14, 15, 16, 17, 19},
        {1 ,2, 5 ,6 ,12 ,13 ,18 ,20 ,20},
        {5 ,5, 10, 11, 12, 15 ,17, 17, 20},
        {4 ,5 ,6 ,9 ,9 ,11 ,12 ,17 ,17},
        {2, 4, 6 ,10, 12, 14, 18, 18, 19},
        {3, 3, 8 ,8 ,11, 13, 14 ,15, 18},
         {4 ,7, 10, 15, 16, 17,18, 19, 20},
        {1, 1 ,2 ,10 ,11, 12, 16, 17, 19},
        {1 ,1 ,2 ,5 ,9, 10, 12, 16, 18},
        {4 ,6 ,7 ,8 ,13, 14, 15, 15, 18}
        };
        System.out.print(median(arr3,11,9));
    }

}
