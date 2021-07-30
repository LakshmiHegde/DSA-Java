/*
Constraints:
1 <= N <= 50
1 <= mat[][] <= 10000
1 <= K <= N*N
Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)


Space = O(k)
Time = O(NlogK), in worst case, if k reaches N2, still it will be O(NlogN) , but space may be O(n2)

 */
package RBR_DSA;
import java.util.PriorityQueue;
import java.util.Collections;
public class kthsmallestinmatrix {
    public static int kthSmallest(int[][]mat,int n,int k)
    {
        //code here.
        PriorityQueue<Integer> q= new PriorityQueue<Integer>(Collections.reverseOrder());
        int i=0,j=0;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                q.add(mat[i][j]);//logk
                k--;
                if(k == 0)
                {
                    break;
                }
            }
            if(k == 0)
            {
                break;
            }
        }
        j++;
        for(;j<n;j++)
        {
            int x=q.peek();
            if(mat[i][j] < x)
            {
                q.poll();//logk
                q.add(mat[i][j]);//logk
            }
        }
        i++;

        for(;i<n;i++)
        {
            for(k=0;k<n;k++)
            {
                int x=q.peek();
                if(mat[i][k] < x)
                {
                    q.poll();
                    q.add(mat[i][k]);
                }
            }
        }

        return q.peek();
    }
    public static void main(String[] args) {
        int[][] mat = {
                {9, 12, 20, 25, 35},
                {15, 17, 23, 28, 45},
                {21, 31, 38, 40, 51},
                {28, 41, 47, 52, 62},
                {38, 43, 48, 56, 65}};
        System.out .println(kthSmallest(mat,5,14));

    }
}
