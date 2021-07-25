package RBR_DSA.MaxKProduct;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxKProduct {
    public int maxProduct(int[] arr,int k){
            PriorityQueue<Integer> q=new PriorityQueue<Integer>();
            //Add k elements to min heap
            for(int i=0;i<k;i++)
            {
                q.add(arr[i]);
            }
            for(int i=k;i<arr.length;i++)
            {
                if(arr[i]>q.peek()){
                    //This is greater than one element in heap, therefore it is eligible candidate for product to be maximum
                    //Therefore, use it
                    q.poll();//O(1)
                    q.add(arr[i]);//O(log k), as heap size is k.
                }
            }
            //I have top k elements in heap now.So lets product it and return the result
            int result=1;
            for(Integer x:q){
                result*=x;
            }
            return result;
    }
    public static void main(String[] args){
        MaxKProduct m=new MaxKProduct();
        int k;
        int arr[]={12,9,20,30,2,1,10,30,29,10,3,26,2,5,7,11,13};
        System.out.println("Enter K, which is to be less than "+arr.length);
        Scanner sc=new Scanner(System.in);
        k=sc.nextInt();
        if(k>arr.length)
        {
            throw new IllegalArgumentException("Invalid value of K");
        }

        System.out.println("\nProduct of max "+k+" integers is "+m.maxProduct(arr,k));
    }
}
