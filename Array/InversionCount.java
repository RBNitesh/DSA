import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class InversionCount {
    
    static int merge(int[] nums, int lo, int mid, int hi) {
        int ans = 0;

        int[] sorted = new int[hi - lo + 1];
        int idx = 0;

        // count pairs(a, b) where a in left is greater than b is right
        int i = lo, j = mid + 1;
        for (; i <= mid; ++i) {
            while (j <= hi && nums[j] < nums[i]) {
                sorted[idx++] = nums[j++];
            }
            ans += j - mid - 1;
            sorted[idx++] = nums[i];
        }
        
        while (j <= hi)
            sorted[idx++] = nums[j++];
        
        System.arraycopy(sorted, 0, nums, lo, sorted.length);

        return ans;
    }

    static int mergeSorted(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return 0;

        int mid = lo + (hi - lo) / 2;

        int ans = mergeSorted(nums, lo, mid) + mergeSorted(nums, mid + 1, hi);

        ans += merge(nums, lo, mid, hi);

        return ans;
    }
    
    static void solve(int[] arr) {
        int inversions = mergeSorted(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println("\n" +inversions);
    }

    public static void main(String[] args) throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(input);

        /*
            input format:
            No. of test case:
            for each test case:
            Enter the length of array:
            Enter the eles of array:
        */

        // read the first line and split into tokens
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            int i = 0;
            while (st.hasMoreTokens()) {
                arr[i++] = Integer.parseInt(st.nextToken());
            }

            solve(arr);
        }
    }
}