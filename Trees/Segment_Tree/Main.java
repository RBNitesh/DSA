import java.util.*;

class SegmentTree {

    void SegmentTree(int n) {
    }

    void buildTree(int i, int l, int r, int[] arr, int[] sgt) {
        if (l == r) {
            sgt[i] = arr[r];
            return;
        }

        int mid = l + (r - l) / 2;

        buildTree(2 * i + 1, l, mid, arr, sgt);
        buildTree(2 * i + 2, mid + 1, r, arr, sgt);

        sgt[i] = sgt[2 * i + 1] + sgt[2 * i + 2];
    }

    // point update query
    void update(int index, int val, int l, int r, int i, int[] sgt) {
        if (l == r && l == index) {
            sgt[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(index, val, l, mid, 2 * i + 1, sgt);
        } else {
            update(index, val, mid + 1, r, 2 * i + 2, sgt);
        }

        sgt[i] = sgt[2 * i + 1] + sgt[2 * i + 2];
    }

    // lazy-propagation
    // range update query
    public void rangeUpdate(int st, int end, int val, int l, int r, int i, int[] sgt, int[] lazy) {
        if (end < l || st > r || l > r)
            return;

        if (lazy[i] != 0) {
            sgt[i] += (r - l + 1) * lazy[i];

            if (l != r) {
                lazy[2 * i + 1] = lazy[i];
                lazy[2 * i + 2] = lazy[i];
            }

            lazy[i] = 0;
        }
        
        if (st <= l && end >= r) {
            sgt[i] += (r - l + 1) * val;

            if (l != r) {
                lazy[2 * i + 1] = val;
                lazy[2 * i + 2] = val;
            }
            return;
        }
        
        int mid = l + (r - l) / 2;

        if (st <= mid) {
            rangeUpdate(st, Math.min(end, mid), val, l, mid, 2 * i + 1, sgt, lazy);
        }
        if (end > mid) {
            rangeUpdate(Math.max(st, mid + 1), end, val, mid+1, r, 2 * i + 2, sgt, lazy);
        }
        
        sgt[i] = sgt[2 * i + 1] + sgt[2 * i + 2];
    }

    // range sum query
    public static int findSum(int st, int end, int l, int r, int i, int[] sgt) {
        if (l >= st && r <= end) {
            return sgt[i];
        }
        int mid = l + (r - l) / 2;
        int sum = 0;

        if (st <= mid) {
            sum += findSum(st, Math.min(end, mid), l, mid, 2 * i + 1,sgt);
        }
        if (end > mid) {
            sum += findSum(Math.max(st, mid + 1), end, mid + 1, r, 2 * i + 2,sgt);
        }

        return sum;
    }
}


public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = { 1, 2, 3, 4, 5, 6 };

        int[] lazy = new int[4 * arr.length];

        SegmentTree obj = new SegmentTree();
        int[] sgt = new int[4 * arr.length];

        obj.buildTree(0, 0, arr.length - 1, arr, sgt);

        // print segment tree array
        // for (int sum : sgt) {
        // System.out.print(sum + " ");
        // }

        while (true) {
            System.out.println("Enter 1 to find sum, 2 for updating a single element, 3 for range update and 0 for end the program : ");
            int choice = in.nextInt();
        
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the range: ");
                    int st = in.nextInt();
                    int end = in.nextInt();
                    int result = obj.findSum(st, end, 0, arr.length - 1, 0, sgt);
                    System.out.println(result);
                }
                case 2 -> {
                    System.out.println("Enter the index and value: ");
                    int index = in.nextInt();
                    int val = in.nextInt();
                    obj.update(index, val, 0, arr.length - 1, 0, sgt);
                }
                case 3 -> {
                    System.out.println("Enter the range: ");
                    int st = in.nextInt();
                    int end = in.nextInt();
                    System.out.println("Enter the val: ");
                    int val = in.nextInt();
                    obj.rangeUpdate(st, end, val, 0, arr.length - 1, 0, sgt, lazy);
                }
                default -> {
                    System.out.println("Invalid Choice.");
                }
            }
        }
    }
}