package Recursion;

import java.util.Scanner;

public class KeyboardCombinations {
    static void Combinations(String dig , String[] kp, String currAns){
        if(dig.length()==0){
            System.out.print(currAns+" ");
            return;
        }

        int currNum = dig.charAt(0)-'0';
        String currString = kp[currNum];

        for(int i=0; i<currString.length() ;i++){
            
            Combinations(dig.substring(1),kp,currAns+currString.charAt(i));
        
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] kp={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        System.out.print("Enter the number:");
        String digit = sc.nextLine();
        Combinations(digit, kp,"");
    }
}
