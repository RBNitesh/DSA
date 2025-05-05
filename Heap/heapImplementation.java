package Heap;

class maxHeap{
    int[] arr;
    int size;
    int total_size;
    maxHeap(int n){
        arr = new int[n];
        size = 0;
        total_size = n;
    }

    //insert in the heap
    void insert(int val){
        if(size >= total_size){
            System.out.println("Heap has reached it's maximum size.");
        }
        else{
            arr[size] = val;
            System.out.println(arr[size] + " is inserted in the heap.");
            int i = size;
            //maintains max heap property 
            while(i > 0 && arr[(i-1)/2] < arr[i]){
                swap(arr, (i-1)/2, i);
                i = (i-1)/2;
            } 
            //increase the size
            size++;
        }
    }

    //print the heap
    void print(){
        for(int node : arr){
            System.out.print(node +" ");
        }
        System.out.println();
    }
    //helper function to swap the val of parent node with it's child node for maintaining heap property
    void swap(int[] arr, int i, int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

}
public class heapImplementation{
    public static void main(String[] args){
        maxHeap obj = new maxHeap(5);
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(5);
        obj.insert(6);
        obj.print();
    }
}