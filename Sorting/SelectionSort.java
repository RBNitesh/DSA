package Sorting;

public class SelectionSort {
    
    static void printArray(int[] arr,int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
   
    static void SSort(int[] arr){
        int n=arr.length;
        for(int i=0; i<n-1; i++){
            int min_index=i;
           
                for(int j=i+1; j<n; j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
            }
            if(min_index!=i){
                int temp=arr[i];
                arr[i]=arr[min_index];
                arr[min_index]=temp;
            }
       }
       printArray(arr, arr.length);
    }
    

    public static void main(String[] args) {
    
        int[] arr = {2,1,0,4,5,0,6,7,0,3,1};
        int[] arr1={0,3,2,4,2,5,0,2,5,0,8,6,2};
        SSort(arr); 
        // SSortOnlyZero(arr1);
    }
}
