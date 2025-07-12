package Stack;

import java.util.Scanner;
import java.util.Stack;
public class balancedBracket {
    static boolean isBalanced(String s){
        Stack<Character> st = new Stack<>();
        int idx=0;
        while(idx<=s.length()-1){
            if(s.charAt(idx)=='('){
                idx++;
                st.push('(');
            }
            else if(s.charAt(idx)==')'){
                idx++;
                if(st.size()==0) return false;
                st.pop();
            }
        }
        return (st.size()==0);
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter string:");
    String s=sc.nextLine();
    System.out.println(isBalanced(s));
    }
}
