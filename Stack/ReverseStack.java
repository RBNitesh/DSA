package Stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    public static void Reverse(Stack<Integer> st){
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(st.size()>0){
            s1.push(st.pop());
        }
    
        while(s1.size()>0){
            s2.push(s1.pop());
        }

        while(s2.size()>0){
            st.push(s2.pop());
        }
    }

    public static void ReverseusingArr(Stack<Integer> st){
        int n=st.size();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=st.pop();
        }

        for(int i=0; i<n; i++){
            st.push(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(4);
        st.push(5);
        System.out.println(st);
        Reverse(st);
        System.out.println(st);
        ReverseusingArr(st);
        System.out.println(st);
    }
}
