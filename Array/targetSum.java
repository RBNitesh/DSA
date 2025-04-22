package Array;

import java.util.Scanner;

public class targetSum {
    public static void main(String[] args) {
    int arr[]={4,5,3,5,2,6,9};
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the target: ");
    int target=sc.nextInt();
    int count=0;
    int i,j,k;
    for(i=0; i<arr.length; i++){
        for( j=i+1; j<arr.length; j++){
            for(k=j+1; k<arr.length; k++){
               if(arr[i]+arr[j]+arr[k]==target){
                System.out.print(arr[i]);
                System.out.print(arr[j]);
                System.out.print(arr[k]);
                System.out.println();
                count+=1;
               }
            }
        }
    }
    System.out.println(count);
}
    
}
