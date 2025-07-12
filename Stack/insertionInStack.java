package Stack;

import java.util.Scanner;
import java.util.Stack;

public class insertionInStack {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the stack:");
        int n=sc.nextInt();
        System.out.println("Enter the elements:");
        for(int i=1; i<=n; i++){
            int x=sc.nextInt();
            st.push(x);
        }
        System.out.println(st);
        //insertion at bottom
        Stack<Integer> gt = new Stack<>();
        while(st.size()>0){
            gt.push(st.pop());
        }
        System.out.print("Enter the element you want to insert at bottom:");
        int element=sc.nextInt();
        gt.push(element);
        Stack<Integer> rt = new Stack<>();
        while(gt.size()>0){
            rt.push(gt.pop());
        }
        System.out.println(rt);

        //insert at index
        System.out.print("Enter the index at you want to insert:");
        int a=sc.nextInt();
        System.out.print("Enter the element you want to insert:");
        int item=sc.nextInt();
        Stack<Integer> stack=new Stack<>();
        while(rt.size()>a){
            stack.push(rt.pop());
        }
        stack.push(item);
        while(rt.size()>0){
            stack.push(rt.pop());
        }
        Stack<Integer> newSt= new Stack<>();
        while(stack.size()>0){
            newSt.push(stack.pop());
        }
        System.out.println(newSt);
    }
}
