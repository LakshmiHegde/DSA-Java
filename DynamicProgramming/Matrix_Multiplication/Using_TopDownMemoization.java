/*
Program to count min number of scalar multiplications while computing matrix multiplication
Time = O(n^3)
Space = O(n^2 + n) = O(n^2)
 */
package RBR_DSA.DynamicProgramming.Matrix_Multiplication;

public class Using_TopDownMemoization {
    static Integer min_scalar_multiplications[][];
    static Integer split[][];
    static int count=0;
    public static int matrix_scalar_multiplication(Integer[][] matrix,int i,int j,int[] dimensions)
    {
        count++;
        if(i == j)
        {
            return 0;
        }
        else if(matrix[i][j] != Integer.MAX_VALUE) //already computed
            return matrix[i][j];
        else
        {
            for(int k=i;k<j;k++)
            {
                int min=0;
                Integer final_multiplication=dimensions[i]*dimensions[k+1]*dimensions[j+1];
                if(matrix[i][k] != Integer.MAX_VALUE && matrix[k+1][j] != Integer.MAX_VALUE)
                     min=matrix[i][k]+matrix[k+1][j]+final_multiplication;
                else if(matrix[i][k] != Integer.MAX_VALUE)
                     min=matrix[i][k]+matrix_scalar_multiplication(matrix,k+1,j,dimensions)+final_multiplication;
                else if(matrix[k+1][j] != Integer.MAX_VALUE)
                    min=matrix[k+1][j]+matrix_scalar_multiplication(matrix,i,k,dimensions)+final_multiplication;
                else
                    min=matrix_scalar_multiplication(matrix,i,k,dimensions)+matrix_scalar_multiplication(matrix,k+1,j,dimensions)+final_multiplication;

                if(min<matrix[i][j])
                {
                    matrix[i][j]=min;
                    split[i][j]=k;
                }
            }
            return matrix[i][j];
        }
    }
    public static void display(Integer[][] matrix)
    {
        for(Integer x[]:matrix)
        {
            for(Integer y:x)
                System.out.print(y+"   ");
            System.out.println();
        }
    }
    public static void display_split(int i,int j)
    {
        if( i != j)
        {
            System.out.println(split[i][j]+1);
            display_split(i,split[i][j]);
        }

    }
    public static void array_initialization(int number_of_matrices)
    {
        min_scalar_multiplications = new Integer[number_of_matrices][number_of_matrices];
        split = new Integer[number_of_matrices][number_of_matrices];

        for (Integer x = 0; x < number_of_matrices; x++)
        {
            for (Integer y = 0; y < number_of_matrices; y++)
            {
                if(x == y)
                {
                    min_scalar_multiplications[x][y]=0;
                    split[y][y]=y;
                }
                else
                {
                    min_scalar_multiplications[x][y]=Integer.MAX_VALUE;
                    split[x][y]=Integer.MAX_VALUE;
                }
            }
        }
    }
    public static void main(String[] args) {
        int number_of_matrices = 4;
        int dimensions[] = new int[number_of_matrices + 1];
        dimensions[0] = 10;
        dimensions[1] = 100;
        dimensions[2] = 20;
        dimensions[3] = 5;
        dimensions[4] = 80;

        array_initialization(number_of_matrices);
        System.out.println("Minimum No. Of Scalar multiplications needed = "+matrix_scalar_multiplication(min_scalar_multiplications,0,3,dimensions));
        System.out.println("Matrix paranthesis goes like this");
        display_split(0,3);

        dimensions[0] = 1;
        dimensions[1] = 2;
        dimensions[2] = 1;
        dimensions[3] = 4;
        dimensions[4] = 1;
        array_initialization(number_of_matrices);
        System.out.println("Minimum No. Of Scalar multiplications needed = "+matrix_scalar_multiplication(min_scalar_multiplications,0,3,dimensions));
        System.out.println("Matrix paranthesis goes like this");
        display_split(0,3);


    }
}
