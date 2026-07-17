package ShortestPath.UnweightedGraph;

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

        BFSDemo obj = new BFSDemo();

        // find shortest path using different algorithms
        System.out.println(obj.bfs(0, 7, adj));
    }
}