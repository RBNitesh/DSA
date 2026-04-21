import java.util.*;

class Solution {

    public int gcd(int a, int b){
        return a == 0? b : gcd(b%a, a);
    }
    
    public int pour(int n, int m, int d){
        int steps = 0;
        int jug = 0, cup = 0;
        
        while(!(jug == d || cup == d)){
            if(cup == 0){
                cup = m;
            }
            else if(jug < n){
                int toFill = n - jug;
                jug += Math.min(cup, toFill);
                cup = Math.max(0, cup-toFill);
            }
            else{ // jug == n
                jug = 0;
            }
            steps++;
        }
        
        return steps;
    }
    
    public int minSteps(int m, int n, int d) {
        if(d > m && d > n) return -1;
        if(d % gcd(m, n) != 0) return -1;
        
        return Math.min(pour(n, m, d), pour(m, n, d));
    }
}

public class TwoWaterJug{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value for n, m and d respectively: ");
        int res = new Solution().minSteps(in.nextInt(), in.nextInt(), in.nextInt());
        System.out.println(res);
    }
}

