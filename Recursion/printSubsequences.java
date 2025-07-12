package Recursion;

import java.util.Scanner;

public class printSubsequences {
    
    static void findSubsequences(String s , String currAns){
        if(s.length()==0){
            System.out.println(currAns);
            return;
        }
        char curr=s.charAt(0);
        String remaining = s.substring(1);

        //curr char--> choosen to be part of ans
        findSubsequences(remaining, currAns+curr);
        //curr char--> not choosen to be part of ans
        findSubsequences(remaining, currAns);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string:");
        String s = sc.nextLine();
        findSubsequences(s , "");
    }
}
