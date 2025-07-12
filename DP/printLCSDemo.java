package DP;

import java.util.Scanner;

public class printLCSDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String text1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String text2 = sc.nextLine();

        printLCS(text1, text2);
    }

    private static void printLCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0) dp[i][j] = 0;

                else if(s1.charAt(i-1) != s2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

                else{
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(n>0 && m>0){
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                sb.append(s1.charAt(n-1));
                n--;
                m--;
            }
            else{
                if(dp[n-1][m] > dp[n][m-1]){
                    n--;
                }
                else m--;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}