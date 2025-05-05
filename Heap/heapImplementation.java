package Heap;

public class heapImplementation{
    static class maxHeap{
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
                System.out.println("Heap overflow exception!");
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

        //delete from the heap
        void delete(){
            if(size==0){
                System.out.println("Heap underflow exception!");
            }
            else{
                System.out.println(arr[0] + " is deleted from the heap.");
                arr[0] = arr[size-1];
                size--;
                Heapify(0);
            }
        }

        //print the heap
        void print(){
            for(int i=0; i<size; i++){
                System.out.print(arr[i] +" ");
            }
            System.out.println();
        }

        //this function maintains heap property
        void Heapify(int idx){
            if(idx < 0 || idx >= size) return;
            while(idx<size){
                int left_child = 2*idx + 1;
                int right_child = 2*idx + 2;
                //in n size heap last ele will be stored at n-1 index
                int j = right_child >= size || arr[left_child] >= arr[right_child] ? left_child : right_child;
                if(j < size && arr[j] > arr[idx]){
                    swap(arr, idx, j);
                    idx = j;
                }
                else break;
            }
        }

        //helper function to swap the val of parent node with it's child node for maintaining heap property
        void swap(int[] arr, int i, int j){
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    
    }
    public static void main(String[] args){
        maxHeap heap = new maxHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.print();
        heap.delete();
        heap.print();
    }
}