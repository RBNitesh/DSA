package JavaCoolections;

import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1; i<=10; i++){
            queue.offer(i);
        }
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.peek());

        int n=5; 
        while(n<=15){
            System.out.print(queue.poll()+" ");
            n++;
        }
    }
}
