package Recursion;
import java.util.Scanner;

import Array.sortSuareOfNum;
public class factorial {
    static int printFactorial(int n){
        int fact;
        if(n<=1){
           return 1;
        }else{
            return n*printFactorial(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int num=sc.nextInt();
        
        int ans=printFactorial(num);
        System.out.println("Factorial of "+num+" is: "+ans);
    }
    
}
