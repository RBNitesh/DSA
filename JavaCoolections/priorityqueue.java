package JavaCoolections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class priorityqueue {
    public static void main(String[] args) {
        Queue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> qr=new PriorityQueue<>();
        for(int i=1; i<=10; i++){
            pq.offer(i);
            qr.offer(i);
        }
        System.out.println(pq);//max heap
        System.out.println(qr);//min heap
    }
}
