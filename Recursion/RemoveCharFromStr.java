package Recursion;

import java.util.Scanner;

public class RemoveCharFromStr {
    
        static void remoString(String word, int n){
            String ans="";
            if(n<0){
                return;
            }
            else{
    
                if(word.charAt(n)!='e'){
                    ans+=(word.charAt(n));
                    remoString(word, n-1);
                }else{
                    remoString(word, n-1);
                }
            }
        System.out.print(ans);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String str="omlete";
        remoString(str, str.length()-1);
    }
}
