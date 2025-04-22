package Sorting;

import java.util.Scanner;

public class CountSort {

    static void printArray(int[] arr){
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    static int findMax(int [] arr,int n){
        int max=arr[0];
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }

    static int[] CSort(int[] arr, int n){
        int max=findMax(arr,n);
        int[] freq=new int[max+1];//declared a freq array
        
        for(int i=0; i<n; i++){
            freq[arr[i]]++;  
        }
        
        //change into prefix sum array
        for(int i=1; i<freq.length; i++){
            freq[i]=freq[i-1]+freq[i];
        }

        int[] res=new int[arr.length];//declared result array of size same as input array
    
    /* 
    //method-->1
        for(int i=0; i<freq.length; i++){
            if(i==0){
                for(int k=0; k<freq[i]; k++){
                    res[k]=i;
                }
            }else{

            for(int j=freq[i-1]; j<freq[i]; j++){
                res[j]=i;
            }
        }
    }*/
        
    //method-->2
    for(int i=arr.length-1; i>=0; i--){
        int idx=freq[arr[i]]-1;
        res[idx]=arr[i];
        freq[arr[i]]--;
        }

    return res;
}

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] arr={2,524,0,46,7,2,145,3,47};
        System.out.println("Array before sorting:");
        printArray(arr);
        int[] ans=CSort(arr,arr.length);
        System.out.println("Array after sorting:");
        printArray(ans);
     }
}
