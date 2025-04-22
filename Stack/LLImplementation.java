package Stack;
public class LLImplementation {
    public static class Node{//user defined datatype
        private int val; 
        private Node next;
        public Node(int val){
            this.val=val;
        }
    }
    public static class Stack{//user defined data structure
        Node head=null;
        void push(int item){
            Node a = new Node(item);
            a.next=head;
            head=a;
        }
        int peek(){
            if(head==null){
                System.out.println("Stack is empty.");
                return -1;
            }
            return head.val;
        }
        int pop(){
            if(head==null){
                System.out.println("Stack is empty.");
                return -1;
            }
            int x=head.val;
            head=head.next;
            return x;
        }
        int size(){
            int size=0;
            Node temp = head;
            while(temp!=null){
              size++;
              temp=temp.next;
            }
            return size;
        }
        void displayrec(Node node){
            if(node==null) return;
            displayrec(node.next);
            System.out.print(node.val+" ");
        }
        void display(){
            if(head==null){
                System.out.println("Stack is empty.");
                return;
            }
            displayrec(head);
            System.out.println();
        }
        boolean isEmpty(){
            if(size()==0) return true;
            else return false;
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.display();
        st.peek();
        st.pop();
        st.pop();
        st.display();
        System.out.println("Size : "+st.size());
        System.out.println(st.isEmpty());
    }
}
