/*
Caesar Cipher encoding
Time - O(n), n- string length
Space - O(1)
 */
package RBR_DSA;

public class CaesarCipher {
    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuffer res=new StringBuffer();
        if(k>26)
        {
            k=k%26;
        }
        int n=s.length();
        int min_cap='A';
        int min_small='a';
        int max_cap='Z';
        int max_small='z';
        //int x='A'+2;
        //System.out.println("A= "+x);
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            //if capital
            int newch=ch+k;
            if(ch >= 'A' && ch<='Z')
            {
                if(newch <= max_cap && newch >= min_cap)
                    res.append((char)(ch+k));
                else
                {
                    newch='A'+newch-max_cap-1;
                    res.append((char)newch);
                }
            }

            else if(ch >= 'a' && ch<='z')
            {
                if(newch <= max_small && newch >= min_small)
                    res.append((char)(ch+k));
                else
                {
                    newch='a'+newch-max_small-1;
                    res.append((char)newch);
                }
            }
            else{
                res.append(ch);
            }

        }
        return new String(res);
    }
    public static void main(String[] args)
    {
        int n=100;
        String s="DNFjxo?b5h*5<LWbgs6?V5{3M].1hG)pv1VWq4(!][DZ3G)riSJ.CmUj9]7Gzl?VyeJ2dIPEW4GYW*scT8(vhu9wCr]q!7eyaoy.";
        int k=45;
        System.out.println(caesarCipher(s,k));
    }

}
