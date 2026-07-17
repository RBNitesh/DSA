import java.util.*;

// Condition for Bipartite graph: It must not contain any odd length cycle.
class DemoBipartite{
    public boolean isBipartite(ArrayList<Integer>[] adj){
        int V = adj.length;

        int[] set = new int[V];
        Arrays.fill(set, -1);

        for (int i = 0; i < V; i++) {
            if (set[i] != -1)
                continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            set[i] = 1;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v : adj[u]) {
                    if (set[v] == -1) {
                        set[v] = (set[u] == 1) ? 2 : 1;
                        q.add(v);
                    } 
                    else if (set[v] != set[u]) {
                        continue;
                    } 
                    else
                        return false;
                }
            }
        }
        return true;
    }
}