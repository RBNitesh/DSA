package MST;

import java.io.*;
import java.util.*;

// O(E*logE)
public class PrimsAlgo {

	// Function of spanning tree
	static int spanningTree(int V, int E, int edges[][]){
        ArrayList<int[]>[] adj = new ArrayList[V];
        // O(V)
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // O(E)
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0], v = edges[i][1];
            int w = edges[i][2];

            adj[u].add(new int[] { v, w });
            adj[v].add(new int[] { u, w });
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                return a[1] - b[1];
            }
        );

        pq.add(new int[]{0, 0});
        boolean[] vis = new boolean[V];
    
        int cost = 0;
        // E*logE
        while(!pq.isEmpty()){
            int[] curr = pq.poll(); // O(logE)
            // in dijkstra, curr[1]: Minimum distance to reach curr node from source node.
            // curr[1]: weight of curr edge
            int u = curr[0], uw = curr[1];
            
            if(vis[u]) 
            continue;
            
            cost += uw;
            vis[u] = true;
            
            for (int[] neigh : adj[u]) {
                int v = neigh[0];

                if (!vis[v])
                    // in dijkstra we not add {v, du + vw}. But, in prims algo {v, vw}.
                    pq.add(neigh); // O(log(E)
            }
        }
        return cost;
    }
    
    // Driver code
    public static void main (String[] args) {
        int graph[][] = new int[][] {{0,1,5},
                                    {1,2,3},
                                    {0,2,1}};
 
        // Function call
        System.out.println(spanningTree(3,3,graph));
    }
}