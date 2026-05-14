package TopologicalSorting;

import java.util.*;

// Class to represent a graph
class Graph {
    int V;
    List<Integer> adj[];

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<Integer>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // It is used to order the vertices of DAG
    // It finds the cycle in directed graph, if any.
    // Also, finds the shortest path from a src node to other nodes in O(V+E).
    // Efficient replacement of dijkstra in case of DAG
    public void topologicalSort() {
        int in_degree[] = new int[V];

        for (int i = 0; i < V; i++) {
            for (int node : adj[i]){
                in_degree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        List<Integer> topOrder = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];

        while (!q.isEmpty()) {
            int u = q.poll();
            topOrder.add(u);
            visited[u] = true;

            for (int node : adj[u]) {
                if (!visited[node]) {
                    if (--in_degree[node] == 0) {
                        q.add(node);
                    }
                } else {
                    System.out.println("Cycle detected in the graph");
                    return;
                }
            }
            cnt++;
        }

        if (cnt != V) {
            System.out.println("Cycle is present in the graph");
            return;
        }

        for (int i : topOrder) {
            System.out.print(i + " ");
        }
    }
}

public class topologicalSorting {
    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topological Sort function will run now");
        g.topologicalSort();
    }
}