package Strings;

import java.util.Scanner;

public class StringCompressed {
    static String Compress(String str){
        String ans="";
        int count=1;
        char prev=str.charAt(0);
        ans+=prev;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)==prev){
                count++;
                if(i==str.length()-1){
                    ans+=count;
                }
            }else{
                ans+=count;
                ans+=str.charAt(i);
                prev=str.charAt(i);
                count=1;
            }
        }return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.nextLine();
        String ans=Compress(str);
        System.out.println(ans);
    }
}
