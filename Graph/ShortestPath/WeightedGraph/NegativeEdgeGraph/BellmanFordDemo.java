package ShortestPath.WeightedGraph.NegativeEdgeGraph;

import java.util.*;

public class BellmanFordDemo {
    // find the shortest distance from source node to every other node
    public void bellmanFord(int src, int dest, int V, ArrayList<int[]>[] adj) {
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // relaxing the each edge V-1 times
        for (int k = 0; k < V; k++) {
            for (int u = 0; u < V; u++) {
                for (int[] e : adj[u]) {
                    int v = e[0], wt = e[1];

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        if(k == V-1){ // negative edge cycle detected
                            System.out.println("Negative weight cycle is detected!");
                            return;
                        }

                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (i == src)
                continue;
            System.out.println("Shortest distance to node " +i+ "is " +dist[i]);
        }
    }
}
