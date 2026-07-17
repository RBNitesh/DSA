package ShortestPath.WeightedGraph.NegativeEdgeGraph;

import java.util.*;

/*
    - Floyd-Warshall is all pairs shortest path algorithm.
    - It finds the shortest path btw each pair in the graph.
    - Suitable for dense graph. Where no. of edge is approx V^2
*/

public class FloydWarshallDemo {
    public void floydWarshall(int src, int dest, int V, int[][] edges) {
        int[][] dist = new int[V][V];

        for (int[] dist_i : dist) {
            Arrays.fill(dist_i, Integer.MAX_VALUE);
        }

        for (int i = 0; i < V; i++) {
            dist[i][i] = 0;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            int wt = e[2];

            dist[u][v] = dist[v][u] = wt;
        }

        for (int k = 0; k < V; k++) { // k is intermediate vertex
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        boolean hasNegativeCycle = false;
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle) {
            System.out.println("Graph consists of negative weight cycle. Therefore, shortest path btw pairs can not be find");
        }
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.println(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}