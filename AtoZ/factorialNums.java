package AtoZ;
import java.util.ArrayList;
import java.util.Scanner;
public class factorialNums {
    static long factorialOf(long n){
        if(n==0 || n==1) return 1;
        else return n*factorialOf(n-1);
    }
    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> list=new ArrayList<>();
        
       for(int i=1; i<=n; i++){
           long fact=factorialOf(i);
           if(fact<=n){
               list.add(fact);
           }else{
               return list;
           }
       }
       return list;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        ArrayList<Long> arr=factorialNumbers(n);
        System.out.println(arr);
    }
}