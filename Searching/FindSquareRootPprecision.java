package Sorting.Searching;

import java.util.Scanner;

public class FindSquareRootPprecision {

    //method for finding int part of root
    static int findSquareRoot(int n){
        
        int l=0; int h=n;
    
        while(l<=h){
        int mid=l+(h-l)/2;
        
        if(n==mid*mid){
            return mid;
        }
        else if(n<mid*mid) {
           h=mid-1;
        }
        else{
           if(n<((mid+1)*(mid+1))){
            return mid;
           }else{
            l=mid+1;
           }
        }
    }
    return -1;
    }
    
    //method to refine the square root to the desire precision
    static double refineSquareRoot(int n, int intPart, int p){
        double root=intPart;
        double increment=0.1;

        for(int i=0; i<p; i++){
            while(n>=root*root){
                root+=increment;
            }
            root-=increment;//stepback once it overstep
            increment/=10;//divide increment by 10 for finding ans upto next precision
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number:");
        int n= sc.nextInt();
        System.out.print("Enter the precision:");
        int p=sc.nextInt();
        
        int intPart=findSquareRoot(n);
        System.out.println(intPart);
        double ans=refineSquareRoot(n,intPart,p);
        //%." + p + "f → Dynamically sets the decimal precision to p.
        System.out.printf("Square root up to %d decimal places: %." +p+ "f\n", p, ans);
        sc.close();
        
        
    }
}
