package RBR_DSA.ToeplitzMatrix;

public class ToeplitzMatrix {
    public  boolean isToeplitzMatrix(int[][] matrix){
        for(int row=0;row<matrix.length-1;row++){
            for(int col=0;col<matrix[row].length-1;col++){
                  if(matrix[row][col]!= matrix[row+1][col+1])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        ToeplitzMatrix t=new ToeplitzMatrix();
        int[][] testCase1= {{1,2,3},{4,5,6},{7,8,9}};
        int[][] testCase2= {{1,2,3,4,6},{5,1,2,3,4},{9,5,1,2,3}};
        System.out.println(t.isToeplitzMatrix(testCase1));
        System.out.println(t.isToeplitzMatrix(testCase2));
    }
}
