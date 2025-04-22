package Stack;

import java.util.Scanner;
import java.util.Stack;

public class DemoInfix1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String s = sc.nextLine();
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if((int)ch <= 57 && (int)ch >= 48){
                num.push((int)ch - 48);
            }else{
                if(op.size()==0){
                    op.push(ch);
                }else{
                    if(ch=='+' || ch=='-'){
                        while(op.size()>0){
                        int val2=num.pop();
                        int val1=num.pop();
                        if(op.peek()=='-') num.push(val1-val2);
                        else if(op.peek()=='+') num.push(val1+val2);
                        else if(op.peek()=='*') num.push(val1*val2);
                        else if(op.peek()=='/') num.push(val1/val2);
                        op.pop();
                        }
                        op.push(ch);
                    }
                    else if(ch=='*' || ch=='/'){
                        if(op.peek()=='-' || op.peek()=='+') op.push(ch);
                        else if(op.peek()=='*' || op.peek()=='/'){
                            int val2=num.pop();
                            int val1=num.pop();
                            if(op.peek()=='*') num.push(val1*val2);
                            else if(op.peek()=='/') num.push(val1/val2);
                            op.pop();
                            op.push(ch);
                        }
                    }
                }
            }
        }
        while(num.size()>1){
            int val2=num.pop();
            int val1=num.pop();
            
            if(op.peek()=='-'){
                int val=val1-val2;
                num.push(val);
            }
            else if(op.peek()=='+'){
                int val=val1+val2;
                num.push(val);
            }
            else if(op.peek()=='*'){
                int val=val1*val2;
                num.push(val);
            }
            else if(op.peek()=='/'){
                int val=val1/val2;
                num.push(val);
            }
            op.pop();
        }
        System.out.println(num.peek());
    }
}
