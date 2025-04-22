package Recursion;

import java.util.Scanner;

public class reverseString {
    static String ans="";
    static String reverse(String name , int n){
        if(n<0){
            return "";
        }else{
            ans+=name.charAt(n);
            reverse(name, n-1);
            return ans;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "abcdef";
        String reversedName=reverse(name, name.length()-1);
        System.out.println(reversedName);

    }
}
