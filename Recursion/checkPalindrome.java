package Recursion;

import java.util.Scanner;

public class checkPalindrome {
    static boolean checkPalindrome(String s ,int st ,int end){
        if(st>=end) return true;
        
        if(st<end){
            if(s.charAt(st)!=s.charAt(end)){
                return false;
            }else{
                checkPalindrome(s, st+1, end-1);
            }
        }
                return true;   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean b = checkPalindrome(s , 0 ,s.length()-1);
        System.out.println(b);
    }
}
