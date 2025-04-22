package LinkedList;

public class implementation {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
           this.data=data;
        }
    }

    public static class linkedlist{
        Node head;
        Node tail;

        public void insertAtEnd(int val){
            Node temp=new Node(val);
            if(head==null){
                head=temp;
            }else{
                tail.next=temp;
            }
            tail=temp;
        }

        public void insertAtBeginning(int val){
            Node temp = new Node(val);
            if(head==null){
                tail = temp;
            }else{
                temp.next=head;
            }
            head = temp;
        }

        public void insertAtIndex(int index, int val){
            Node temp = new Node(val);
            Node curr = head;
            int count=0;
            if(index==0){
                insertAtBeginning(val);
                return;
            }
            if(index==size()){
                insertAtEnd(val);
                return;
            }
            while(count!=index-1){
                count++;
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next=temp;
            return;
        }

        public void deleteAtIndex(int index){
            Node curr = head;
            int count=0;
            if(index==0){//deleting first node and at the same time updating the head
                head=head.next;
                return;
            }
            while(count!=index-1){
                curr=curr.next;
                count++;
            }
            curr.next=curr.next.next;
            if(count==size()-1){//updating tail in case of last node is deleted
                tail=curr;
            }
        }

        public int getAt(int index){
            if(index<0 || index>=size()) return -1;
            Node curr = head;
            int count = 0;
            while(count!=index){
                curr = curr.next;
                count++;
            }
            return curr.data;
        }
        
        public void display(){
           Node curr = head;
           while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
           }
           System.out.println();
        }

        public int size(){
            Node temp = head;
            int count=0;
            while(temp!=null){
                count++;
                temp=temp.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.insertAtEnd(5);
        ll.insertAtEnd(10);
        ll.insertAtEnd(15);

        ll.display();
        System.out.println(ll.size());
        
        ll.insertAtBeginning(0);
        ll.display();
        System.out.println(ll.size());
        ll.insertAtIndex(0,2);//insertiing at beginning
        ll.display();
        ll.insertAtIndex(3,12);//inserting at index 3
        ll.display();
        ll.insertAtIndex(6, 25);//inserting at end
        ll.display();
        ll.insertAtEnd(23);
        ll.display();
        System.out.println(ll.size());
        System.out.println(ll.getAt(5));
        ll.deleteAtIndex(0);//deleting the node at beginning 
        ll.display();
        ll.deleteAtIndex(6);//deleting the node at end
        ll.display();
        ll.deleteAtIndex(3);//deleting the node at specific index
        ll.display();
        System.out.println(ll.head.data);
        System.out.println(ll.tail.data);
    }
}
