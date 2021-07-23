/*
Time = O(n), 2 traversals
Space =O(2n), stack and left limit array
 */
package RBR_DSA.Histogram;
import java.util.Stack;
public class max_rectangle {
    public static int rectangle_area(int[] hist,int n)
    {
        int left[]=new int[n];//O(n)
        Stack<Integer> s=new Stack<>(); //O(n)
        int max_area=Integer.MIN_VALUE;
        //compute left limits
        for(int i=0;i<n;i++)//O(n)
        {
            if(s.empty())
            {
                left[i] =0;
            }
            else
            {
                while(!s.empty() && hist[s.peek()] >= hist[i])
                    s.pop();
                if(s.empty())
                    left[i]=0;
                else
                    left[i]=s.peek()+1;
            }
            s.push(i);
        }
        s.clear();
        int width=0,area;
        int right;
        for(int i=n-1;i>=0;i--)//O(n), computes both, right limit and area simultaneously
        {
            if(s.empty())
            {
                right =n-1;
            }
            else
            {
                while(!s.empty() && hist[s.peek()] >= hist[i])
                    s.pop();
                if(s.empty())
                    right=n-1;
                else
                    right=s.peek()-1;
            }
            width = right-left[i] +1;
            area = width*hist[i];
            if(area>max_area)
                max_area=area;
            s.push(i);
        }
        return max_area;

    }
    public static void main(String[] args)
    {
        int arr[]={2,1,4,3,5};
        System.out.println(rectangle_area(arr,5));

        int arr2[]={6, 2, 5, 4, 5, 1, 6};
        System.out.println(rectangle_area(arr2,7));
    }
}
