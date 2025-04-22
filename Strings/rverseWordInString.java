package Strings;

import java.util.Scanner;

public class rverseWordInString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.nextLine();
        StringBuilder sb=new StringBuilder("");
        String ans="";

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=' '){
                sb.append(str.charAt(i));
            }
            if(str.charAt(i)==' ' || i==str.length()-1){
                sb.reverse();
                ans+=sb;
                ans+=" ";
                sb = new StringBuilder("");
            }
        }
        System.out.println(ans);
    }
}
