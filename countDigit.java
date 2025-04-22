package dsacollegeWallah;

import java.util.Scanner;

class Count{
    public  Count(int n){
        reverse(n);
        int sum=0;
        int count=0;
        while(n!=0){
            sum+=(n%10);
            n/=10;
            count++;
        }
        System.out.println("Number of digit in given number: "+count);
        System.out.println("Sum of digit in in given number: "+sum);
        
    }

    public void reverse(int n){
        int result=0;
        while(n!=0){
            result=result*10+(n%10);
            n=n/10;
        }
    System.out.println("reverse of number: "+result);
    }
}
 

class countDigit{
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the number: ");
    int n=sc.nextInt();
    Count obj=new Count(n);
   }
}