package Stack;
import java.util.Stack;

public class consecutiveSubSeq {
    public static void findSubsequences(int[] arr){
    Stack<Integer> st = new Stack<>();
    for(int i=0; i<arr.length; i++){
        if(i==0 || st.peek()!=arr[i]){
            st.push(arr[i]);
        }
        else if(i==arr.length-1 || arr[i+1]!=st.peek()){
            st.pop();
        }
    }
    System.out.println(st);
    return;
}
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,4,4,10,10,10,5,5,5,7};
        findSubsequences(arr);
    }
}
