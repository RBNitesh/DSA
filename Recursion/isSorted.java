package Recursion;

public class isSorted {
    static boolean isSorted(int[] arr, int n){
        if(n==0){
            return true;
        }else{
            if(arr[n-1]>arr[n]){
                return false;
            }else{
                return isSorted(arr, n-1);
            }
        }
    }
    public static void main(String[] args) {
        int [] arr={3, 5 ,6 ,7 ,0};
        System.out.println(isSorted(arr, arr.length-1));
    }
}
