package binarylifting;

class Main {

    public void kthAncestor(int n, int[] parent) {
        int LOG = 30;
        // up[i][j]: It stores the 2^j th ancestor of i 
        int[][] up = new int[n][LOG + 1];

        parent[0] = 0;

        for (int v = 0; v < n; v++) {
            up[v][0] = parent[v];

            for (int j = 1; j <= LOG; j++) {
                up[v][j] = up[ up[v][j - 1] ][j - 1];
            }
        }
    }
    
}
