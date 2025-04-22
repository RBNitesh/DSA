package dsacollegeWallah.NumberConversion;

import java.util.Scanner;

public class decTObin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int decimal_number=sc.nextInt();

        int ans=0;

        while(decimal_number!=0){
            int binary_digit=decimal_number%2;
            ans=(ans*10)+binary_digit;
            decimal_number=decimal_number/2;
        }
        System.out.println(ans);
    }
}
