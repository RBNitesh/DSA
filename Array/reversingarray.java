package Array;

import java.util.Scanner;

public class reversingarray {
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
        int j=0;
        int []reversedarr=new int[arr.length];
        
        for (int i=n-1; i>=0; i--){
            reversedarr[j++]=arr[i];// first assign reversedarr[j]=arr[i] then j++
        }
        System.out.print("reversed array: ");
        for(int i=0; i<n; i++){
            System.out.print(reversedarr[i]+" ");
        }
    }
}
