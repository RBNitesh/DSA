package Stack;

import java.util.Scanner;
import java.util.Stack;

public class display {
    public static void Displayrec(Stack<Integer> stack){
        if(stack.size()==0) return;
        int top=stack.pop();
        Displayrec(stack);
        System.out.print(top+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        Displayrec(st);
        
    }
}
