package Sorting;

public class sortNegAndPosNumber {
    static void display(int[] arr){
        for(int val: arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    static void swap(int[] arr, int left, int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    static void Sort(int[] arr){
        int n=arr.length;
        int left=0;
        int right=n-1;
        
        while(left<right){
            if(arr[left]<0){
              left++;
            }
            if(arr[right]>=0){
                right--;
            }
            swap(arr,left,right);   
        }
    }

    public static void main(String[] args) {
        int[] arr={3,32,-2,1,-45,32,2,-89,1,4,-42,-5,13,5,-32};
        Sort(arr);
        display(arr);
    }
}
