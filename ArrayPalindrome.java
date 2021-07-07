/*
Minimum operations to make array palindrome

Time= O(n)
Space = O(1)
 */
package RBR_DSA.ArrayProblems;

public class ArrayPalindrome {
    public static int minOperations(int[] a,int n)
    {
        int i=0,j=n-1,op=0;
        while(i<j)
        {
            if(a[i] == a[j])
            {
                i++;
                j--;
            }
            else
            {
                if(a[i]<a[j])
                {
                    //merge at i side
                    a[i+1]=a[i]+a[i+1];
                    i++;
                    op++;
                }
                else
                {
                    a[j-1]=a[j]+a[j-1];
                    op++;
                    j--;
                }
            }
        }
        return op;
    }
    public static int recursiveOperations(int[] a,int start,int end)
    {
        if(start == end)
            return 0;
        if(a[start] == a[end])
            return recursiveOperations(a,++start,--end);
        else if(a[start] < a[end])
        {
            a[start+1]+=a[start]; //merge
            return 1+recursiveOperations(a,++start,end);
        }
        else if( a[end] < a[start])
        {
            a[end-1]+=a[end]; //merge
            return 1+recursiveOperations(a,start,--end);
        }
        return 0;//just to maintain syntax
    }
    public static void main(String[] args)
    {
        int arr[]={10,20,10,30};
        System.out.println(recursiveOperations(arr,0,3));

        int arr2[]={10,10,30};
        System.out.println(recursiveOperations(arr2,0,2));

        int arr3[]={10,20,30,40,50,60,70};
        System.out.println(recursiveOperations(arr3,0,6));

        int arr4[]={50};
        System.out.println(recursiveOperations(arr4,0,0));

    }
}
