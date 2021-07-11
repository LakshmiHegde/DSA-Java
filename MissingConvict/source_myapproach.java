/*
Space= O(n)
Time=O(n)
 */
package RBR_DSA.MissingConvict;

import java.util.Scanner;

public class source_myapproach {
    public static void  main(String args[]){
        int[] convict_ids;
        System.out.println("enter number of convicts");
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        convict_ids=new int[n];
        System.out.println("enter convict IDs");
        int present[]=new int[convict_ids.length+1];
        //Taking input parallelly you can, make entry in present array
        for(int i=0;i<n;i++)
        {
            convict_ids[i]=sc.nextInt();
            present[convict_ids[i]-1]=1;
        }
        //Checking for missing ID
        for(int i=0;i<n;i++)
        {
            if(present[i]==0)
                System.out.println("Missing Convict ID = "+(i+1));
        }

    }
}
