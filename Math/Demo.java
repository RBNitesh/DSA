import java.util.Scanner;

public class Demo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the n: ");
        // int n = sc.nextInt();

        // printPrime(n);

        // count the total number of factors upto n
        // int[] a = new int[n+1];
        // for(int i=1; i<=n; i++){
        //     a[i] = cntFactors(i);
        // }
        // System.out.println(total);

        // for(int i=1; i<=n; i++){
        //     for(int j=i; j<=n; j+=i){
        //         a[j]++; // i is a diviser of j
        //     }
        // }
        
        // for(int ele : a){
        //     System.out.print(ele+" ");
        // }
        // System.out.println();

        // Binary exponentiation
        System.out.print("Enter a, b and m respectively: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(pw(a, b, m));
    }

    // binary exponentiation
    static int pw(int a, int b, int m){
        if(b==0) 
            return 1%m;
        if(b%2==0){
            int t= pw(a, b/2, m);
            return t*t % m;
        }
        else{
            int t = pw(a, b/2, m);
            return a* t * t % m;
        }
    }

    // nuber of factors 
    static int cntFactors(int n){
        int cnt = 0;
        for(int i=1; i*i<=n; i++){
            if(n%i == 0) cnt++;
            
            if(i != n/i) cnt++;
        }
        return cnt;
    }

    // find the no. of prime number upto n
    static void printPrime(int n){
        boolean[] isPrime = new boolean[n+1];
        isPrime[0] = false; 
        isPrime[1] = false;
        for(int i=2; i<=n; i++){
            isPrime[i] = true;
        }
        
        for(int i=2; i<=Math.sqrt(n); i++){
            // for(int j=2*i; j<=n; j+= i)

        /* if i is m then
            i * 2 -> would be divisible by 2 (hence it would be marked false when i=2)
            i * 3 -> would be divisible by 3 (hence it would be marked false when i=3)
            i * 4 -> would be divisible by 4 (hence it would be marked false when i=4)
            ......
            ......
            i * (m-1) -> would be divisible by m-1 (hence it would be marked false when i=m-1)

            so no need to start from 2*i each and every time. We can simply start from i*i.
        */ 
            for(int j=i*i; j<=n; j+=i){
                isPrime[j] = false;
            }
        }

        int ans = 0;
        for(int i=0; i<=n; i++){
            if(isPrime[i])
                System.out.print(i+" ");
        }
        System.out.println();
    }
}


