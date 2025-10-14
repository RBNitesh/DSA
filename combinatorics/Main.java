import java.util.*;


public class Main{
    static int MOD = (int)1e9 + 7;
    private static long binomialExpansion(int a, int b){
        if(a==0 || a==1 || b==1)
            return a;

        long half = binomialExpansion(a, b/2);
        long res = (half*half) % MOD;

        if((b & 1) != 0){
            res = (res * a) % MOD;
        }

        return res % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // efficient calculation of a^b
        // System.out.print("Enter a and b respectively: ");
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // System.out.print(binomialExpansion(a, b));

        // modular inverse of a MOD M
        int a = sc.nextInt();
        long modularInverse = binomialExpansion(a, MOD-2);
        System.out.print(modularInverse);
    }
}