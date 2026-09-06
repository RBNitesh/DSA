import java.io.*;
import java.util.*;

public class template {
    static final long MOD = 1_000_000_007L;
    static final long INF = Long.MAX_VALUE / 4;

    static final FastScanner fs = new FastScanner(System.in);
    static final StringBuilder out = new StringBuilder();

    static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    static long ceilDiv(long a, long b) {
        return (a + b - 1) / b; // Use for positive a and b.
    }

    static void readArr(int size, int[] arr) throws IOException {
        for (int i = 0; i < size; i++) {
            arr[i] = fs.nextInt();
        }
    }

    static void solve() throws Exception {
        // Write the solution for one test case here.
    }

    public static void main(String[] args) throws Exception {
        int testCases = fs.nextInt();
        // For a single-test-case problem, replace the two lines below with: solve();
        while (testCases-- > 0) {
            solve();
        }
        System.out.print(out);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder token = new StringBuilder();
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);
            while (c > ' ') {
                token.append((char) c);
                c = read();
            }
            return token.toString();
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }
            return value * sign;
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
