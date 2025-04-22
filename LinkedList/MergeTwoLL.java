package LinkedList;

public class MergeTwoLL {

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

    public static Node Merge1(Node head1, Node head2){
        Node temp1=head1;
        Node temp2=head2;
        Node head=new Node(100);
        Node temp=head;

        while(temp1!=null && temp2!=null){
            if(temp1.data<=temp2.data){
                Node a = new Node(temp1.data);//extra spaces are being used.
                temp.next=a;
                temp=a;
                temp1=temp1.next;
            }else{
                Node a = new Node(temp2.data);
                temp.next=a;
                temp=a;
                temp2=temp2.next;
            }
        }
        if(temp1==null){
            temp.next=temp2;
        }else{
            temp.next=temp1;
        }
       return head.next;
    }


    public static Node Merge2(Node head1, Node head2){//no extra spaces are being used.
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
       Node head1=Merge1(a,m);//extra space is used
       Node head2=Merge2(a,m);//no any extra space is used
       display(head1);
       display(head2);
    }
} 
