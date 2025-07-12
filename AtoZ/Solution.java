package AtoZ;

import java.util.Scanner;

class Solution {
    public static boolean isPalindrome(String s) {
        if(s=="" || s==" ") return true;
        int st=0; int end=s.length()-1;
        while(st<end){
            char c1=s.charAt(st);
            char c2=s.charAt(end);

            if(c1>='A' && c1<='Z'){
                c1=(char)(c1+32);
            }
            if(c2>='A' && c2<='Z'){
                c2=(char)(c2+32);
            }
            if((c1>='a' && c1<='z') || (c1>='0' && c1<='9')){
                if((c2>='a' && c2<='z') || (c2>='0' && c2<='9')){
                    if(c1==c2) {
                        st++;
                        end--;
                    }else{
                        return false;
                    }
                }else{
                    end--;
                }
            }else{
                st++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String:");
        String s=sc.nextLine();
        System.out.println(isPalindrome(s));
    }
}