package Array;

import java.util.Scanner;

public class SumOfElementsInRange {
    static int[] SumOfElements(int[] arr){
        // int Sum=0;
        // for(int i=st; i<=end; i++){
        //     Sum+=arr[i];
        // }

        int[] PrefixSum=new int[arr.length];
        PrefixSum[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            PrefixSum[i]=PrefixSum[i-1]+arr[i];
        }
       return PrefixSum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={4,5,8,9,6,7,6,8,9};
        int n=arr.length;
        int[] PrefixSum=SumOfElements(arr);
        System.out.print("Enter the q:");
        int q=sc.nextInt();
        
        while(q>0){
            System.out.print("Enter start index:");
            int a=sc.nextInt();
            System.out.print("Enter end index:");
            int b=sc.nextInt();
            if(a==0){
                System.out.print(PrefixSum[b]);
                q--;
            }else{
                System.out.print(PrefixSum[b]-PrefixSum[a-1]);
                q--;
            }
            System.out.println();
        }
    }
    
}
