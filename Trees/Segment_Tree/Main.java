import java.util.*;

class SegmentTree {

    void SegmentTree(int n) {
    }

    void buildTree(int i, int l, int r, int[] arr, int[] sgt) {
        if (l == r) {
            sgt[i] = arr[r];
            return;
        }

        int mid = (l + r) >> 1;

        buildTree(2 * i + 1, l, mid, arr, sgt);
        buildTree(2 * i + 2, mid + 1, r, arr, sgt);

        sgt[i] = sgt[2 * i + 1] + sgt[2 * i + 2];
    }

    // point update query
    void update(int index, int val, int l, int r, int i, int[] arr, int[] sgt) {
        if (l == r && l == index) {
            sgt[i] = val;
            return;
        }

        int mid = (l + r) >> 1;

        if (index <= mid) {
            update(index, val, l, mid, 2 * i + 1, arr, sgt);
        } else {
            update(index, val, mid + 1, r, 2 * i + 2, arr, sgt);
        }

        sgt[i] = sgt[2 * i + 1] + sgt[2 * i + 2];
    }

    // lazy-propagation
    // range update query
    public void rangeUpdate(int st, int end, int val, int l, int r, int i, int[] sgt, int[] lazy) {
        // out of range
        if (end < l || st > r) 
            return;

        if (lazy[i] != 0) {
            sgt[i] += (r - l + 1) * lazy[i];
            if (l != r) {
                lazy[2 * i + 1] += lazy[i];
                lazy[2 * i + 2] += lazy[i];
            }
            lazy[i] = 0;
        }

        if (st <= l && end >= r) {
            sgt[i] += (r - l + 1) * val;

            if (l != r) {
                lazy[2*i+1] += val;
                lazy[2 * i + 2] += val;
            }
            return;
        }

        int mid = (l + r) >> 1;

        if (st <= mid) {
            rangeUpdate(st, Math.min(end, mid), val, l, mid, 2 * i + 1, sgt, lazy);
        }
        if (end > mid) {
            rangeUpdate(Math.max(st, mid + 1), end, val, mid + 1, r, 2 * i + 2, sgt, lazy);
        }
        
        sgt[i] = sgt[2 * i + 1] + sgt[2 * i + 2];
        System.out.println("sgt[" + i + "]: " + sgt[i]);
    }

    // range sum query
    public static int findSum(int st, int end, int l, int r, int i, int[] arr, int[] sgt) {
        if (l >= st && r <= end) {
            return sgt[i];
        }
        int mid = (l + r) >> 1;
        int sum = 0;

        if (st <= mid) {
            sum += findSum(st, Math.min(end, mid), l, mid, 2 * i + 1, arr, sgt);
        }
        if (end > mid) {
            sum += findSum(Math.max(st, mid + 1), end, mid + 1, r, 2 * i + 2, arr, sgt);
        }

        return sum;
    }
}


public class Main{
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4};

        SegmentTree obj = new SegmentTree();
        int[] sgt = new int[4 * arr.length];
        obj.buildTree(0, 0, arr.length - 1, arr, sgt);

        for (int sum : sgt) {
        System.out.print(sum + " ");
        }

        System.out.println("Initially: ");
        System.out.println(obj.findSum(2, 3, 0, arr.length - 1, 0, arr, sgt));
        System.out.println(obj.findSum(1, 2, 0, arr.length - 1, 0, arr, sgt));

        // System.out.println("After updating the value with their square");
        // for (int i = 0; i < arr.length; i++) {
            // obj.update(i, arr[i] * arr[i], 0, arr.length-1, 0, arr, sgt);
        // }

        // System.out.println(obj.findSum(2, 3, 0, arr.length - 1, 0, arr, sgt));
        // System.out.println(obj.findSum(1, 2, 0, arr.length - 1, 0, arr, sgt));


        // range update query
        int[] lazy = new int[4*arr.length];
        obj.rangeUpdate(2, 3, 3, 0, arr.length - 1, 0, sgt, lazy);
        obj.rangeUpdate(3, 3, 1, 0, arr.length - 1, 0, sgt, lazy);
        
        System.out.println("After range upadate query: ");
        System.out.println(obj.findSum(2, 3, 0, arr.length - 1, 0, arr, sgt));
        // System.out.println(obj.findSum(1, 2, 0, arr.length - 1, 0, arr, sgt));
    }
}