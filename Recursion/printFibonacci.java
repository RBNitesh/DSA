package Recursion;

import java.util.Scanner;

public class printFibonacci { 
    static int printFib(int n){ 
        if(n==1 || n==2){
            return n-1;
        }else{
           return printFib(n-1)+printFib(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of term:");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print(printFib(i)+" ");
        }   
    }
}
