package Array;

import java.util.Scanner;

public class queries {
    static int[] makefreqarr(int [] arr){
        int[] freqarr=new int[100005];
        for(int i=0; i<arr.length; i++){
          freqarr[arr[i]]++;
        }
        return freqarr;
  }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        int i=0;
        System.out.print("Enter the element: ");
        while(i<n){
            arr[i++]=sc.nextInt();
        }
        System.out.print("Enter the number of queries: ");
        int q=sc.nextInt();
        int[] freq=makefreqarr(arr);
        while(q>=0){
            System.out.print("Enter the element to be searched: ");
            int element=sc.nextInt();
            if(freq[element]>0){
                System.out.println("YES");
                
            }else{
                System.out.println("NO");
            }
            q--;
        }
    } 
}
    
