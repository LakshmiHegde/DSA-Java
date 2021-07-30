/*
Compare two decoded Strings
Time = O(n)
Space = O(1)
*/
package RBR_DSA.RunLengthEncoding;

public class RLEComparision {
    public String OptimizeRLE(String str){
        int n=str.length();
        String Count_str=new String();
        String result="";
        result+=str.charAt(0);
        Integer count=new Integer(0);
        for(int i=1;i<n;i++){
            if(i<n-1 && '0' <= str.charAt(i) && str.charAt(i) <= '9')
            {
                //Digit, then simply add to count string
                Count_str+=str.charAt(i);
            }
            else if(i<n-1 && Character.isAlphabetic(str.charAt(i))){
                //If char is alphabet,
                //1.check if it matches the character that's already inserted in the resultant
                //2. If it matches, then continue the scan, and add the count to the previously collected count
                if(str.charAt(i)==result.charAt(result.length()-1))
                {
                    count+=Integer.parseInt(Count_str);
                    Count_str="";
                }
                else
                {
                    count+=Integer.parseInt(Count_str);
                    Count_str="";
                    result+=count;
                    result+=str.charAt(i);
                    count=0;
                }
            }
            else if(i==n-1){
                //Last Character
                //Can be either number continuing the count
                //or can be a character
                if(Character.isAlphabetic(str.charAt(i)))
                {
                    if(str.charAt(i)==result.charAt(result.length()-1))
                    {
                        count=Integer.parseInt(Count_str)+1;//Add the current character
                        result+=count;
                    }
                    else
                    {
                        count+=Integer.parseInt(Count_str);//Add the previous character count to
                        result+=count;
                        result+=str.charAt(i);
                    }
                }
                else
                {
                    Count_str+=str.charAt(i);
                    count=Integer.parseInt(Count_str);
                    result+=count;
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        RLEComparision rc=new RLEComparision();
        String op1=rc.OptimizeRLE("A15A7A3B5D3D");
        String op2=rc.OptimizeRLE("A20B3B2D4");

        if(op1.equals(op2))
            System.out.println("Both the decoded strings are the same");
        else
            System.out.println("Both the decoded strings are not same");
    }
}
