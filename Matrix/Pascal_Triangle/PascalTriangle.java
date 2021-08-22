/*
Print nth row of pascal triangle
time=O(n), for generating n terms of row
Space=O(1),no extra space, we just need previous term to generate next term, so we store it in variable
 */
package RBR_DSA.Pascal_Triangle;
import java.util.*;
public class PascalTriangle {
        //static public void getTriangle(int[][] )
        static public List<Integer> getRow(int n)  //time=O(n),Space=O(1)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            long prev=1;
            n++;
            for(int i=1;i<=n-1;i++)
            {
                l.add((int)prev);
                prev=prev*(n-i)/i;
            }
            l.add(1);

            return (List)l;
        }

    public static void main(String[] args)
    {
        List l=getRow(33);
        Iterator i=l.listIterator();
        while (i.hasNext())
            System.out.print(i.next()+"   ");
        System.out.println();
    }
}
