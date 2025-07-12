package LinkedList;

public class nthNodeFromEnd {
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
   
    public static Node nthNodeFromEnd1(Node head, int n){
        int size=0;
        Node curr=head;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        int index=size-n;
        curr=head;
        for(int i=0; i<=index-1; i++){
            curr=curr.next;
        }
        return curr;
    }

    public static Node nthNodeFromEnd2(Node head, int n){
        Node slow=head;
        Node fast=head;

        for(int i=1; i<=n; i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public static Node deleteNthnodeFromEnd(Node head, int n){
        Node slow=head;
        Node fast=head;
        
        for(int i=1; i<=n; i++){
            fast=fast.next;
        }
        if(fast==null){
            head=head.next;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        Node node1=nthNodeFromEnd1(a,2);//a is head node.Second from last is d, so it will return d.
        System.out.println(node1.data);//4
        Node node2=nthNodeFromEnd2(a,3);//3rd node from last is c.So, we are expecting that this will return c.
        System.out.println(node2.data);//3
        display(a);
        deleteNthnodeFromEnd(a,2);//this will remove the 3rd node from end.
        display(a);
        a=deleteNthnodeFromEnd(a,4);//this will remove the 3rd node from end.  
        display(a);     
    }
}
