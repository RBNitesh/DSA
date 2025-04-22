package Sorting;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    static void display(float[] arr){
        for(float val : arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    static void bucketSort(float[] arr){
        int n=arr.length;
        //Buckets
        ArrayList<Float>[] buckets=new ArrayList[n];

        //create empty buckets
        for(int i=0; i<n; i++){
            buckets[i]=new ArrayList<>();
        }

        //add elements in our buckets
        for(int i=0; i<n; i++){
            int bucketIdx=(int) arr[i]*10;
            buckets[bucketIdx].add(arr[i]);
        }

        //sort each bucket individually
        for(int i=0; i<n; i++){
            Collections.sort(buckets[i]);//sorting method inside collection
        }

        //merge all buckets to get final sorted array
        int index=0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<buckets[i].size(); j++){
                arr[index++]=buckets[i].get(j);
            }
        }
    }
    public static void main(String[] args) {
        float[] arr={0.5f,0.30f,0.7f,0.1f,0.4f};
        System.out.println("Array before sorting:");
        display(arr);
        bucketSort(arr);
        System.out.println("Array after sorting:");
        display(arr);
    }
}
