package Recursion;

public class SumOfElementsInArr{
    static int findSum(int [] arr, int n){
        if(n==0){
            return arr[n];
        }else{
            return arr[n]+findSum(arr, n-1);
        }
    }
    public static void main(String[] args) {
        int [] arr = {2,34,65,4,3,2,25,7,4};
        int sum=findSum(arr, arr.length-1);
        System.out.println(sum);
    }
    
}
