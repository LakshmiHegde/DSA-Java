/*
Find next greater element of an element in array, treat array as circular, i,e if you reach end, again check, if the greater element exist from first till that element
Space = O(n), at max size of array=n elements can be on stack
Time = O(2n + 2n) = O(n)
 */
package RBR_DSA.ArrayProblems.NGE;
import java.util.*;
public class NGE {
    public void nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> s=new Stack<>();
        int[] nge=new int[n];
        for(int i=2*n-1;i>=0;i--)
        {
            while(s.isEmpty()==false && s.peek() <= nums[i%n])
                s.pop();
            if(s.isEmpty() == true)
                nge[i%n]=-1;
            else
                nge[i%n]=s.peek();

            s.push(nums[i%n]);
        }
       display(nge);
    }
    public void display(int[] arr)
    {
        for(int x:arr)
            System.out.print(x+"  ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        int arr[]={1,2,3,4,3};
        NGE n=new NGE();
        n.nextGreaterElements(arr);
        int arr2[]={5,3,1,2,4,6,7};
        n.nextGreaterElements(arr2);

    }
}
