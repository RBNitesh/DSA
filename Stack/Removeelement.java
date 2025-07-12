package Stack;

import java.util.Stack;

public class Removeelement {
    public static void RemoveBottomElement(Stack<Integer> st){
        Stack <Integer> newSt = new Stack<>();
        while(st.size()>1){
           newSt.push(st.pop());
        }
        st.pop();
        while(newSt.size()>0){
            st.push(newSt.pop());
        }
    }

    //remove at index
    public static void Remove(Stack<Integer> st, int idx){
        Stack<Integer> temp=new Stack<>();
        while(st.size() > idx+1){
            int top=st.pop();
            temp.push(top);
        }
        st.pop();
        while(st.size() > 0){
            int top=st.pop();
            temp.push(top);
        }
        while(temp.size()>0){
            st.push(temp.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        RemoveBottomElement(st);
        System.out.println(st);
        Remove(st, 2);
        System.out.println(st);
    }
}
