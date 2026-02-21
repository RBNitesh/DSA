package ShortestPath;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 0, 2 }, { 0, 4 }, { 1, 4 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 3, 0 }, { 3, 1 }, { 4, 0 },
                { 4, 3 } };
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        // find shortest path using different algorithms
        System.out.println(bfs(0, 7, adj));
    }
    
    public static int bfs(int src, int dest, List<Integer>[] adj) {
        boolean[] vis = new boolean[adj.length];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        vis[src] = true;

        int level = 0;
        while (!q.isEmpty()) {
            int N = q.size();

            for (int k = 1; k <= N; k++) {
                int curr = q.poll();
                if (curr == dest)
                    return level;
                for (int next : adj[curr]) {
                    if (!vis[next]) {
                        q.add(next);
                        vis[next] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}