package Sorting;
public class QSort{
    static void display(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int st, int end){
        int pivot = arr[st];
        int i=st+1; int j=end;
        while(i<=j){
            while(i<=end && arr[i]<=pivot){
                i++;
            }
            while(j>=0 && arr[j]>pivot){
                j--;
            }
            if(i < j){
            swap(arr, i, j);
            }
        }
        swap(arr, st, j);
        return j;        
    }
        
           
        
    static void QuickSort(int[] arr, int st, int end){
        if(st>=end){ return;}
        else{
        int pi=partition( arr, st, end);
        QuickSort(arr, st, pi-1);
        QuickSort(arr, pi+1, end);
        }
    }
    public static void main(String[] args) {
        int[] arr={92,0,6,5,0,2,4,6,0,1,9};
        System.out.println("Array before sorting:");
        display(arr);
        System.out.println("Array after sorting:");
        QuickSort(arr ,0 ,arr.length-1);
        display(arr);
    }
}