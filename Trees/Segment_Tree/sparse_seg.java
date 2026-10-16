public class sparse_seg {

    static class Node {
        long sum = 0;
        Node left = null;
        Node right = null;
    }

    static class DynamicSegTree {
        Node root;
        private final long maxIdx;

        public DynamicSegTree(long maxIdx) {
            this.maxIdx = maxIdx;
        }

        /*Node*/ void update(long i, long delta, long lo, long hi, Node node) {
            if (node == null) {
                node = new Node();
            }

            node.sum += delta;

            if (lo == hi)
                return /*node*/;

            long mid = lo + (hi - lo) / 2;

            if (i <= mid)
                update(i, delta, lo, mid, node.left);

            else
                update(i, delta, mid + 1, hi, node.right);
            
            //return node;
        }

        // add the delta to the element at the index 'i'
        void add(long i, long delta) {
            if (i < 0 || i > maxIdx)
                throw new IllegalArgumentException("Index out of bound.");

            update(i, delta, 0, maxIdx, root);
        }

        long query(long ql, long qr, long lo, long hi, Node node) {
            if (node == null || ql > hi || qr < lo)
                return 0;

            if (ql <= lo && qr >= hi)
                return node.sum;

            long mid = lo + (hi - lo) / 2;

            long ans = 0;
            if (ql <= mid)
                ans += query(ql, qr, lo, mid, node.left);
            if(qr > mid)
                ans += query(ql, qr, mid + 1, hi, node.right);

            return ans;
        }

        // find the sum of the element from index a to b in the array
        long sum(long a, long b) {
            if (a > b)
                return 0;

            return query(a, b, 0, maxIdx, root);
        }
    }

    public static void main() {
        int[] arr = { 1, 2, 3, 4, 5 };
        DynamicSegTree obj = new DynamicSegTree(100000000000L);

        for (int i = 0; i < 5; ++i) {
            obj.add(i, arr[i]);
        }

        for (int i = 0; i < 5; ++i) {
            System.out.print(obj.sum(0, i) + " ");
        }

        System.out.print(obj.root.sum);
    }
}