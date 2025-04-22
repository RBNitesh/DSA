package NumberConversion;

public class removeDuplicate {
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
    
    public static void removeDuplicate(Node head){
        if(head==null || head.next==null) return;
        Node temp=head;
        Node curr=head.next;
        while(curr!=null){
            if(temp.data==curr.data){
                temp.next=curr.next;
                curr=temp.next;
            }else{
            temp=curr;
            if(curr==null) return;
            curr=curr.next;
            }
        }
        return;
    }

    public static Node ReverseLL1(Node head){
        if(head==null || head.next==null) {
            return head;
        }
        Node prev=head;
        Node temp=head.next;
        Node curr=head.next.next;
        Node firstNode=head;
        while(curr!=null){
            temp.next=prev;
            prev=temp;
            temp=curr;
            curr=curr.next;
        }
        temp.next=prev;
        head.next.next=head;
        head.next=null;
        head=temp;
        return head;
    }
    
    public static Node ReverseLL2(Node head){
        if(head.next==null) return head;
        Node newNode=ReverseLL2(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
    public static void main(String[] args) {
       Node a = new Node(1);
       Node b = new Node(1);
       Node c = new Node(1);
       Node d = new Node(2);
       Node e = new Node(2);
       Node f = new Node(3);
       Node g = new Node(3);
       Node h = new Node(2);
       a.next=b;
       b.next=c;
       c.next=d;
       d.next=e;
       e.next=f;
       f.next=g;
       g.next=h;
       display(a);//1 1 1 2 2 3 3 2
       removeDuplicate(a);
       display(a);//1 2 3 2
       Node head1=ReverseLL1(a);
       display(head1);//2 3 2 1
       Node head2=ReverseLL2(head1);
       display(head2);
    }
}
