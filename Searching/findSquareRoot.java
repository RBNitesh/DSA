package Sorting.Searching;

import java.util.Scanner;

public class findSquareRoot {
    static int findsquareroot(int n){
        int l=0; int h=n;
        
        while(l<=h){
        int mid=l+(h-l)/2;
        
        if(n==mid*mid){
            return mid;
        }
        else if(n<mid*mid) {
           h=mid-1;
        }
        else{
           if(n<((mid+1)*(mid+1))){
            return mid;
           }else{
            l=mid+1;
           }
        }
    }
    return -1;
}
    public static void main(String[] args) {
        //find square root of given non-negative integer upto nearest floor integer
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        System.out.println(findsquareroot(n));       
    }
}
