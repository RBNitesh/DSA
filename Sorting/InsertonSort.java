package Sorting;

public class InsertonSort {
    static void printArray(int[] arr){
        int n=arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void InSortRec(int[] arr, int l, int h){
        if(l>=h) return;
        int i=l;
        while(i>0){
            if(arr[i]<arr[i-1]){
                int temp=arr[i-1];
                arr[i-1]=arr[i];
                arr[i]=temp;
            }
            i--;
        }
        InSortRec(arr, l+1, h);
    }
    static void InSort(int[] arr,int n){
       for(int i=1; i<n; i++){
        
        int j=i;
        while(j>0){
            if(arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }
            j--;
        }
    }
}
static void SortOnlyZero(int[] arr,int n){
    
    for(int i=1; i<n; i++){
     
     int j=i;
     while(j>0 && arr[j]==0){
       
         if(arr[j]<arr[j-1]){
             int temp=arr[j];
             arr[j]=arr[j-1];
             arr[j-1]=temp;
         }
         j--;
     }
}
}
    public static void main(String[] args) {
        int[] arr={22,5,4,7,4,5,6,9,8,7,4,15,8,7,4,8,14,558,444,7};
        int[] arr1={0,4,2,1,4,5,0,3,2,0,9,1,0,5};
        InSort(arr,arr.length);
        printArray(arr);
        InSortRec(arr,1,arr.length);
        printArray(arr);
        SortOnlyZero(arr1,arr1.length);
        printArray(arr1);
    }
}
