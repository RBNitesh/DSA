import java.util.*;

class Queue{
    class Node{
        Node next;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    Node front, rear;
    public Queue(){
        
    }

    public void add(int val){
        Node node = new Node(val);
        if(front==null){
            front = node;
            rear = node;
        } 
        else{
            front.next = node;
            front = front.next;
        }    
    }

    public int poll(){
        if(rear==null) return -1;
        else{
            int popedVal = rear.val;

            Node temp = rear.next;
            rear.next = null;
            rear = temp;

            return popedVal;
        }
    }

    public boolean isEmpty(){
        return rear==null;
    }
}

public class DemoImplementation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        Queue q = new Queue();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            q.add(sc.nextInt());
        }

        while(!q.isEmpty()){
            System.out.print(q.poll()+" ");
        }
    }
}