package Stack;
import java.util.Stack;
class MinStack{
    Stack<Integer> st = new Stack();
    int min=Integer.MAX_VALUE;
    public void push(int val){
        if(st.size()==0){
           st.push(val);
           min=val;
        }else if(val>=min){
            st.push(val);
        }else if(val<min){
            st.push(2*val-min);
            min=val;
        }
    }
    public void pop(){
        if(st.size()==0) return;
        else if(st.peek()>=min){
            st.pop();
        }else if(st.peek()<min){
            min=2*min-st.peek();
            st.pop();
        }
    }
    public int top(){
        if(st.size()==0) return -1;
        else if(st.peek()>=min){
            return st.peek();
        }else if(st.peek()<0){
            return min;
        }
        return -1;
    }
    public int getMin(){
        if(st.size()==0) return -1;
        return min;
    }
}
public class DemoMinStack {
    public static void main(String[] args) {
    MinStack obj = new MinStack();
      obj.push(-2);
      obj.push(0);
      obj.push(5);
      obj.push(-3);
      System.out.println(obj.getMin());
      obj.pop();
      System.out.println(obj.top());
      System.out.println(obj.getMin());
    }           
}
