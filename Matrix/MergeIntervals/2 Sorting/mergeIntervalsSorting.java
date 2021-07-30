/*
Merge intervals using sorting approach
Time = O(nlogn)
Space =  O(1)
 */
package RBR_DSA.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class mergeIntervalsSorting {
    public static void merge(Integer[][] arr)
    {
        int firstElements[] = new int[arr.length];
        Comparator<Integer[]> myComparator = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        };
        Arrays.sort(arr, myComparator); //O(nlog)

        for(int i=0;i<arr.length-1 ; i++) //O(n)
        {
            if(arr[i+1][0] >=arr[i][0] && arr[i+1][0]<=arr[i][1])
            {
                arr[i+1][0] = arr[i][0];
                arr[i+1][1] = Math.max(arr[i][1],arr[i+1][1]);
                // Since i is always moving forward, any merges to happen, it is better to keep in i+1, rather than i,
                // as i becomes unvisited next time, if you make merges in i+1, then, its next increment, i comes to i+1 location ,
                // so that, it is retracked, for any further merges.
                arr[i]=null;
            }
        }
        for(int i=0;i<arr.length;i++) //O(n)
        {
            if(arr[i] != null)
            {
                System.out.print("["+arr[i][0]+" , "+arr[i][1]+"]   ");
            }
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Integer arr[][] = {{4,5},{1,4},{0,1}};
        merge(arr);

        Integer testCase2[][] = {{1,2},{3,6},{10,20}};
        merge(testCase2);

        Integer testCase3[][] = {{1,2},{2,6},{10,20}};
        merge(testCase3);

        Integer testCase4[][] = {{6,8} , {1,9}, {2,4} , {4,7}};
        merge(testCase4);

    }
}
