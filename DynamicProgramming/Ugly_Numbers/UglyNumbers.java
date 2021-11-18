package RBR_DSA.DynamicProgramming.Ugly_Numbers;

public class UglyNumbers {
    public int nthUglyNumber(int n) {
        int dp[]=new int[n];
        dp[0]=1;
        if(n == 0 || n == 1)
            return n;
        int two_ptr=0;
        int three_ptr=0;
        int five_ptr=0;

        int i=1;

        while(i<n)
        {
            int a=dp[two_ptr] * 2;
            int b=dp[three_ptr] * 3;
            int c=dp[five_ptr] * 5;

            int minimum=Math.min(a,b);
            minimum=Math.min(minimum,c);
            dp[i]=minimum;
            if(a == minimum)
                two_ptr++;
            if(b == minimum)
                three_ptr++;
            if(c == minimum)
                five_ptr++;
            i++;
        }

        return dp[i-1];
    }
    public static void main(String[] args)
    {
        UglyNumbers u=new UglyNumbers();
        System.out.println("10th ugly number : "+u.nthUglyNumber(10));
    }
}
