package Heap;

import java.util.Scanner;

public class Heap_sort{
    public static void main(String[] args){
        int[] arr = {5, 4, 2, 3, 6, 7, 2, 5, 1};
        heap_sort(arr);
        for(int ele : arr){
            System.out.print(ele+ " ");
        }
        System.out.println();
    }

    private static void heap_sort(int[] arr){
        int n = arr.length;
        int i = 1;
        while(i < n){
            Heapify(arr, i);
            i++;
        }
    }

    private static void Heapify(int[] arr, int idx){
        int n = arr.length;
        if(idx==0) return;

        //change '<' to '>' and get the max heap
        if(arr[idx] < arr[(idx-1)/2]){
            swap(arr, (idx-1)/2, idx);
            Heapify(arr, (idx-1)/2);
        }
    }

    private static void swap(int[] arr, int i, int j){
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] -= arr[j];
    }
}