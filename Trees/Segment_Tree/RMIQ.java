import java.util.*;

public class RMIQ {
    static int[] sgt;

    public static void buildSegmentTree(int i, int l, int r, int[] arr) {
        if (l > r)
            return;

        if (l == r) { // return if you reach leaf index
            sgt[i] = r;
            return;
        }

        // find the middle index
        int mid = l + (r - l) / 2;

        buildSegmentTree(2 * i + 1, l, mid, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, arr);

        int leftMaxIndex = sgt[2 * i + 1], rightMaxIndex = sgt[2 * i + 2];
        sgt[i] = (arr[leftMaxIndex] >= arr[rightMaxIndex]) ? leftMaxIndex : rightMaxIndex;

        System.out.println("[" + l + "," + r + "]: " + sgt[i]);
    }

    // this function will find the index of maximum element in range [st, end] 
    public static int rangeMaxIndexQuery(int i, int st, int end, int l, int r, int[] arr) {
        if (st > r || end < l) // in case of invalid range
            return -1;

        if (st <= l && end >= r) // in case range completely overlapping
            return sgt[i];

        int mid = l + (r - l) / 2;
        int leftMaxIndex = -1, rightMaxIndex = -1;
        
        if(st <= mid)
            leftMaxIndex = rangeMaxIndexQuery(2 * i + 1, st, Math.min(end, mid), l, mid, arr);
        if(end > mid)
            rightMaxIndex = rangeMaxIndexQuery(2 * i + 2, Math.max(st, mid + 1), end, mid + 1, r, arr);

        if (leftMaxIndex == -1)
            return rightMaxIndex;
        if (rightMaxIndex == -1)
            return leftMaxIndex;

        return arr[leftMaxIndex] >= arr[rightMaxIndex] ? leftMaxIndex : rightMaxIndex;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = { 3, 2, 5, 3, 2, 2, 6, 2, 6, 6 };
        sgt = new int[4 * arr.length];
        
        // function to build the segment tree for RMIQ(range max index query)
        buildSegmentTree(0, 0, arr.length - 1, arr);
        
        // function to find the index of maximum element in the given range[st, end]
        int st = 2, end = 5;
        int maxIndex = rangeMaxIndexQuery(0, st, end, 0, arr.length - 1, arr);
        System.out.println(maxIndex);
    }
}
