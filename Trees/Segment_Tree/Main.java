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

    void update(int index, int val, int l, int r, int i, int[] arr, int[] sgt) {
        if (l == r && l == index) {
            sgt[i] = val;
            return;
        }

        int mid = (l + r) >> 1;

        if (index <= mid) {
            update(index, val, l, mid, 2 * i + 1, arr, sgt);
        }
        else {
            update(index, val, mid + 1, r, 2 * i + 2, arr, sgt);
        }
        
        sgt[i] = sgt[2 * i + 1] + sgt[2 * i + 2];
    }
}

public class Main{
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        SegmentTree obj = new SegmentTree();
        int[] sgt = new int[2 * arr.length];
        obj.buildTree(0, 0, arr.length - 1, arr, sgt);

        // for (int sum : sgt) {
        // System.out.print(sum + " ");
        // }

        System.out.println("Initially: ");
        System.out.println(findSum(2, 3, 0, arr.length - 1, 0, arr, sgt));
        System.out.println(findSum(1, 5, 0, arr.length - 1, 0, arr, sgt));

        System.out.println("After updating the value with their square");
        for (int i = 0; i < arr.length; i++) {
            obj.update(i, arr[i] * arr[i], 0, arr.length-1, 0, arr, sgt);
        }

        System.out.println(findSum(2, 3, 0, arr.length - 1, 0, arr, sgt));
        System.out.println(findSum(1, 5, 0, arr.length - 1, 0, arr, sgt));
    }
    
    public static int findSum(int l1, int r1, int l2, int r2, int i, int[] arr, int[] sgt) {
        if (l1 == l2 && r1 == r2) {
            return sgt[i];
        }

        int mid = (l2 + r2) >> 1;

        int sum = 0;
        
        if (l1 <= mid) {
            sum += findSum(l1, Math.min(r1, mid), l2, mid, 2 * i + 1, arr, sgt);
        }
        if (r1 > mid) {
            sum += findSum(Math.max(l1, mid + 1), r1, mid + 1, r2, 2 * i + 2, arr, sgt);
        }
        
        return sum;
    }
}