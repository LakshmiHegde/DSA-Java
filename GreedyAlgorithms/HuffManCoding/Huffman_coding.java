package RBR_DSA.GreedyAlgorithms.HuffManCoding;



import java.util.Comparator;
import java.util.PriorityQueue;

class Characters_frequency
{
    char ch;
    int freq;
    Characters_frequency(char ch,int freq)
    {
        this.ch=ch;
        this.freq=freq;
        left=null;
        right=null;
    }
    Characters_frequency left,right;
}
public class Huffman_coding {
    static int totalBits;

    public static void huffman(PriorityQueue<Characters_frequency> heap)
    {
        int n=heap.size();
        Characters_frequency Node=null;
        for(int i=0;i<n-1;i++)
        {
            Characters_frequency left=heap.poll();
            Characters_frequency right=heap.poll();
            int sumfreq=left.freq + right.freq;
            Node=new Characters_frequency('\0',sumfreq);
            Node.left=left;
            Node.right=right;
            heap.add(Node);
        }
        System.out.println("The encoded pattern for characters ");
        printCodes(Node,"");
    }
    public static void printCodes(Characters_frequency head,String s)
    {
        if(head.left == null && head.right == null && Character.isAlphabetic(head.ch))
        {
            System.out.println(head.ch+" : "+s);
            totalBits+=(s.length()*head.freq);
            return;
        }
        printCodes(head.left,s+"0");
        printCodes(head.right,s+"1");
    }
    public static void main(String[] args)
    {
        Characters_frequency[] arr=new Characters_frequency[7];
        arr[0]=new Characters_frequency('a',40);
        arr[1]=new Characters_frequency('b',30);
        arr[2]=new Characters_frequency('c',20);
        arr[3]=new Characters_frequency('d',5);
        arr[4]=new Characters_frequency('e',3);
        arr[5]=new Characters_frequency('f',2);

        PriorityQueue q=new PriorityQueue(7,new Comparator<Characters_frequency>(){
            public int compare(Characters_frequency o1, Characters_frequency o2) {
                int f1=o1.freq;
                int f2=o2.freq;
                if(f1 < f2)
                    return -1;
                else if(f1 > f2)
                    return 1;
                else
                    return 0;
            }
        });
        int filesize=0;
        for(int i=0;i<6;i++)
        {
            q.add(arr[i]);
            filesize+=arr[i].freq;
        }

        huffman(q);
        System.out.println("Total bits needed to represent file "+filesize+" is "+totalBits);
        System.out.println("On average, a character takes "+totalBits/(float)filesize);
    }
}
