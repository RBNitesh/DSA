package Recursion;

import java.util.Scanner;

public class nthNumInfibonacci {
    static int Fib(int n){

        if(n==0 || n==1)return n;
        return Fib(n-1)+Fib(n-2);

    }
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.print("Enter the n:");
       int n=sc.nextInt();
       int num = Fib(n);
       System.out.println(num);
   }
}
