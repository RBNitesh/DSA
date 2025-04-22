package Recursion;

import java.util.Scanner;

public class SumOFDigit {
    static int Sum(int n){
        if(n==0){
            return n;
        }else{
            return (n%10)+Sum(n/10);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter an integer number:");
        int num=sc.nextInt();
        int ans=Sum(num);
        System.out.print("Sum of digit is: "+ans);
    }
}
