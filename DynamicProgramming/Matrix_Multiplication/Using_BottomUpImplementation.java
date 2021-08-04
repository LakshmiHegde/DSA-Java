/*
Program to count min number of scalar multiplications while computing matrix multiplication
Time = O(n^3)
Space = O(n^2)
 */
package RBR_DSA.DynamicProgramming.Matrix_Multiplication;

public class Using_BottomUpImplementation {
    static Integer min_scalar_multiplications[][];
    static Integer split[][];
    public static int matrix_scalar_multiplication(Integer[][] matrix,int i,int j,int[] dimensions,int n)
    {
        //compute as per chain size
        for(int chain=2;chain<=n;chain++) //we have solved for problems of size 1, i,e if there is single matrix, scalar multiplications are 0, and we have initialized it.
        {
            int l=chain-1;
            //number of problems of chain size
            for(int p=0;p<n-chain+1;p++)
            {
                matrix[p][l]=Integer.MAX_VALUE;//currently, initialize the value as infinity.
                for(int k=p;k<l;k++)
                {
                    int min=matrix[p][k]+matrix[k+1][l]+(dimensions[p]*dimensions[k+1]*dimensions[l+1]);
                    if(matrix[p][l] > min)
                    {
                        matrix[p][l] =min;
                        split[p][l]=k;
                    }
                }
                l++;
            }
        }
        return matrix[i][j];
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
    public static void array_initialization(int number_of_matrices)
    {
        min_scalar_multiplications = new Integer[number_of_matrices][number_of_matrices];
        split = new Integer[number_of_matrices][number_of_matrices];
        for(int x=0;x<number_of_matrices;x++)
        {
            split[x][x]=x;
            min_scalar_multiplications[x][x]=0;
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
    public static void main(String[] args) {
        int number_of_matrices = 4;
        int dimensions[] = new int[number_of_matrices + 1];
        dimensions[0] = 10;
        dimensions[1] = 100;
        dimensions[2] = 20;
        dimensions[3] = 5;
        dimensions[4] = 80;

        array_initialization(number_of_matrices);
        System.out.println("Minimum No. Of Scalar multiplications needed = "+matrix_scalar_multiplication(min_scalar_multiplications,0,3,dimensions,number_of_matrices));
        System.out.println("Matrix paranthesis goes like this");
        display_split(0,3);

        dimensions[0] = 1;
        dimensions[1] = 2;
        dimensions[2] = 1;
        dimensions[3] = 4;
        dimensions[4] = 1;
        array_initialization(number_of_matrices);
        System.out.println("Minimum No. Of Scalar multiplications needed = "+matrix_scalar_multiplication(min_scalar_multiplications,0,3,dimensions,number_of_matrices));
        System.out.println("Matrix paranthesis goes like this");
        display_split(0,3);

    }
}
