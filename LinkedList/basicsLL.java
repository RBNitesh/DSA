package LinkedList;

public class basicsLL {
    public static int LengthOfLL(Node head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void displayRecursively(Node head){
        if(head!=null){
            System.out.print(head.data+" ");
            displayRecursively(head.next);
        }else{
            return;
        }
    }

    public static void insert(Node prev,Node curr){
        curr.next=prev.next;
        prev.next=curr;
    }

    //creting a node
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
         }
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node e = new Node(4);
        Node f = new Node(5);
        Node g = new Node(6);
    
        System.out.println(b.data);//2
        System.out.println(a.next);//null
        a.next=b;//1-->2  3  4  5  6
        System.out.println(a.next.data);//2
        System.out.println(a.next);//LinkedList.basicsLL$Node@5f5a92bb
        System.out.println(b);//LinkedList.basicsLL$Node@5f5a92bb
        b.next=c;//1-->2-->3  4  5  6
        c.next=e;//1-->2-->3-->4  5  6
        e.next=f;//1-->2-->3-->4-->5  6
        f.next=g;//1-->2-->3-->4-->5-->6
        //1  2  3  4  5  6
        Node d =  new Node(10);
        insert(c,d);
        System.out.println(c.next.data);//10
        System.out.println(e.data);//4
        System.out.println(d.data);//4
        System.out.println(c.next.next.data);//4

        // Node temp = a;
        // while(temp!=null){
        //    System.out.print(temp.data+"  ");
        //    temp=temp.next;
        // }
          
        display(a);
        displayRecursively(a);
        System.out.println();
        System.out.println(LengthOfLL(a));
    }
}
