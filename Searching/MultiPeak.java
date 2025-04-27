package Sorting.Searching;

public class MultiPeak {
    static int findPeak(int[] arr){
        int i=0; int j=arr.length-1;

        while(i<=j){
            int mid=i+(j-i)/2;
            if((mid==0 || arr[mid] > arr[mid-1]) &&  (mid==arr.length-1 || arr[mid] > arr[mid+1])){
                return mid;
            }else if(arr[mid] < arr[mid+1]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,3,2,5,4,2,0};
        System.out.println(findPeak(arr));
    }
}
