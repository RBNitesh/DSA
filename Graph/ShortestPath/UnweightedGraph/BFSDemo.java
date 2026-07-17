package ShortestPath.UnweightedGraph;

import java.util.*;

// O(V+E)
public class BFSDemo {
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
