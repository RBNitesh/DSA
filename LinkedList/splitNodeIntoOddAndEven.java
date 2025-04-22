package LinkedList;

import java.lang.classfile.components.ClassPrinter.Node;

public class splitNodeIntoOddAndEven   {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }
    
    public static void display(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static Node Merge(Node head1, Node head2){//no extra spaces are being used.
        Node temp1=head1;
        Node temp2=head2;
        Node head=new Node(100);
        Node temp=head;

        while(temp1!=null && temp2!=null){
            if(temp1.data<=temp2.data){
               temp.next=temp1;
               temp=temp1;
               temp1=temp1.next;
            }else if(temp2.data<temp1.data){
               temp.next=temp2;
               temp=temp2;
               temp2=temp2.next;
            }
        }
        if(temp1==null){
            temp.next=temp2;
        }else if(temp2==null){
            temp.next=temp1;
        }
       return head.next;
    }

    public static Node oddEven(Node head) {
        Node curr1=head;
        Node curr2=head.next;
        Node temp1=curr1;
        Node temp2=curr2;
        if(head==null || head.next==null || head.next.next==null) return head;
        while(temp1.next!=null && temp2.next!=null){
            temp1.next=temp1.next.next;
            temp1=temp1.next;
            temp2.next=temp2.next.next;
            temp2=temp2.next;
        }
        temp1.next=curr2;
        return head;
    }

    public static void main(String[] args) {
       Node a = new Node(1);
       Node b = new Node(3);
       Node c = new Node(5);
       Node d = new Node(7);
       
       a.next=b;
       b.next=c;
       c.next=d;
       display(a);

       Node m = new Node(0);
       Node n = new Node(2);
       Node o = new Node(6);
       Node p = new Node(8);
       m.next=n;
       n.next=o;
       o.next=p;
       display(m);
       Node head=Merge(a,m);
       display(head);//printing LL after merging the two seprate LL.
       Node newhead=oddEven(head);//keeping odd and even index value together.
       display(newhead);
       

    }
} 

