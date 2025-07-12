package LinkedList;

import javax.sound.midi.MidiEvent;

public class findMidNode {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
        this.data=data;
        }
    }
    
    public static Node midElement(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null){
            if(fast.next.next==null){
                return slow;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
       Node a = new Node(1);
       Node b = new Node(2);
       Node c = new Node(3);
       Node d = new Node(4);
       Node e = new Node(5);
       Node f = new Node(6);
       a.next=b;
       b.next=c;
       c.next=d;
       d.next=e;
       e.next=f;
       
       Node Mid=midElement(a);
       System.out.println(Mid.data);
    }
}
