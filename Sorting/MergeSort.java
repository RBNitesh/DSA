

public class MergeSort {
    static void display(int[] arr){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void Merge(int[] a,int low, int mid, int high){
    
        int n1=mid-low+1;
        int n2=high-mid; 
        int[] left=new int[n1];
        int[] right=new int[n2];  

        int i=0,j=0,k=low;
        for(; i<n1; i++) left[i]=a[low+i];
        for(; j<n2; j++) right[j]=a[mid+1+j];
        
        i=0;j=0;k=low;
        while(i<n1 && j<n2){

        if(left[i]<right[j])
        a[k++]=left[i++];
        
        else
        a[k++]=right[j++];
        }
      
    while(i<n1)
       a[k++]=left[i++];
    while(j<n2) 
       a[k++]=right[j++];
}


    static void mergeSort(int[] arr,int low,int high){
        if(low>=high) return;
        int mid=(low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        // backtracking
        Merge(arr, low, mid, high);
           
    }


    public static void main(String[] args) {
        int[] arr={2,1,4,3,6,5,8,7};
        System.out.println("Array before sorting:");
        display(arr);
        mergeSort(arr,0,arr.length-1);
        System.out.println("Array after sorting:");
        display(arr);
    }
}
