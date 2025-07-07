import java.util.Scanner;

public class heapSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of arr: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        sort(arr);

        for(int item : arr)
        System.out.print(item + " ");
    }

    private static void sort(int[] arr){
        int n = arr.length;

        for(int i=n; i>0; i--){
            maxheap(arr, i);
            deleteFirstEle(arr, i);
        }
    }

    private static void maxheap(int[] arr, int n){
        for(int i=n/2-1; i>0; i--){
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int i){
        int n = arr.length;

        while(i > 0){
            int left = arr[2*i + 1];
            int right = (2*i+2) < n ? arr[2*i+2] : Integer.MIN_VALUE;

            int j = left > right? 2*i+1 : 2*i+2;
            if(arr[j] > arr[i]){
                swap(arr, i, j);
            }
            i--;
        }
    }

    private static void deleteFirstEle(int[] arr, int n){
        int last = arr[n-1];
        arr[n-1] = arr[0];
        arr[0] = last;
    }

    private static void swap(int[] arr, int i, int j){
        arr[i] += arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] -= arr[j];
    }
}