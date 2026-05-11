package ShortestPath.WeightedGraph.NegativeEdgeGraph;

import java.util.*;

public class JohnsonDemo {
    int INF = Integer.MAX_VALUE;
    // O(V*E)
    boolean bellmanFord(int V, ArrayList<int[]>[] adj, int[] h) {
        // connect an imaginary node with all the nodes with zero edge weight
        Arrays.fill(h, 0);

        for (int k = 0; k <= V; k++) {
            for (int u = 0; u < V; u++) {
                for (int[] e : adj[u]) {
                    int v = e[0], wt = e[1];

                    if (h[u] + wt < h[v]) {
                        if (k == V)
                            return true; // cycle is detected

                        h[v] = h[u] + wt;
                    }
                }
            }
        }

        return false;
    }

    // Dijkstra Algorithm
    public int[] dijkstra(int src, int V, ArrayList<int[]>[] adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] a) -> a[1])
        );

        pq.add(new int[] { src, 0 });
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], du = curr[1];

            // optimization
            if (du > dist[u])
                continue;

            for (int[] e : adj[u]) {
                int v = e[0], wt = e[1];

                if (du + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new int[] { v, dist[v] });
                }
            }
        }
        return dist;
    }

    
    public int[][] JohnsonAlgo(int V, ArrayList<int[]>[] adj) {
        // stores shortest path btw all the pairs
        int[][] d = new int[V][V];

        int[] h = new int[V];
        // Detect Negative Cycle and compute the distance of all the nodes from an imaginary node
        if (bellmanFord(V, adj, h)) {
            System.out.println("Negative Weight Cycle is Present");
            for (int[] di : d)
                Arrays.fill(di, INF);
            return d;
        }

        ArrayList<int[]>[] reweightedAdj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            reweightedAdj[i] = new ArrayList<>();
        }

        // reweight the edge
        for (int u = 0; u < V; u++) {
            for (int[] e : adj[u]) {
                int v = e[0], wt = e[1];
                reweightedAdj[u].add(new int[] { v, wt + h[u] - h[v] });
            }
        }

        for (int u = 0; u < V; u++) {
            int[] dist = dijkstra(u, V, reweightedAdj);

            for (int v = 0; v < V; v++) {
                if (dist[v] == INF) {
                    d[u][v] = INF;
                }
                else {
                    // restoring original distance
                    d[u][v] = dist[v] + h[v] - h[u];
                } 
            }
        }
        return d;
    }
}
