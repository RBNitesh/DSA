package LinkedList;
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head1) {
        Node head2=new Node(100);
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null){
         Node node=new Node(temp1.val);
         temp2.next=node;
         temp2=temp2.next;
         temp1=temp1.next;
        }
        head2=head2.next;
        temp1=head1;
        temp2=head2;
        Node newNode=new Node(100);
        Node t=newNode;
        while(temp1!=null && temp2!=null){
         t.next=temp1;
         temp1=temp1.next;
         t=t.next;
         t.next=temp2;
         temp2=temp2.next;
         t=t.next;
        }
        temp1=head1;
        temp2=head2;
        while(temp1!=null && temp2!=null){
        if(temp1.random==null){temp2.random=null;}
        else{
        temp2.random=temp1.random.next;
        temp1=temp1.next.next;
        temp2=temp2.next.next;
        }
        }
        temp1=head1;
        temp2=head2;
        while(temp1!=null){
            temp1.next=temp2.next;
            temp1=temp1.next;
            if(temp1==null) break;
            temp2.next=temp1.next;
            if(temp2.next==null) break;
            temp2=temp2.next;
           }
        return head2;
    }
}
public class Demo{
    public static void display(Node head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a=new Node(7);
        Node b=new Node(13);
        Node c=new Node(11);
        Node d=new Node(10);
        Node e=new Node(1);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        a.random=null;
        b.random=a;
        c.random=e;
        d.random=c;
        e.random=a;
        display(a);
        Solution obj=new Solution();
        Node head=obj.copyRandomList(a);
        display(head);
    }
}