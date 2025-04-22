package JavaCoolections;

import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack <Integer> box=new Stack<>();
        for(int i=1; i<=10; i++){
            box.push(i);
        }
        System.out.println(box);
        for(int i=1; i<=10; i++){
            System.out.print(box.search(i)+" ");
        }
        System.out.println();
        int n=1;
        while(n<=10){
            System.out.print(box.peek()+" ");
            n++;
        }
        System.out.println();
        System.out.println("After peeking all the elements:"+box);
        int m=1;
        while(m<=10){
            System.out.print(box.pop()+" ");
            m++;
        }
        System.out.println();
        System.out.println("After poping all the element:"+box);
        System.out.println("is box empty:"+box.isEmpty());
    }
}
