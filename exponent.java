package dsacollegeWallah;

import java.util.Scanner;

class Expo{
    public Expo(int a, int b){
        int expo=1;
        for(int i=1; i<=b; i++){
            expo*=a;
        }
        System.out.println(a+ " raised to " + b +" is: " +expo);
    }
}

public class exponent {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter  a and b respectively: ");
        Expo obj=new Expo(sc.nextInt(),sc.nextInt());
    }
    
}
