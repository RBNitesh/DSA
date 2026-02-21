import java.util.*;
public class digitSumX{

    public static int solve(int n, String num, int x, int tight){
        if(x < 0) return  0;

        if(n == 1){
            if(x >= 0 && x <= 9)
                return 1;
            return 0;
        }

        if(dp[n][x][tight] != -1)
            return dp[n][x][tight];
        
        int ans = 0;
        int ub = tight == 1? (num.charAt(num.length() - n) - '0') : 9;

        for(int dig = 0; dig <= ub; dig++){
            ans = (ans + solve(n-1, num, x-dig, tight & ((ub == tight)? 1 : 0))) % MOD;
        }

        return dp[n][x][tight] = ans;
    }

    // Brute-force
    public static int solve1(String num, int x){
        int ans = 0;
        int n = Integer.valueOf(num);
        for(int i=0; i<=n; i++){
            if(digitSum(i, x)){
                ans++;
            }
        }
        return ans;
    }

    public static boolean digitSum(int num, int x){
        int sum = 0;
        
        while(num > 0){
            sum += (num % 10);
            num /= 10;
        }

        return sum == x;
    }


    static int MOD;
    static int[][][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MOD = (int) 1e9 + 7;

        String num = sc.next();
        int x = sc.nextInt();

        dp = new int[num.length()+1][x+1][2];
        for(int[][] dpi : dp){
            for(int[] dpij : dpi){
                Arrays.fill(dpij, -1);
            }
        }

        System.out.println(solve(num.length(), num, x, 1));
        // System.out.println(solve1(num, x));
    }
}