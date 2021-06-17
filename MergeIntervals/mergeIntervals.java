/*
Space  = O(2*n) not n2, as, size of array is fixed, n is outer array size, 2 is inner array size
Time = O(n^2), as both for loops scan through array, for each array, we scan, all arrays of the 2D array.
 */
package RBR_DSA.MergeIntervals;

public class mergeIntervals {
    public static int[][] merge(int[][] intervals)
    {
        int n=intervals.length , length=intervals.length;
        int start=-1, makeNull=-1;
        for(int outer = 0 ; outer<n; outer++)
        {
            for(int inner=0; inner<n;inner++)
            {
                if(inner != outer && intervals[outer]!=null && intervals[inner]!=null )
                {
                    if( intervals[outer][0] >= intervals[inner][0] && intervals[outer][0] <= intervals[inner][1])
                    {
                        start = inner;
                        makeNull = outer;
                        length --;
                        System.out.println("When matched "+outer + "  " +inner);
                        int maxLast = Math.max(intervals[start][1], intervals[makeNull][1]);
                        int minFirst = Math.min(intervals[start][0], intervals[makeNull][0]);
                        intervals[start][0] = minFirst;
                        intervals[start][1]=maxLast;
                        intervals[makeNull] = null;
                        start=-1;
                        makeNull=-1;
                        inner--;
                        // make sure you're merging two nodes onto the node, pointed by inner pointer
                        //So that, in next immediate iteration , same node is examined, to take care ,if any further intervals merge
                        //i,e reason i decrement inner here, so that in next iteration, inner is incremented as part of for loop and, pointing same node again.
                    }
                }
            }
        }
        System.out.println(length);
        int[][] mergeResult = new int[length][2];
        int i=0, j=0;
        for(int x[]: intervals)
        {
            if(x!=null)
            {
                for(int a:x)
                {
                    mergeResult[i][j++]=a;
                }
                i++;
                j=0;
            }
        }
        for(int[] x:mergeResult)
        {
                for(int a: x)
                    System.out.print(a+"   ");
        }
        return intervals;
    }
    public static void main(String[] args)
    {
        int arr[][] = {{4,5},{1,4},{0,1}};
        merge(arr);
        for(int[] x:arr)
        {
            if(x!=null)
            {
                for(int a: x)
                    System.out.print(a+"   ");
            }
        }
    }
}
