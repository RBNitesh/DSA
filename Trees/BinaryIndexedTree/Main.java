class Main {

    // i & -i: It always gives you smallest power of 2 that divides i
    // calculates sum of (arr[1] + arr[2] + .... arr[i]) // 1-indexed
    static int sum(int i) {
        int sum = 0;
        while (i >= 1) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }

    static void update(int i, int x) {
        while (i <= N) {
            bit[i] += x;
            i += i & -i;
        }
    }

    static int[] bit;
    static int N;

    public static void main(String[] strArr) {
        int[] arr = { 1, 5, 3, -21, 5, 41, 13 };
        int N = arr.length;

        // bit[k]: sum(arr[k-p(k)+1] + .... arr[k])
        bit = new int[N + 1]; // 1-indexed

        for (int i = 0; i < N; i++) {
            update(i + 1, arr[i]);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(sum(i) + " ");
        }

    }
}

/*
    1110000010
    1110000001
    0001111110
*/
