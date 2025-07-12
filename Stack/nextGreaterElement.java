package Stack;
import java.util.Stack;
public class nextGreaterElement {
    public static int[] Ngb(int [] arr){
        Stack<Integer> st = new Stack<>();
        int[] res=new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            if(i==arr.length-1){
                res[i]=-1;
                st.push(arr[i]);
            }else{
                while(st.size()!=0){
                    if(st.peek() > arr[i]){
                        res[i]=st.peek();
                        st.push(arr[i]);
                        break;
                    }else{
                        st.pop();
                    }
                }
                if(st.size()==0){
                    res[i]=-1;
                    st.push(arr[i]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {10,3,5,6,13,8,8,5,7,3,2,9};
        int[] res=Ngb(arr);
        for(int a : res){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
