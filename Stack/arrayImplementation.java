package Stack;

public class arrayImplementation {
    public static class Stack{
        int[] arr = new int[10];
        int idx=0;
        public void push(int a){
            if(idx==arr.length){
                System.out.println("Stack is full.");
                return;
            }
            arr[idx++]=a;
        }
        public int peek(){
            if(idx==0){
                System.out.println("Stack is Empty.");
                return -1;
            }
            return arr[idx-1];
        }
        public int pop(){
            if(idx==0){
                System.out.println("Stack is Empty.");
                return -1;
            }
            int n=arr[idx-1];
            arr[idx-1]=0;
            idx--;
            return n;
        }
        public boolean isEmpty(){
            if(idx==0) return true;
            return false;
        }
        public boolean isFull(){
            if(idx==arr.length) return true;
            return false;
        }
        int size(){
            return idx;
        }
        public void display(){
            if(idx==0){
                System.out.println("Stack is Empty.");
                return;
            }
            for(int i=0; i<idx; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.display();
        st.peek();
        st.pop();
        st.pop();
        st.display();
        System.out.println("Size : "+st.size());
        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
        
    }
}
