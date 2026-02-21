// count the number in the range [left, right] that has prime number of set bits.
import java.util.*;

public class cntPrimeNumSetBits {
    // stores prime number upto 61
    static Set<Integer> primes;
    public static void main(String[] args) {
        primes = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the left and right boundary: ");
        long left = sc.nextLong();
        long right = sc.nextLong();

        long res = solve(left, right);
        System.out.println(res);
    }

    // global declaration
    static long[][][] dp;

    public static long solve(long l, long r) {
        int[] ps = { 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61 };

        for (int prime : ps) {
            primes.add(prime);
        }

        String s1 = Long.toBinaryString(r);
        String s2 = Long.toBinaryString(l - 1);

        // dp[i][k][tight]: stores the total number of valid ways to fill the remaining bianry digit
        // from i to end, such that the finally generated number has prime number of set bits.

        // tight = 1: The prefix we have built exactly matches the prefix of the 'num', 
        // we are restricted by the original num's digit.
        
        // tight = 0: The prefix we've built is strictly less than 'num', we are free to place
        // '0' or '1' w/o exceeding the limit.
        
        dp = new long[s1.length()][Math.min(s1.length(), 65)][2];
        for (long[][] dpi : dp)
            for (long[] dpij : dpi)
                Arrays.fill(dpij, -1L);

        long cnt1 = compute(s1, 0, 0, 1);

        dp = new long[s2.length()][Math.min(s2.length(), 65)][2];
        for (long[][] dpi : dp)
            for (long[] dpij : dpi)
                Arrays.fill(dpij, -1L);

        long cnt2 = compute(s2, 0, 0, 1);

        return cnt1 - cnt2;
    }

    public static long compute(String num, int i, int k, int tight){
        int n = num.length();

        if (i == n) {
            return primes.contains(k) ? 1 : 0;
        }
        
        if (dp[i][k][tight] != -1L)
            return dp[i][k][tight];

        long cnt = 0L;
        char d = num.charAt(i);

        // we can take zero any time 
        cnt += compute(num, i + 1, k, tight & ((d == '0')? 1 : 0));
        
        if (d == '1' || tight == 0) {
            cnt += compute(num, i + 1, k + 1, tight);
        }
        
        return dp[i][k][tight] = cnt;
    }
}
