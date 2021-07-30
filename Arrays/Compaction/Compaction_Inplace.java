/*
Space complexity=O(1)
Time complexity= O(n)
0's will be placed ahead of the memory aftere all the processes
Processes order in intial memory is not altered.
In-place
 */
package RBR_DSA.Compaction;
import java.util.Scanner;

public class Compaction_Inplace {
    public static void main(String[] args){
        int[] memory=new int[7];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<7;i++){
            memory[i]=sc.nextInt();
        }
        int j=-1;
        for(int i=0;i<7;i++){
            if(memory[i]!=0){
                j++;
                int temp=memory[j];
                memory[j]=memory[i];
                memory[i]=temp;
            }
        }
        for(int i:memory){
            System.out.print(i+"    ");
        }
    }
}
