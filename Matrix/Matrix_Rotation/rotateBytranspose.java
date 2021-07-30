/*
ONLY APPLICABLE FOR SQUARE MATRICES
IN-PLACE
1. FIND TRANSPOSE
2. INTERCHANGE COLUMNS , first <=> last , so on.
Space- O(1)
Time = O(n*n) + O(n/2) = O(n^2)
 */
package RBR_DSA.Matrix_Rotation;

public class rotateBytranspose {
    public static void transpose(int[][] matrix,int n) //O(n2)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i<j)
                {
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
        interchangeColumns(matrix,n);
    }
    public static void interchangeColumns(int[][] matrix,int n) //O(n/2)n-number of columns
    {
        int startcol=0;
        int endcol=n-1;
        while(endcol>startcol)
        {
            for(int i=0;i<n;i++)
            {
                int temp=matrix[i][startcol];
                matrix[i][startcol]=matrix[i][endcol];
                matrix[i][endcol]=temp;
            }
            endcol--;
            startcol++;
        }
        System.out.println("Rotate by 90 degree clockwise");
        display(matrix);
    }
    public static void display(int[][] mat)//O(mn)
    {
        for(int[] x:mat)
        {
            for(int y:x)
                System.out.print(y+"   ");
            System.out.println();
        }

    }

    public static void main(String[] args)
    {
        int mat[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        transpose(mat,4);

        int arr[][] = {
                { 1, 2, 3},
                { 5, 6, 7},
                { 9, 10, 11}
        };
        transpose(arr,3);

    }

}
