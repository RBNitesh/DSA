class Main {

    static int sum(int i) {
        int sum = 0;
        for (; i >= 1; i -= (i & -i)) {
            sum += bit[i];
        }
        return sum;
    }

    static void update(int i, int x) {
        for (; i < N; i += (i & -i)) {
            bit[i] += x;
        }
    }

    static int[] bit;
    static int N;
    public static void main(String[] strArr) {
        int[] arr = { 1, 5, 3, -21, 5, 41, 13 };

        bit = new int[arr.length + 1]; // 1-indexed
        N = bit.length;

        for (int i = 0; i < arr.length; i++) {
            update(i + 1, arr[i]);
        }

        for (int i = 1; i < N; i++) {
            System.out.print(sum(i) + " ");
        }
    }
}
