package Array;

import java.util.Arrays;
import java.util.Scanner;

public class checksorted {
    static int[] sortedArray(int[] arr){
        Arrays.sort(arr);
        System.out.println("sorted array: ");
        return arr;
    }
    public static void main(String[] args) {
         
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int N=sc.nextInt();
        int [] arr=new int[N];
        if(N>0)
        {
            System.out.println("Enter the element of the array: ");
        }else{
            System.out.println("enter any positive integer as size.");
        }
        for(int i=0; i<N; i++)
        {
             arr[i]=sc.nextInt();
        }
        boolean flag1=true;
        for(int i=0; i<N-1; i++)
        {
            if(arr[i]<=arr[i+1])
            {
              flag1=true;
            }else{
                flag1=false;
                break;
            }
        }
        boolean flag2=true;
        for(int i=0; i<N-1; i++)
        {
            if(arr[i]>=arr[i+1])
            {
               flag2=true;
            }else{
                flag2=false;
                break;
            }
        }
        if(flag1 && flag2)
        {
            System.out.println("all elments of array is same or array don't have any element.");
        }
        else if(flag1)
        {
            System.out.println("array is sorted increasing order.");
        }
        else if(flag2)
        {
             System.out.println("array is sorted in decresing order.");
        }
        else
        {
            System.out.println("array is unsorted.");
        }
        int [] sortedarray=sortedArray(arr);
        for(int i=0; i<sortedarray.length; i++){
            System.out.print(sortedarray[i]);
        }
   
    }
}
