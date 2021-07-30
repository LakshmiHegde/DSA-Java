/*
Problem statement : Given, two arrays, merge them, without using any extra space.
You could use merge procedure, but it takes O(n) extra space.
So modified, insertion sort is the approach

Time = O(mn), for arr1 , if each element is greater than ele in arr2, then, for every element in worst case, we may need to swap them, and shift all elements of arr2, to find right position for swapped one.
therefore, for 1 ele, n elements of arr2 gets shifted.
therefore, n elements, mn .
Space=O(1)
 */
package RBR_DSA.ArrayProblems;

public class MergeSortedArrays {
    public static void mergeViaInsertionSort(int[] arr1, int[] arr2,int m, int n)
    {
        int j=0,i=0;
        while(i<m && j<n)
        {
            //System.out.println("i = "+ i+" j= "+j);
            while(i<m && arr1[i]<=arr2[j])
                i++;
            if(i==m)
                break;
            int temp=arr1[i];
            arr1[i]=arr2[j];
            arr2[j]=temp;

            int k=j+1;
            int key=arr2[j];
            while(k<n && arr2[k]<key)
            {
                arr2[k-1]=arr2[k];
                k++;
            }
            arr2[k-1]=key;
        }
        for(int x:arr1)
            System.out.print(x+"    ");
        for(int x:arr2)
            System.out.print(x+"    ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        int testCase1[] ={40,43,49,50,54};
        int testCase2[] ={30,42,45, 53};
        mergeViaInsertionSort(testCase1,testCase2,5,4);

        int arr1[]={1,12,15,26,38};
        int arr2[]={2,13,17,30,45};
        mergeViaInsertionSort(arr1,arr2,5,5);

        int testCase3[] ={40,52,55,66};
        int testCase4[] ={};
        mergeViaInsertionSort(testCase3,testCase4,4,0);

        int testCase5[] ={};
        int testCase6[] ={};
       mergeViaInsertionSort(testCase5,testCase6,0,0);

        int test7[]={2, 6, 7, 8, 9, 9, 10, 10, 11, 12, 12, 12, 12, 13, 13, 13, 14, 15, 16, 16, 17, 18, 18, 19, 20};
        int test8[]={1 ,5 ,5 ,7, 7, 8 ,9 ,11, 15, 18, 18, 18, 20, 20};
        mergeViaInsertionSort(test8,test7,14,25);

    }
}
