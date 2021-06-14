package RBR_DSA.PenaltyShootout;
import java.util.Scanner;
public class PenaltyShhtout {
    static char winner;
    public static int findStatusOfMatch(String status)
    {
        int availableChoiceForA , availableChoiceForB;
        availableChoiceForA=availableChoiceForB= status.length()/2;
        int hitsOfA=0, hitsOfB=0;
        int i=0;
        for(i=0;i<status.length();i++)
        {
            if(i%2==0)//First A
            {
                if(status.charAt(i)=='1')
                {
                    hitsOfA++;
                    if(hitsOfA>(hitsOfB+availableChoiceForB))
                    {
                        winner='A';
                        return i + 1;
                    }
                    availableChoiceForA--;
                }
                else{
                    availableChoiceForA--;
                    if(hitsOfB>(hitsOfA+availableChoiceForA))
                    {
                        winner='B';
                        return i + 1;
                    }
                }
            }
            else//B
            {
                if(status.charAt(i)=='1')
                {
                    hitsOfB++;
                    if(hitsOfB>(hitsOfA+availableChoiceForA))
                    {
                        winner='B';
                        return i + 1;
                    }
                }
                else
                {
                    availableChoiceForB--;
                    if(hitsOfA>(hitsOfB+availableChoiceForB))
                    {
                        winner='A';
                        return i + 1;
                    }
                }
            }
        }
        return i;
    }
    public static void main(String[] args)
    {
        String stats="100101";
        String testCase2="11111111";
        String testCase3="000000";
        String testCase4="101000";
        String testCase5="110100";
        String testCase6="101001";
        String testCase7="100111";
        int shots=findStatusOfMatch(stats);
        System.out.println(shots);

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
    }
}
