import java.util.*;

class Stack{
    List<Integer> lt;

    public Stack(){
        lt = new ArrayList<>();
    }

    public void push(int x){
       lt.add(x);
    }

    public int pop(){
        if(lt.isEmpty()) return -1;
        return lt.get(lt.size()-1);
    }

    public boolean isEmpty(){
        return lt.isEmpty();
    }

    public int size(){
        return lt.size();
    }

    public void display(){
        for(int i=0; i<lt.size(); i++)
        System.out.print(lt.get(i)+" ");
    }
}


public class DemoListImplementation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        Stack st = new Stack();
        
        for(int i=0; i<5; i++) st.push(sc.nextInt());

        st.display();
    }
}
