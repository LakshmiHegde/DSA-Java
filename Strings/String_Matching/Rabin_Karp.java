/*
String matching algorithm, with hashing.
Time = in worst case, O(mn), if every string has been hashed to same bucket, and requires for loop for comparision to cross verify
Though the chances of hashing to same bucket is N/q,
For N/q times, I need for loop running for O(m) time, therefore O(nm/q), in worst case,
n can be 10^6, m can be 10^5
Since q is integer, it takes 10^9 val, thereby nm/q comes to constant on substituting values.
Therefore chances are very fewer,
On average, O(n+m), since n is bigger, O(n)

Space = O(1)
 */
package RBR_DSA.Strings.String_Matching;

public class Rabin_Karp {
    public static void match(String text,String pattern,int q)
    {
        int i=0,m=pattern.length(),n=text.length();
        int t=0,p=0,last_radix=1;
        for(i=0;i<m-1;i++)
            last_radix=(last_radix*256)%q;
        for(i=0;i<m;i++) //O(m)
        {
            t=(t*256 + (text.charAt(i))) % q;
            p=(p*256 + (pattern.charAt(i))) % q;

        }
        while(i<n)//O(n)
        {
            if( p==t)
            {
                int txt_ind=i,k=0;
                for(k=0;k<m;k++)
                {
                    if(text.charAt(txt_ind-m) != pattern.charAt(k))
                    {
                        break;
                    }
                    txt_ind++;
                }
                if(k == m)
                {
                    System.out.println(" Matched "+text+" "+pattern);
                    break;
                }
            }
            t=((t - (text.charAt(i-m)*last_radix) )*256 + (text.charAt(i)))%q;
            if(t<0)
                t+=q;
            i++;
        }
        //System.out.println("Didnt match");
    }
    public static void match_bin(String text,String pattern,int q)
    {
        int i=0,m=pattern.length(),n=text.length();
        int t=0,p=0,last_radix=1;
        for(i=0;i<m-1;i++)
            last_radix=(last_radix*2)%q;
        for(i=0;i<m;i++)
        {
            t=(t*2 + (text.charAt(i))) % q;
            p=(p*2 + (pattern.charAt(i))) % q;

        }
        while(i<n)
        {
            if( p==t)
            {
                int txt_ind=i,k=0;
                for(k=0;k<m;k++)
                {
                    if(text.charAt(txt_ind-m) != pattern.charAt(k))
                    {
                        break;
                    }
                    txt_ind++;
                }
                if(k == m) {

                    System.out.println(" match");
                    break;
                }
            }
            t=((t - (text.charAt(i-m)*last_radix) )*2 + (text.charAt(i)))%q;
            if(t<0)
                t+=q;
            i++;
        }
        //System.out.println("Didnt match");
    }
    public static void main(String[] args)
    {
        match("AABAACAADAABAABA","AABAC",101);
        match("THIS IS A TEST TEXT","TEST",1234);
        match_bin("10101","1101",3);
    }
}
