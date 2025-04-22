package Recursion;

import java.util.Scanner;

public class Multiples {
    static void printMultiple(int num, int m){
        if(m==1){
           System.out.print(num+" ");
           return;
        }else{
            printMultiple(num, m-1);
            System.out.print(num*m+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number:");
        int num=sc.nextInt();
        System.out.print("Enter the number of multiple you want to print :");
        int m=sc.nextInt();
        printMultiple(num, m);
    }
}
