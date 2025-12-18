import java.util.*;

public class KMPAlgoDemo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        int[] lps = new int[s.length()];
        KMP(s, lps);

        for(int it : lps){
            System.out.print(it + " ");
        }
    }

    private static void KMP(String s, int[] lps){
        int n = s.length();
        
        int i = 1, len = 0;
        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                lps[i++] = ++len;
            }
            else{
                if(len == 0){
                    lps[i++] = 0;
                }
                    
                else{
                    len = lps[len-1];
                }
            }
        }
    }
}