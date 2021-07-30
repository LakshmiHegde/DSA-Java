/*
Time = O(mn)
Space = O(1)
 */
package RBR_DSA.SpiralTraversal;
import java.util.*;
public class Spiral {
    static ArrayList<Integer> spirally(int matrix[][], int r, int c)
    {
       int startrow=0,endrow=r-1, startcol=0, endcol=c-1;
       int len=matrix.length;
        ArrayList<Integer> res=new ArrayList<Integer>();
       while(startcol<endcol && startrow<endrow)
       {
           //first row
           for(int col=startcol;col<=endcol;col++)
           {
               res.add(matrix[startrow][col]);
           }

           //last column
           startrow++;
           for (;startrow<=endrow;startrow++)
           {
               res.add(matrix[startrow][endcol]);
           }

           //last row
           startrow--;
           for (int col=endcol-1;col>=startcol;col--)
           {
               res.add(matrix[startrow][col]);
           }

           //first  column
           startrow--;
           for(;startrow>=(len-endrow);startrow--)
           {
               res.add(matrix[startrow][startcol]);
           }
           startrow++;
           endrow--;
           startcol++;
           endcol--;
       }

       if(startcol == endcol && startrow == endrow)
           res.add(matrix[startcol][startcol]);
       else if(startcol!=endcol && startrow==endrow)
       {
           for(int i=startcol;i<=endcol;i++)
               res.add(matrix[startrow][i]);
       }
       else if(startcol==endcol && startrow!=endrow)
       {
           for(int i=startrow;i<=endrow;i++)
               res.add(matrix[i][startcol]);
       }
       return res;
    }
    public static void main(String args[])
    {
        int arr[][] = {
                {1,2,3},
                {3,4,5},
                {6,7,8},
                {9,10,11},
                {12,13,14}
        };
        ArrayList l=spirally(arr,5,3);
        System.out.println(l);

        int arr2[][] ={
                {1,2,3},
                {4,5,6}
            };
        l=spirally(arr2,2,3);
        System.out.println(l);

        int arr3[][] ={
                {1,2,3,4,7,10},
                {4,5,6,7,11,23},
                {7,8,9,10,-2,11}
        };
        l=spirally(arr3,3,6);
        System.out.println(l);

        int arr4[][] ={
                {1,0,3,-4,7,10},
                {-4,5,16,7,2,23},
                {7,10,9,10,-2,11},
                {1,-4,9,0,-2,11},
                {3,6,-9,12,-2,1},
                {-7,0,1,5,6,-1}
        };
        l=spirally(arr4,6,6);
        System.out.println(l);

    }

}
