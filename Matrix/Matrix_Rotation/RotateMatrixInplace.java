/*
Inplace rotating
time=O(n^2)
Space=O(1)
 */
package RBR_DSA.Matrix_Rotation;

public class RotateMatrixInplace {
    static void rotateby90(int matrix[][], int n)
    {
        // code here
        int cycles=n/2;
        for(int i=0;i<cycles;i++) //O(n/2)
        {
            for(int j=i;j<(n-i-1);j++) //n-1
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
        System.out.println("Rotate by 90 degree, in clockwise direction");
        display(matrix);
    }
    static void anticlockwise(int matrix[][], int n)
    {
        // code here
        int cycles=n/2;
        for(int i=0;i<cycles;i++)
        {
            for(int j=i;j<(n-i-1);j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][n-i-1];
                matrix[j][n-i-1]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[n-j-1][i];
                matrix[n-j-1][i]=temp;
            }
        }
        System.out.println("Rotate by 90 degree, in Anti-clockwise direction");
        display(matrix);
    }
    public static void display(int[][] mat)
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
        rotateby90(mat,4);

        int mat2[][] = {
                { 1, 2, 3 },
                { 5, 6, 8 },
                { 9, 11, 12}
        };
        anticlockwise(mat2,3);

        int mat3[][] = {
                { 1, 2,},
                { 9, 11}
        };
        rotateby90(mat3,2);

        int mat4[][] = {
                { 1}
        };
        rotateby90(mat4,1);

        int mat5[][] = {
                { 1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        rotateby90(mat5,5);

        int mat6[][] = {
                { 1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        anticlockwise(mat6,5);
    }
}
