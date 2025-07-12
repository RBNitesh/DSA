package AtoZ;

import java.util.Scanner;

public class CheckArmstrong{
    static int findNumOfDigit(int n){
        int count=0;
        
        while(n>0){
            n/=10;
            count++;
        }
        return count;
    }
    static boolean checkArmstrong(int n){
        if(n==0){return true;}
        int noOfdigit=findNumOfDigit(n);
        int num=n;
        int sum=0;
        while(num>0){
           int d=num%10;
           sum+=Math.pow(d, noOfdigit);
           num/=10;
        }
        return n==sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        System.out.println(checkArmstrong(n));
    }
}