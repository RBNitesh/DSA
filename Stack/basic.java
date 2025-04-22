package Stack;

import java.util.Stack;

import Array.sortSuareOfNum;

public class basic {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        System.out.println(st.isEmpty());
        st.push(1);
        st.push(2);
        st.push(5);
        System.out.println(st.isEmpty());
        System.out.println(st.peek());
        System.out.println(st);
        st.pop();
        System.out.println(st);
        int n=st.size();
        System.out.println(n);
        while(st.size()>1){
            st.pop();
        }
        System.out.println(st.peek());
    }
}
