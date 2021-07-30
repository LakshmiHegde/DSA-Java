/*
Decode the encoded String
time=O(n)
Space=O(1)
 */
package RBR_DSA.RunLengthEncoding;

public class Decode_String {

    public void Decode(String str){
        int n=str.length();
        String Count_str=new String();
        char key=str.charAt(0);
        Integer count=new Integer(0);
        for(int i=1;i<n;i++)
        {
            //System.out.println(i);
            if(i<n-1 && '0' <= str.charAt(i) && str.charAt(i) <= '9'){
                Count_str+=str.charAt(i);
            }
            else if(i==n-1){
                //last character
                //System.out.println("entered"+i);
                Count_str+=str.charAt(i);
                count=Integer.parseInt(Count_str);
                for(int j=0;j<count;j++)
                    System.out.print(key);
            }
            else
            {//character
                count=Integer.parseInt(Count_str);
                for(int j=0;j<count;j++)
                {
                   System.out.print(key);
                }
               // System.out.println("printed "+key+"      "+i+"     "+count+"     "+Count_str);
                Count_str="";
                count=0;
                key=str.charAt(i);
                //System.out.println("exit "+i+"   "+key+"  ");
            }

        }
        System.out.println();
    }
    public static void main(String[] args){
        EncodedStringToString e=new EncodedStringToString();
        e.Decode("A10B2d5c10");
        e.Decode("A2A1B1C1D1");
    }
}
