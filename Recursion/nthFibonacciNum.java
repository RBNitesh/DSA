package Recursion;

import java.util.Scanner;

public class nthFibonacciNum {
    static int printFib(int n){
        if(n<=2){
            return n-1;
        }else{
            return printFib(n-1)+printFib(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        for(int i=1; i<=n; i++){
            int ans=printFib(i);
            System.out.println(i+"th Fibonacci num is: "+ans);
        }
    }
}
