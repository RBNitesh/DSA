package ShortestPath.WeightedGraph;

import java.util.*;

public class DijkstraDemo {
    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }
    
    static public int dijkstra(int src, int dest, int V, ArrayList<int[]>[] adj) {

        boolean[] vis = new boolean[V];

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int du = curr.dist;

            if (u == dest)
                return du;

            vis[u] = true;

            for (int[] neigh : adj[u]) {
                int v = neigh[0];
                int wt = neigh[1];

                if (!vis[v] && du + wt < dist[v]) {
                    pq.add(new Pair(v, du + wt));
                    dist[v] = du + wt;
                }
            }
        }
        return -1;
    }
}
