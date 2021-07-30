/*
1. Find "fall down" point
2. Find smallest integer in , increasing range, which is >"fall down" value
3. Swap them
4. Reverse the increasing range of array, so as to decrease the rank, and get exactly the next permutation

Space=O(1)
Time = O(n) + O(n)+ O(n) //worst case 3 passes totally
O(n)
 */
package RBR_DSA.ArrayProblems;

public class next_permutation {
    public static void getPermutation(int[] arr,int n)
    {
        //step 1
        int i=0;
        for(i=n-2;i>=0;i--)
        {
            if(arr[i] < arr[i+1])
                break;
        }
        if(i==-1)
        {
            reverse(arr,0,n-1);
            return;
        }
        //step 2
        int j=n-1;
        for(j=n-1;j>i;j--)
        {
            if(arr[j] >  arr[i])
                break;
        }
        //step 3
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        //step 4
        reverse(arr,i+1,n-1);

    }
    public static void reverse(int[] arr,int start, int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void display(int[] arr)
    {
        for(int x:arr)
        {
            System.out.print(x+"     ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int arr[] ={1,2,3,4,5};
        getPermutation(arr,5);
        display(arr);
        int arr1[] ={5,4,3,2,1};
        getPermutation(arr1,5);
        display(arr1);

        int arr2[] ={4,3,6,5,1,2};
        getPermutation(arr2,6);
        display(arr2);
    }
}
