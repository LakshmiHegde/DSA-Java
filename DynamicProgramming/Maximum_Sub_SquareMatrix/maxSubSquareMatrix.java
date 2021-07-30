package RBR_DSA.DynamicProgramming;

import sun.applet.resources.MsgAppletViewer;

public class maxSubSquareMatrix {
    public static int maxSquareSubMatrix(int[][] arr,int n,int m)
    {
        int res[][] = new int[n][m];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            res[0][i]=arr[0][i];
            if(res[0][i] >max)
                max=res[0][i];
        }
        for(int i=0;i<n;i++)
        {
            res[i][0]=arr[i][0];
            if(res[i][0] > max)
                max=res[i][0];
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(arr[i][j] == 0)
                    res[i][j]=0;
                else
                {
                    int min = Math.min(res[i][j-1],res[i-1][j]);
                    res[i][j]= Math.min(min,res[i-1][j-1]) +1;
                    if(res[i][j] > max)
                        max=res[i][j];
                }
            }
        }
        //display(res);
        return max;
    }
    public static void display(int[][] arr)
    {
        for(int[] x:arr)
        {
            for(int y:x)
                System.out.print(y+"  ");
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int[][] arr={
                {1,1,0,0,1},
                {1,0,1,1,0},
                {1,1,1,1,1},
                {1,0,1,1,1}
        };
        System.out.println(maxSquareSubMatrix(arr,4,5));

        int[][] arr2={
                {0},{0},{0},{0}
        };
        System.out.println(maxSquareSubMatrix(arr2,4,1));

        int[][] arr3={
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,0}
        };
        System.out.println(maxSquareSubMatrix(arr3,4,4));
    }
}
