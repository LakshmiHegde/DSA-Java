package RBR_DSA.LinkedListPrograms;

class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        next=null;
    }
    Node addAtBegining(Node newNode){
        newNode.next=this;
        return newNode;
    }
    void addAtEnd(Node newNode){
        Node temp=this;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void addAtPosition(int pos,Node newNode){
        Node temp=this;
        //Stand one node before the position
        for(int i=1;i<pos-1 && temp!=null;i++)
        {
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    static void Display(Node start)
    {
        Node temp=start;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class CreatingList {
    public static void main(String[] args)
    {
        Node head =new Node(10);//Head node we will refer it as start
        //I will call functions on head, so that, I am always taking start of  list as reference

        Node node1 = new Node(20);
        Node node2 = new Node(30);
        //Add these 2, to begining of list , so list looks, 30->20->10
        head=head.addAtBegining(node1);
        head=head.addAtBegining(node2);

        Node.Display(head);


        node1=new Node(11);
        node2=new Node(15);
        //Add at the end
        head.addAtEnd(node1);
        head.addAtEnd(node2);

        Node.Display(head);

        head.addAtPosition(4,new Node(24));//30-> 20-> 10-> 24-> 11-> 15
        head.addAtPosition(6,new Node(32));//30-> 20-> 10-> 24-> 11-> 32-> 15

        Node.Display(head);
    }
}
