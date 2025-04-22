package Recursion;

import java.util.Scanner;

public class SumOfNaturalNum {
    static int AlternateSum(int n){
        if(n==1){
            return 1;
        }else{
            if(n%2!=0){
                return AlternateSum(n-1)+n;
            }else{
                return AlternateSum(n-1)-n;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        System.out.print("Enter the n: ");
        int n=sc.nextInt();
        int ans=AlternateSum(n);
        System.out.println(ans);
    }
}
