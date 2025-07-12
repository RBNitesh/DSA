package Heap;
import java.util.Scanner;

public class Heap_sort{
    public static void main(String[] args){
        int[] arr = {5, 4, 2, 3, 6, 7, 2, 5, 1};
        buildMaxHeap(arr);
        sort_the_heap(arr, arr.length);
        //print the arr after performing heap sort
        for(int ele : arr){
            System.out.print(ele+ " ");
        }
    }

    //function to build max heap
    private static void buildMaxHeap(int[] arr){
        int n = arr.length;

        //step_down -> O(n)
        int i = n/2-1;
        while(i >= 0){
            step_down(arr, i);
            i--;
        }  

        //step_up -> O(nlogn)
        // int i = 1;
        // while(i < n){
        //     step_up(arr, i);
        //     i++;
        // }
    }

    //function to sort the max heap
    private static void sort_the_heap(int[] arr, int size){
        while(size > 0){
            swap(arr, 0, size-1);
            size--;

            int largest = 0;
            while(largest <= (size/2)-1){
                int left_child = 2*largest + 1;
                int right_child = 2*largest + 2;
                //compare the parent with max child. If max child is greater than parent than swap it.
                int j = right_child==size || arr[left_child] > arr[right_child] ? left_child : right_child;
                if(arr[j] > arr[largest]){
                    swap(arr, largest, j);
                    largest = j;
                }
                else break;
            }
        }
    }

    //step down approach to build the heap 
    private static void step_down(int[] arr, int idx){
        int n = arr.length;
        //no child
        if(idx > n/2-1) return;

        //for max heap find the maximum from children and then compare with parent
        //for min heap find the minimum from children and then compare with parent
        int left_child = 2*idx + 1;
        int right_child = 2*idx + 2;
        int j = right_child==n || arr[left_child] > arr[right_child] ? left_child : right_child;

        if(arr[j] > arr[idx]){
            swap(arr, idx, j);
            step_down(arr, j);
        }
    }
    
    //step up approach to build the heap
    private static void step_up(int[] arr, int idx){
        int n = arr.length;
        if(idx==0) return;

        //change '>' to '<' and get the min heap
        if(arr[idx] > arr[(idx-1)/2]){
            swap(arr, (idx-1)/2, idx);
            step_up(arr, (idx-1)/2);
        }
    }

    //helper function for swapping the two elements of arr
    private static void swap(int[] arr, int i, int j){
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] -= arr[j];
    }
}