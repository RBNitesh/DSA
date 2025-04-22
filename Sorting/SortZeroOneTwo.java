package Sorting;

public class SortZeroOneTwo {
    static void display(int[] arr){
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }
    
    static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void Sort(int[] arr){
        int n=arr.length;
        int low=0;
        int mid=0;
        int high=n-1;
        
        while(mid<=high){
        if(arr[mid]==0){
            swap(arr,low,mid);
            low++;
            mid++;
        }
        if(arr[mid]==1){
            mid++;
        }
        if(arr[mid]==2){
            swap(arr, mid, high);
            high--;
        }
    }
}
    public static void main(String[] args) {
        int[] arr={2,2,1,1,0,0,1,2,0,1};
        Sort(arr);
        display(arr);
    }
}
