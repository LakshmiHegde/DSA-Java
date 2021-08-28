package RBR_DSA.Strings.Shuffle.Count_and_Say;

public class Count_and_Say {
    public static String countAndSay(int n) {
        if(n == 1)
            return "1";
        StringBuilder prev=new StringBuilder("1");
        n--;
        while(n>0)
        {
            n--;
            int size=prev.length();
            int i=0,cnt=1;
            int start=0;
            StringBuilder str=new StringBuilder();
            while(i<size-1)
            {

                while(i<size-1 && prev.charAt(i) == prev.charAt(i+1))
                {
                    cnt++;
                    i++;
                }
                str.append(cnt);
                str.append(prev.charAt(i));
                cnt=1;
                i++;

            }
            if(i!=size)
            {
                str.append(cnt);
                str.append(prev.charAt(i));
            }
            prev=str;
        }
        return prev.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(countAndSay(4));
    }
}
