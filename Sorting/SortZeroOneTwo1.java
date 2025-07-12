package Sorting;

public class SortZeroOneTwo1 {
    static void display(int[] arr){
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    static int findMax(int[] arr, int n){
        int max=arr[0];
        for(int i=0; i<n; i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }

    static void Sort(int[] arr){
        int n=arr.length;
        int max=findMax(arr,n);

        int[] freq=new int[max+1];
        for(int i=0; i<arr.length; i++){
            freq[arr[i]]++;
        }

        for(int i=1; i<freq.length; i++){
            freq[i]+=freq[i-1];
        }
        
        int[] res=new int[arr.length];

        for(int i=arr.length-1;i>=0; i--){
            int idx=freq[arr[i]]-1;
            res[idx]=arr[i];
            freq[arr[i]]--;
        }
        for(int i=0; i<arr.length; i++){
            arr[i]=res[i];
        }
    }
    public static void main(String[] args) {
        int[] arr={2,2,1,1,0,0,1,2,0,1};
        Sort(arr);
        display(arr);
    }
}
