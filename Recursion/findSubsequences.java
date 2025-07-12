package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class findSubsequences {
    static ArrayList<String> getSubsequences(String s){
        ArrayList<String> ans=new ArrayList<>();
        if(s.length()==0){
            ans.add(" ");
            return ans;
        }
        
        char curr = s.charAt(0);
        ArrayList<String> smallAns=getSubsequences(s.substring(1 ));

        for(String ss:smallAns){
            ans.add(ss);
            ans.add(curr+ss);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> ans = getSubsequences(str);
        System.out.println(ans);
    }
    
}
