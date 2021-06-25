package RBR_DSA.TicTacToe;

import javafx.scene.AmbientLight;

import java.util.Scanner;

class TicTacToe_Players{
    char move;
    int[] row;
    int[] col;
    int AntiDiagonal;
    int Diagonal;
    static int size;

    TicTacToe_Players(int n,char ch) {
        size = n;
        move=ch;
        AntiDiagonal=0;
        Diagonal=0;
        row = new int[n];
        col = new int[n];
    }
}

public class source {
    static char board[][];
    static int size;

    public static boolean UpdateMoveToBoard(int row, int col, TicTacToe_Players p) {
        //If winner returns true, else false.
        //If invalid move then, exception is thrown and program terminates
        //System.out.println("    "+row+" "+col+"  ");
        if(row<size && col<size ){
            board[row][col]=p.move;
            if(++p.row[row] == size)
            {
                return true;
            }
            if(++p.col[col]==size){
                return true;
            }
            if(row == col && row+col == size-1)
            {
                p.Diagonal++;
                p.AntiDiagonal++;
                if(p.AntiDiagonal == size || p.Diagonal == size){
                    return true;
                }
            }
            else if(row == col){
                //Diagonal element
                //Increment diagonal pointer

                p.Diagonal++;
                if(p.Diagonal == 3){
                    return true;
                }

            }
            else if(row+col == size-1){
                //Anti Diagonal element
                //Increment Anti diagonal pointer
                p.AntiDiagonal++;
                //System.out.println("AntiDiagonal = "+p.AntiDiagonal);
                if(p.AntiDiagonal == 3){
                    return true;
                }
            }
        }
        else{
            throw new RuntimeException("Invalid Move");
        }
        //No winner
        return false;

    }
    public static void DisplayBoard(int size){

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        System.out.println("Choose the board size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        size=n;
        board=new char[n][n];
        TicTacToe_Players player1=new TicTacToe_Players(n,'X');
        TicTacToe_Players player2=new TicTacToe_Players(n,'O');
        //Game begins
        for(int i=0;i<n*n;i++){
            if(i%2==0){
                System.out.println(player1.move+" make a move ");
                DisplayBoard(n);
                System.out.println("Enter your row col coordinate, Make sure values are less than "+n);
                int row=sc.nextInt(), col=sc.nextInt();
                boolean move=UpdateMoveToBoard(row,col,player1);
                System.out.println("------------------------------------------------------------------------");
                if(move== true){
                    System.out.println("Winner is X Congratulations!!!!!!!");
                    System.exit(0);
                }
            }
            else {
                System.out.println(player2.move+" make a move ");
                DisplayBoard(n);
                System.out.println("Enter your row col coordinate, Make sure values are less than "+n);
                int row=sc.nextInt(), col=sc.nextInt();
                boolean move=UpdateMoveToBoard(row,col,player2);
                System.out.println("------------------------------------------------------------------------");
                if(move== true){
                    System.out.println("Winner is O Congratulations!!!!!!!");
                    System.exit(0);
                }
            }

        }
        System.out.println("Match is draw, better luck next time!!!");


    }
}
