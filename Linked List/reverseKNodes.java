/*
given k, reverse k nodes of LL, in groups of k size
Time =O(n)
Space=O(1)

 */
package RBR_DSA.LinkedListPrograms;
class LLNode
{
    int ele;
    LLNode next;
    LLNode(int ele)
    {
        this.ele=ele;
        this.next=null;
    }
    public LLNode addBeg(LLNode newNode)
    {
        newNode.next=this;
        return newNode;
    }
    public static void display(LLNode head)
    {
        LLNode temp=head;
        while(temp!=null)
        {
            System.out.print(temp.ele+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class reverseKNodes {
    public static LLNode reverseK(LLNode head,int k)
    {
        LLNode temp=head;
        LLNode next=null,current=head,prev=null;
        int count=k;
        while(current!=null && count>0)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count--;
        }

        head=prev;//I got head of the LL, for getting this, I did first reversal seperately, and next reversals will be done on following while

        temp.next=null;
        prev=null;
        LLNode ptemp=temp;
        temp=current;
        while(current!=null)
        {
            count=k;
            while(current!=null && count>0)
            {
                next=current.next;
                current.next=prev;
                prev=current;
                current=next;
                count--;
            }

            ptemp.next=prev;
            ptemp=temp;
            prev=null;
            temp=current;

        }
        return head;
    }
    public static void main(String[] args)
    {
        LLNode node=new LLNode(10);
        LLNode node2=new LLNode(12);
        node=node.addBeg(node2);//node2 is added begining of node
        node=node.addBeg(new LLNode(23));
        node=node.addBeg(new LLNode(13));
        node=node.addBeg(new LLNode(10));
        node=node.addBeg(new LLNode(11));
        node=node.addBeg(new LLNode(50));
        LLNode.display(node);

        node=reverseK(node,2);
        LLNode.display(node);
    }
}
