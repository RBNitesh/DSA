package LinkedList;

public class DoublyLinkedList {
    public static class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
           this.val=val;
        }
    }

    public static void display(Node head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static void displayrev(Node tail){
        while(tail!=null){
            System.out.print(tail.val+" ");
            tail=tail.prev;
        }
        System.out.println();
    }

    public static void displayPassingAnyNode(Node temp){
        while(temp.prev!=null){
           temp=temp.prev;
        }
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        a.next=b;
        b.prev=a;
        b.next=c;
        c.prev=b;
        c.next=d;
        d.prev=c;
        d.next=e;
        e.prev=d;
        display(a);
        displayrev(e);
        displayPassingAnyNode(c);
    }
}
