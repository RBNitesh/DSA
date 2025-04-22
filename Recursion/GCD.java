package Recursion;

import java.util.Scanner;

public class GCD {
    static int findGcd(int a, int b){
        if(a==0){
            return b;
        }else{
            return findGcd(b%a, a);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a and b respectively:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int ans = findGcd(a,b);
        System.out.println("GCD of "+a+" and "+b+" is: " +ans);
    }
}
