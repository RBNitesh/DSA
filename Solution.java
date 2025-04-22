import java.util.Scanner;
import java.util.Stack;
class Validator{
    boolean isValid(String s){
        Stack <Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
        char ch=s.charAt(i);
        if(ch=='(' || ch == '{' || ch == '['){
            st.push(ch);
        }else if(ch==')' || ch == '}' || ch == ']'){
            if(st.size()==0) return false;
            if((ch == ')' && st.peek()!= '(') ||(ch == '}' &&  st.peek()!= '{') ||(ch == ']' && st.peek()!= '[')){
                return false;
            }
            st.pop();
        }
    }
       return (st.size()==0);
    }
}
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Validator obj = new Validator();
        System.out.println(obj.isValid(s));
    }
}