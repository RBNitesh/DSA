package dsacollegeWallah;

import java.util.Scanner;

class factorial{
    public factorial(int n){

        // iteratively solving this problem

        int fact=1;
           for(int i=0; i<=n; i++){
            if(i==0 || i==1){
               System.out.println(fact);
            }else{
                fact=i*fact;
                System.out.println(fact);
            }
           }
          

         //recursively solving this problem
        //  for(int i=0; i<=n; i++){
        //     if(i==0 || i==1){
        //         System.out.println(1);
        //     }else{
        //         int result=i*fact(i-1);
        //         System.out.println(result);
        //     }
        //  }

       }
    //    public int fact(int i){
    //     int ans=0;
    //        if(i==0 || i==1){
    //          ans= i;
    //        }else{
    //           ans= i*fact(i-1);
    //        }
    //        return ans;
    //    }

}
public class first_n_factorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();
        System.out.println("Factorial of first "+ n +" number is: ");
        factorial obj=new factorial(n);
        
        
    }
}
