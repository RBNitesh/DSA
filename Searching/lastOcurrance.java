package Sorting.Searching;

import java.util.Scanner;

public class lastOcurrance {
    static int lastOcurrance(int[] arr, int key){
        int l=0; int h=arr.length-1;
        int lo=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
        
            if(arr[mid]==key) {
                lo=mid;
                l=mid+1;
            }
            
            else if(arr[mid]<key) {
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return lo;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int[] arr={0,1,1,2,2,2,3,3,3,4,4};
        System.out.print("Enter the element:");
        int n=sc.nextInt();
        System.out.println(lastOcurrance(arr,n));
    }
}
