package Sorting;

public class problem1 {
    static void display(int[] arr){
        for(int val:arr){
            System.out.print(val+" ");
        }  
        System.out.println();
    }
    static void Sort(int[] arr){
       int n=arr.length;
       int x=-1;
       int y=-1;

       if(n<=1) return; //corner case

       for(int i=1; i<n; i++){
        if(arr[i-1]>arr[i]){
            if(x==-1){
                x=i-1;//assign index of larger element to x
                y=i;
            }else{
                y=i;//assign index of smaller element to y
            }
        }
    }

    //swap arr[x] and arr[y]
    int temp=arr[x];
    arr[x]=arr[y];
    arr[y]=temp;
}

    public static void main(String[] args) {
        int[] arr={0,1,7,3,5,6,2,9};
        System.out.println("Array before sorting:");
        display(arr);
        Sort(arr);
        System.out.println("Array after sorting:");
        display(arr);
    }
}
