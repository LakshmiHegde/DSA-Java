/*
Given integer, divide it into parts such that, the sum makes up this integer.
Among all these divisions, find the division which has max product.

Brute force
Time - 2^(val+val)
Space - O(2*val)

Dynamic
Time - O(val *val)
Space - O(val * val)
 */
package RBR_DSA.DynamicProgramming.MaxProdAmongDivisions;

public class DivisionMaxProd {
    public static int prod(int value,int c_sum)
    {
       // System.out.println("value = "+value+" c_sum = "+c_sum);
        if(c_sum == 0)
            return 1;
        if(value == 0 && c_sum !=0 )
            return 0;
        if(value > c_sum)
            return prod(value-1,c_sum);
        int Include = value * prod(value,c_sum-value);
        int Exclude = prod(value-1,c_sum);
        //System.out.println("Include "+Include+" Exclude = "+Exclude);
        return Math.max(Include,Exclude);
    }
    public static int dp(int val, int c_sum)
    {
        int ss[][]= new int[val+1][val+1];
        for(int i=0;i<=val;i++)
        {
            ss[0][i]=0;
            ss[i][0]=1;
        }
        for(int i=1;i<=val;i++)
        {
            for(int j=1;j<=val;j++)
            {
                if(i > j)//can't include this
                    ss[i][j]=ss[i-1][j];
                else
                    ss[i][j]=Math.max(i*ss[i][j-i],ss[i-1][j]);
            }
        }
        return ss[val][val];
    }
    public static void main(String[] args)
    {
        System.out.println(prod(10,10));
        System.out.println(dp(10,10));

        System.out.println(prod(4,4));
        System.out.println(dp(5,5));
    }
}
