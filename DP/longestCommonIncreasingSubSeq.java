import java.util.*;

class Solution {
    int[][] dp;
    int min, max;

    public int lengthOfLIS(int[] nums) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int num : nums){
            min = num < min? num : min;
            max = num > max? num : max;
        }

        dp = new int[nums.length+1][max-min+2];
        for(int[] dpi : dp)
            Arrays.fill(dpi, -1);

        return solve(nums, nums.length, max+1);
    }

    public int solve(int[] nums, int n, int prev){
        if(n == 0) 
            return 0;

        if(dp[n][prev-min] != -1)
            return dp[n][prev-min];

        int ans = 0;

        if(nums[n-1] < prev){
            // include
            ans = 1 + solve(nums, n-1, nums[n-1]);
        }

        ans = Math.max(ans, solve(nums, n-1, prev));

        return dp[n][prev-min] = ans;
    }

}

public class longestCommonIncreasingSubSeq{
    public static void main(String[] args) {
        int[] a = {23, 342,42,424,2424};
        Solution obj = new Solution();
        System.out.println(obj.lengthOfLIS(a));
    }
}