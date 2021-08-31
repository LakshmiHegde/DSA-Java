package RBR_DSA.Stacks_and_Queues.NextSmallerElement;

import java.util.Stack;

public class NSE {
    public static int[] nse(int[] arr)
    {
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int j=n-1;j>=0;j--)
        {
                while (s.isEmpty()==false)
                {
                    if(s.peek() >= arr[j])
                        s.pop();
                    else
                        break;
                }
                if(s.isEmpty())
                    res[j]=-1;
                else
                    res[j]=s.peek();
                s.push(arr[j]);
        }
        return res;
    }
    public static void main(String[] args)
    {
        int arr[]={4,8,5,2,25};
        int res[]=nse(arr);
        for(int x:res)
            System.out.print(x+"   ");
        System.out.println();
    }
}
