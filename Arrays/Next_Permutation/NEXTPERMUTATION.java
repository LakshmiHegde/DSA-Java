/*
Next permutation of given integer
Time = O(count), count = number of digits in an integer
Space = O(1), created, arr of size 10, to hold increasing range elements/digits, which doesn't depend on i/p size,
because, constraint was that, input n goes upto 2^31,
2^31 = 2147483648, has 10 digits in it,
therefore max i need that size array, to hold the digits, when digits in number are in descending order. ex: 7890
 */
package RBR_DSA.ArrayProblems;

public class NEXTPERMUTATION {
        public static int solve(int n) {
            int temp=n;
            int digit;
            int[] arr={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
            int last=-1;
            digit = temp%10;
            arr[++last]=digit;
            temp=temp/10;
            int min=Integer.MAX_VALUE;
            int minInd=0;
            while(temp != 0)
            {
                digit = temp%10;
                if(arr[last] > digit)
                {
                    int i=0;
                    while(arr[i] != -1)
                    {
                        if(arr[i] > digit)
                        {
                            min=arr[i];
                            minInd=i;
                            break;
                        }
                        i++;
                    }
                    break;
                }
                arr[++last]=digit;
                temp=temp/10;
            }
            if(temp == 0)
            {
                int i=0;
                while(arr[i] != -1)
                {
                    temp=temp*10 + arr[i];
                    i++;
                }
                return temp;
            }
            temp = temp - digit + min;
            arr[minInd]=digit;
            int i=0;
            while(arr[i] != -1)
            {
                temp=temp*10 + arr[i];
                i++;
            }
            return temp;
        }
    public static void main(String[] args)
    {
        System.out.println(solve(383));
        System.out.println(solve(23564));
    }
}
