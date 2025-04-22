package LinkedList;
 
public class DoublyLLImplementation {
    public static class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
           this.val=val;
        }
    }
    public static class DoublyLL{
        Node head;
        Node tail;
       public void insertAtBeg(int val){
        Node a=new Node(val);
        if(head==null){
            tail=a;
            head=a;
            return;
        }
        a.next=head;
        head.prev=a;
        head=a;
        return;
        }

        public void insertAtEnd(int val){
            Node a=new Node(val);
            if(head==null){
                insertAtBeg(val);
                return;
            }
            a.prev=tail;
            tail.next=a;
            tail=a;
            return;
        }

        public void insertAtIdx(Node head,int idx,int val){
            Node a=new Node(val);
            Node temp=head;
            if(idx==0){
                insertAtBeg(val);
                return;
            }
            int i=0;
            while(i<idx-1 && temp.next!=null){
                temp=temp.next;
                i++;
            }
        
            if(temp==tail){
                insertAtEnd(val);
                return;
            }else{
                a.next=temp.next;
                temp.next.prev=a;
                a.prev=temp;
                temp.next=a;
            }
        }

        public void deleteHead(){
            head=head.next;
            return;
        }

        public void deleteTail(){
            tail.prev.next=tail.next;
            tail=tail.prev;
            return;
        }

        public void deleteAtIdx(Node head,int idx){
            Node temp=head;
            int i=0;
            while(i!=idx){
                temp=temp.next;
                i++;
            }

            if(temp==head){
                deleteHead();
                return;
            }else if(temp.val==tail.val){
                deleteTail();
                return;
            }else{
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
                return;
            }
        }
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
           System.out.println();
           return;
        }
    }
    public static void main(String[] args) {
        DoublyLL ll=new DoublyLL();
        ll.insertAtBeg(1);
        ll.display();
        ll.insertAtBeg(2);
        ll.insertAtBeg(3);
        ll.insertAtBeg(4);
        ll.display();
        ll.insertAtBeg(5);
        ll.insertAtBeg(6);
        ll.insertAtBeg(7);
        ll.display();
        System.out.println(ll.head.val);
        System.out.println(ll.tail.val);
        ll.insertAtEnd(0);
        ll.insertAtEnd(-1);
        ll.insertAtEnd(-2);
        ll.display();
        System.out.println(ll.tail.val);
        System.out.println(ll.tail.next);
        ll.insertAtIdx(ll.head,0,10);
        ll.insertAtIdx(ll.head,1,10);
        ll.insertAtIdx(ll.head, 12, 10);
        ll.insertAtIdx(ll.head, 12, 11);
        
        ll.insertAtIdx(ll.head, 150, 10);
        ll.display();
        ll.deleteHead();//deleting head
        ll.display();
        ll.deleteTail();//deleting tail
        ll.display();
        System.out.println(ll.tail.val);
        System.out.println(ll.tail.next);
        ll.deleteAtIdx(ll.head, 11);//deleting previous node of of tail
        ll.deleteAtIdx(ll.head,11);//deleting tail
        ll.display();
    }
}
