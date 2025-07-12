package Sorting;

public class BubbleSort {
    static void printArray(int[] arr,int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void bubbleSortRec(int[] arr,int l, int h){
        if(l>=h) return;
        boolean flag=false;
        for(int i=0; i<h-1; i++){
            if(arr[i+1]<arr[i]){
                int temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
                flag=true;
            }
        }
        if(!flag) return;
        bubbleSortRec(arr,l,h-1);
        return;
    }

    static void bubbleSort(int[] arr){
        int n=arr.length;
        int swap=0;
        int pass=0;
        for(int i=0; i<n-1;i++){
            boolean flag=false;//reset flag variable after each iteration of inner loop
            for(int j=0; j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap++;
                    flag=true;
                }
            }
            if(!flag){
               break;
            }
            pass++;
        }
        System.out.println("Number of swap:"+swap);
        System.out.println("Number of passes:"+pass);
        return ;
    }
    public static void main(String[] args) {
        int arr[] ={1,6,0,2,1,0,5,4,0,1};

        bubbleSortRec(arr,0,arr.length);
        printArray(arr,arr.length);
        // bubbleSort(arr);
        // printArray(arr,arr.length);
    }
}
