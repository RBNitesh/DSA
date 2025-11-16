
import java.util.*;

public class {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long L = sc.nextLong();
		long R = sc.nextLong();
		
		String num1 = "" + R;
		String num2 = "" + (L - 1);

		int res =  solve(num1) - solve(num2);
		System.out.println(res);
	}
	
	private static int solve(String num){
		int[][][][] dp = new int[num.length()+1][2][2][2];
		for(int[][][] dpi : dp){
			for(int[][] dpij : dpi){
				for(int[] dpijk : dpij)
					Arrays.fill(dpijk, -1);
			}
		}

		return cntBoringNum(num.length(), num, 1, 1, 0, dp);
	}
	
	private static int cntBoringNum(int n, String num, int pos, int tight, int flag, int[][][][] dp){
	    if(n == 1){
	        if(tight == 1){
	            int x = num.charAt(num.length() - n) - '0';
	            if(pos == 0) return x/2 + 1;
	            else return (x + 1)/2;
	        }
	        return 5;
	    }

		if(dp[n][pos][tight][flag] != -1)
			return dp[n][pos][tight][flag];
	        
	    int ans = 0;
	    
	    int ub = (tight == 1)? (num.charAt(num.length()-n) - '0') : 9; 
	    
	    for(int dig = pos; dig <= ub; dig += 2){
	        ans += cntBoringNum(n-1, num, pos^1, tight * ((ub == dig)? 1 : 0), (flag == 0 && dig == 0) ? 0 : 1, dp);
	    }
	    
		// if all previous taken element is zero
	    if(flag == 0 && pos == 1){
	        ans += cntBoringNum(n-1, num, pos^1, tight * ((ub == 0)? 1 : 0), 0, dp);
	    }
	    
	    return dp[n][pos][tight][flag] = ans;
	}
}
