/*
time = O(4^mn)
space = O(mn)
 */
package RBR_DSA.Backtracking;

public class ratInMaze {
        public static boolean isValid(int i,int j,int n,int[][] maze)
        {
            return (i>=0 && i<n && j>=0 && j<n && maze[i][j]==1);//check if current pos where you are is a valid pos in maze, and also check, if you can move from this, i,e make sure  this is a valid block.
        }
        public static void Solvemaze(int[][] maze,int[][] visited,int n,int i,int j,String s)
        {

            if(i==n-1 && j==n-1 && maze[i][j]==1)
            {
                System.out.println(s);
                return;
            }
            //down
            if(i+1 < n && visited[i+1][j] == 0 && maze[i+1][j] ==1)
            {
                visited[i][j]=1;
                Solvemaze(maze,visited,n,i+1,j,s+"D");
                visited[i][j]=0;
            }
            //left
            if(j-1 >= 0 && visited[i][j-1] == 0 && maze[i][j-1] ==1)
            {
                visited[i][j]=1;
                Solvemaze(maze,visited,n,i,j-1,s+"L");
                visited[i][j]=0;
            }
            //right
            if(j+1 < n && visited[i][j+1] == 0 && maze[i][j+1] ==1)
            {
                visited[i][j]=1;
                Solvemaze(maze,visited,n,i,j+1,s+"R");
                visited[i][j]=0;
            }
            //Up
            if(i-1 >= 0 && visited[i-1][j] == 0 && maze[i-1][j] ==1)
            {
                visited[i][j]=1;
                Solvemaze(maze,visited,n,i-1,j,s+"R");
                visited[i][j]=0;
            }
        }
        public static void main(String[] args)
        {
            int maze[][]={
                    {1,0,0,0},
                    {1,1,0,0},
                    {1,1,0,1},
                    {0,1,1,1}
            };
            int visited[][] ={
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            };
            Solvemaze(maze,visited,4,0,0,"");
        }
}
