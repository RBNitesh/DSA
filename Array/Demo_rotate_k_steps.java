package Array;

import java.util.Scanner;
class Rotate{
    public void rotate(int[] arr, int n, int k){
        int []ans=new int[n];

        //method-1

        // int j=0;
        // for(int i=n-k; i<n ; i++)
        //  {
        //  ans[j++]=arr[i];
        //  }
        //  for(int i=0; i<n-k ; i++)
        //  {
        //  ans[j++]=arr[i];
        //   }
       
        //method-2
        
        int i=0;
        while(i<n){
            for (int j=0; j<n; j++){
                ans[(i+k)%n]=arr[j];
                i++;
            }
        }
        System.out.print("Original array: ");
        printArray(arr);
        System.out.print("Resulting array after rotation of " + k + " steps: ");
        printArray(ans);
    }
    public void printArray(int []array){
       for(int i=0; i<array.length; i++){
        System.out.print(array[i]+" ");
       }
       System.out.println();
    }
}
public class Demo_rotate_k_steps{
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        if(n>0){
            System.out.print("Enter the element: ");
            for(int i=0;i<n; i++){
                arr[i]=sc.nextInt();
            }
        }
        System.out.print("Enter the number of steps to be rotated: ");
        int k=sc.nextInt();
        Rotate obj=new Rotate();
        obj.rotate(arr, n, k%n);
       
     }
}
