package CSES.TreeAlgorithms.subTree_queries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class FastIO {
    BufferedReader br;
    StringTokenizer st;

    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next(){
        while (st == null || !st.hasMoreTokens()) {
            try{
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException ex) {
                System.out.println("Error while reading input\n" +ex.getMessage());
            }
        }
        return st.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }

    public double nextDouble() {
        return Double.parseDouble(this.next());
    }

    public double nextLong() {
        return Long.parseLong(this.next());
    }

    public String nextLine() throws IOException{
        String str = "";
        try {
            // read last line if something has left there otherwise read new line
            str = st.hasMoreTokens()? st.nextToken("\n") : br.readLine();
        }
        catch (IOException ex) {
            System.out.println("Error while reading input\n" + ex.getMessage());
        }
        return str;
    }
}

public class Main {

    static int n;
    static ArrayList<Integer>[] adj;
    static int[] value;
    static int[] start;
    static int[] end;
    static int timer;
    static long[] bit;

    static void dfs(int node, int parent) {
        start[node] = ++timer;

        for (int v : adj[node]) {
            if (v != parent) {
                dfs(v, node);
            }
        }

        end[node] = timer;
    }

    static void update(int i, int delta) {
        for(; i <= n; i += i&-i)
            bit[i] += delta;
    }
    
    static long query(int i) {
        long sum = 0;
        for(; i > 0; i -= i&-i) 
            sum += bit[i];
        return sum;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        FastIO in = new FastIO();

        n = in.nextInt();
        int q = in.nextInt();

        bit = new long[n + 1];

        // read the values of the nodes
        value = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            value[i] = in.nextInt();
        }

        // built an adjacency list
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; ++i){
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; ++i) {
            int u = in.nextInt();
            int v = in.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }

        // flatten the tree
        start = new int[n + 1];
        end = new int[n + 1];
        dfs(1, 0);

        // populate bit using start position
        for (int i = 1; i <= n; ++i) {
            update(start[i], value[i]);
        }

        StringBuilder ans = new StringBuilder();

        // ans the query
        while (q-- > 0) {
            int type = in.nextInt();

            if (type == 1) {
                int s = in.nextInt();
                int x = in.nextInt();
                int delta = x - value[s];
                update(start[s], delta);
                value[s] = x;
            } else {
                int s = in.nextInt();
                long res = query(end[s]) - query(start[s] - 1);
                if (ans.length() > 0) {
                    ans.append("\n");
                }
                ans.append(res);
            }
        }
        
        System.out.print(ans.toString());
    }
}
