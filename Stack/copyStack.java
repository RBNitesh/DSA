package Stack;

import java.util.Scanner;
import java.util.Stack;

public class copyStack {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the stack:");
        int n=sc.nextInt();
        Stack<Integer> gt=new Stack<>();
        Stack<Integer> rt=new Stack<>();
        System.out.println("Enter the elements:");
        for(int i=1; i<=n; i++){
            int x=sc.nextInt();
            st.push(x);
        }
        System.out.println(st);
        while(st.size()>0){
            gt.push(st.pop());
        }
        while(gt.size()>0){
            rt.push(gt.pop());
        }
        System.out.println(rt);
    }
}
