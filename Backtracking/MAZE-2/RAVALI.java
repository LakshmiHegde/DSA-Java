/*

Time = 2^mn
Space= O(max(m,n)), rec stack
 */
package RBR_DSA;
import java.util.*;
public class RAVALI {
    static int cnt=0;
    static boolean ways(char[][] maze,int i,int j, int r,int c)
    {
        System.out.println("Call ("+i+","+j+")");
        if(i == r-1 && j == c-1 && maze[i][j] != '*')
        {
            cnt++;
            System.out.println("enter cnt "+cnt);
            return true;
        }
        boolean down=false, right=false;
        if(i<r && j<c  && maze[i][j] != '*' && ways(maze,i+1,j,r,c) == true)
        {
            down=true;
        }
        if(j<c && i<r && maze[i][j] != '*' && ways(maze,i,j+1,r,c) == true)
        {
            right= true;
        }
        return down||right;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
            int row,col;
            System.out.println("Enter row col");
            row=sc.nextInt();
            col=sc.nextInt();

            System.out.println("Enter "+(row*col)+" values");
            char way[][]=new char[row][col];
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                    way[i][j]=sc.next().charAt(0);
            }

            ways(way,0,0,row,col);
            System.out.println(cnt);



    }
}
