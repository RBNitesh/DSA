import java.util.Arrays;

public class CreatingArrayListType {
    public static class ArrayList{
        int[] arr = new int[5];
        int idx=0;
        int size=0;
        public void add(int n){
            if(arr.length==idx){
                int[] newArr = Arrays.copyOf(arr,arr.length*2);
                arr = newArr;
            }
            arr[idx++]=n;
            size++;
        }
        public void set(int index, int value){
            arr[index]=value;
        }
    }
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.size);
        list.add(5);
        list.add(2);
        list.add(3);
        System.out.println(list.size);
        list.set(2,5);
    }
}
