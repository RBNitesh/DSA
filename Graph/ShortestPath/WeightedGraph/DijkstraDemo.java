package ShortestPath.WeightedGraph;

import java.util.*;

public class DijkstraDemo {
    static public int dijkstra(int src, int dest, int V, ArrayList<int[]>[] adj) {

        boolean[] vis = new boolean[V];

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                return a[1] - b[1];
            }
        );

        pq.add(new int[]{src, 0});
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int du = curr[1];

            if (u == dest)
                return du;

            vis[u] = true;

            for (int[] neigh : adj[u]) {
                int v = neigh[0];
                int wt = neigh[1];

                if (!vis[v] && du + wt < dist[v]) {
                    pq.add(new int[] { v, du + wt });
                    dist[v] = du + wt;
                }
            }
        }
        return -1;
    }
}
