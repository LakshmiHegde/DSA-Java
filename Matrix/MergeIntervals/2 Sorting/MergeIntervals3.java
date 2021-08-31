/*
Time = O(nlogn)
Space = O(n)
 */
package RBR_DSA.MergeIntervals;
import java.util.*;
public class MergeIntervals3 {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int x=o1[0];
                int y=o2[0];
                if(x<y)
                    return -1;
                if(x>y)
                    return 1;

                return 0;
            }
        });
        ArrayList<int[]> l=new ArrayList<int[]>();

        int[] first=intervals[0];
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0] <= first[1])
            {
                first[1]=Math.max(intervals[i][1],first[1]);
            }
            else
            {
                l.add(first);
                first=intervals[i];
            }
        }
        l.add(first);
        int[][] res=new int[l.size()][2];
        for(int i=0;i<l.size();i++)
        {
            res[i]=l.get(i);
        }
        return res;
    }

}
