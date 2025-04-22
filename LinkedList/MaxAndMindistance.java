package LinkedList;

public class MaxAndMindistance {
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
            Node newNode=new Node(val);
            if(head==null){
                head=newNode;
                tail=newNode;
                return;
            }
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            return;
        }

        public int maxDisbtwCritPoint(){
            Node t=head.next;
            Node t2=tail.prev;
            Node firstCritPoint=null;
            Node lastCritPoint=null;
            while(firstCritPoint==null)
            if((t.val<t.prev.val && t.val<t.next.val) || (t.val>t.prev.val && t.val>t.next.val)){
                firstCritPoint=t;
            }else{
                t=t.next;
            }
            while(lastCritPoint==null){
            if((t2.val<t2.prev.val && t2.val<t2.next.val) || (t2.val>t2.prev.val && t2.val>t2.next.val)){
                lastCritPoint=t2;
            }else{
                t2=t2.prev;
            }
            }
            
            int count=0;
            while(firstCritPoint!=lastCritPoint){
                count++;
                firstCritPoint=firstCritPoint.next;
            }
            return count;
        }

        public int minDisbtwCritPoint(){
                if (head == null || head.next == null || head.next.next == null) {
                    // Less than 3 nodes, no critical points possible
                    return -1;
                }
            
                int index = 1; // Start from the second node (1-based index)
                Node t = head.next; // Start from the second node
                Node prev = head; // First node
                int firstCritical = -1; // Index of the first critical point
                int lastCritical = -1;  // Index of the last critical point
                int minDistance = Integer.MAX_VALUE;
            
                while (t.next != null) {
                    if ((t.val < prev.val && t.val < t.next.val) || (t.val > prev.val && t.val > t.next.val)) {
                        if (firstCritical == -1) {
                            firstCritical = index; // Mark the first critical point
                        } else {
                            // Calculate the distance from the last critical point
                            minDistance = Math.min(minDistance, index - lastCritical);
                        }
                        lastCritical = index; // Update the last critical point
                    }
                    prev = t;
                    t = t.next;
                    index++;
                }
            
                if (firstCritical == -1 || lastCritical == -1 || firstCritical == lastCritical) {
                    // Fewer than two critical points
                    return -1;
                }
            
                return minDistance;
        }

        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        DoublyLL ll=new DoublyLL();
        ll.insertAtBeg(3);
        ll.insertAtBeg(5);
        ll.insertAtBeg(7);//critical point
        ll.insertAtBeg(6);
        ll.insertAtBeg(5);
        ll.insertAtBeg(4);
        ll.insertAtBeg(3);//critical point
        ll.insertAtBeg(100);
        ll.display();
        int max=ll.maxDisbtwCritPoint();
        System.out.println(max);
        int min=ll.minDisbtwCritPoint();
        System.out.println(min);
    }
}
