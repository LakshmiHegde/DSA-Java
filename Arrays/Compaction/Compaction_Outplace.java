/*
Compaction out place approach, insertion order not preserved, i,e processes are not in the same way
Space complexity=O(n)
Time complexity= O(n)
 */
package RBR_DSA.Compaction;

import java.util.Scanner;
import java.util.Arrays;



public class Compaction_Outplace {
    public static void main(String[] args){
        int[] memory=new int[7];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<7;i++){
            memory[i]=sc.nextInt();
        }
        Arrays.sort(memory);//O(nlogn)
        int[] Nonzeros=new int[7];//O(n)
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
