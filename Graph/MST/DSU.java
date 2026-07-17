package MST;

// Disjoint set data structure
public class DSU {
    private int[] parent, rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // O(alpha(n)) because of path compression, otherwise O(logn)
    // for all practical case  alpha(n) <= 4
    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    // O(alpha(n))
    public void union(int x, int y) {
        int s1 = find(x); // alpha(n)
        int s2 = find(y); // alpha(n)
        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1]++;
            }
        }
    }
}