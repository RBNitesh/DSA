import java.util.*;
class SegmentTree{
    public int[] createSegmentTree(int[] a){
        int n = a.length;
        int[] segTree = new int[n];
        Arrays.fill(segTree, Integer.MIN_VALUE);

        for(int i=n-1; i>=0; --i){
            updateTree(segTree, a[i], i);
        }
        return segTree;
    }

    public void updateTree(int[] segTree, int val, int i){
        segTree[i] = val;

        while(i >= 0){
            int parent = (i-1) >> 1;
            segTree[parent] += segTree[i];

            i = parent;
        }
    }
}

public class Main{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        SegmentTree Tree = new SegmentTree();

        int[] segTree = Tree.createSegmentTree(arr);
        for(int mx : segTree){
            System.out.print(mx + " ");
        }
    }
}