package Recursion;
import java.util.Scanner;
public class firstNNumber {
    static void printNumber(int n){
        if(n==1){
            System.out.println(n);
            return;
        }else{   
            printNumber(n-1);
            System.out.println(n);
        } 
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the last Number:");
        int n=sc.nextInt();
        printNumber(n);
    }
}
