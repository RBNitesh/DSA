package Recursion;

import java.util.Scanner;

public class P_raised_to_Q {


    static int printSquare1(int p, int q) {

        if (q == 1) {
            return p;
        } else {
            return p * printSquare1(p, q - 1);
        }
    }
    static int printSquare2(int p, int q){
        if(q==0){
            return 1;
        }
        int smallPow=printSquare2(p, q/2);
        if(q%2==0){
            return smallPow*smallPow;
        }else{
            return p*smallPow*smallPow;
        }
       
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter p and q respectively: ");
        int p=sc.nextInt();
        int q=sc.nextInt();
        int ans1 = printSquare1(p, q);
        int ans2 = printSquare2(p, q);
        System.out.println(p+" raised to "+q+" is = "+ans1);
        System.out.println(p+" raised to "+q+" is = "+ans2);
    }
}
