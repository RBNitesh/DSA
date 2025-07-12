package Sorting;

public class SortOnlyZero {

    static void printArray(int[] arr,int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    static int[] BBSortOnlyZero(int[] arr){
        int n=arr.length;
        int swap=0;
        int pass=0;
        for(int i=0; i<n-1;i++){
            boolean flag=false;//reset flag variable after each iteration of inner loop
            for(int j=0; j<n-i-1;j++){
                //only sort zero present in array
                if(arr[j]==0 && arr[j+1]!=0){
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
    return arr;
}
    public static void main(String[] args) {
        int arr[] ={0,0,0,1,6,0,0,-12,5,4,0,0,1};

        int[] ans=BBSortOnlyZero(arr);
        printArray(ans, ans.length);
    }
}
