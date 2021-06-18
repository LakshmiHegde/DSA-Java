package RBR_DSA;

public class CountingBits {
    public static int[] countBits(int n)
    {
        int res[] = new int[n+1];
        int mirror =1;
        res[0]=0;
        for(int i=1; i<=n;i++)
        {
            int m=mirror;
            int j=0;
            while(i<=n && m>0)
            {
                res[i++]=res[j++]+1;
                m--;
            }
            mirror= mirror<<1;
            i--;
        }
        return res;
    }
    public static void main(String[] args)
    {
        int arr[]=new int[8];
        arr=countBits(8);
        System.out.println("Number of bits set in binary representation of decimal numbers from 0 to 8");
        System.out.print("[ ");
        for(int x:arr)
            System.out.print(x+" , ");
        System.out.print(" ]");

        int testCase2[]=new int[5];
        testCase2=countBits(35);
        System.out.println("\nNumber of bits set in binary representation of decimal numbers from 0 to 35");
        System.out.print("[ ");
        for(int x:testCase2)
            System.out.print(x+" , ");
        System.out.print(" ]");
    }
}
