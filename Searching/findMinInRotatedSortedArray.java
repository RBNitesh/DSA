package Sorting.Searching;

public class findMinInRotatedSortedArray {
    static int findMin(int[] arr){
        int n=arr.length;
        int st=0; int end=n-1;
        int ans=-1;
        
        while(st<=end){
        int mid=st+(end-st)/2;
        if(arr[mid]>arr[n-1]){
            st=mid+1;
        }else if(arr[mid]<=arr[n-1]){
            ans=mid;
            end=mid-1;
        }
    }
    return ans;
}
    public static void main(String[] args) {
        int[] arr={5,6,7,8,3,4};
        int minIdx=findMin(arr);
        System.out.println("Minimum at index:"+minIdx);
    }
}
