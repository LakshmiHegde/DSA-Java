/*
Space complexity=O(n)
Time complexity= O(n)
 */
package RBR_DSA.Compaction;

import java.util.Scanner;
import java.util.Arrays;



public class secondApproach {
    public static void main(String[] args){
        int[] memory=new int[7];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<7;i++){
            memory[i]=sc.nextInt();
        }
        Arrays.sort(memory);
        int[] Nonzeros=new int[7];
        int j=0;
        for(int i:memory){
            if(i!=0){
                Nonzeros[j++]=i;
            }
        }
        //copy zeros next to non zeros array
        for(int i:memory){
            if(i==0){
                Nonzeros[j++]=i;
            }
        }
        for(int i:Nonzeros){
            System.out.print(i+"    ");
        }
    }
}
