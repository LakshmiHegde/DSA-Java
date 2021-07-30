/*
Missing convict ID using Sum approach
Time= O(n)
Space =O(1)
 */
package RBR_DSA.MissingConvict;

import java.util.Scanner;

public class SumApproach {
    public static void  main(String args[]) {
        int[] convict_ids;
        System.out.println("enter number of convicts");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        convict_ids = new int[n];
        System.out.println("enter convict IDs");
        int sum = 0;
        //Sum of array
        for (int i = 0; i < n; i++) {
            convict_ids[i] = sc.nextInt();
            sum += convict_ids[i];
        }
        //Number of convicts=n, as per the rules, IDs are allocated serially from 1 to n
        //Therefore for 5 people, sum first 5 integers will be the sum of their IDs
        //Here lets find sum of first n+1 people.
        //Sum of n+1 - sum of array gives the missing term
        int actual_sum=(n+1)*(n+2)/2;
        System.out.println(sum+"    "+actual_sum);
        System.out.println("Missing Convict "+Math.abs((actual_sum-sum)));
    }
}
