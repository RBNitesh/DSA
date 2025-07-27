import java.util.ArrayList;
import java.util.PriorityQueue;

public class ShortestPath {
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    
    //main method
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // This algo doesn't work properly in case of negative edge weight
        dijkstra(graph, 0, V);
        // This algo doesn't work in case of negative weight cycle
        bellmanFord(graph, 0, V);
    }
    
    private static void bellmanFord(ArrayList<Edge>[] graph, int src, int V){
        int[] dist = new int[V];
        for(int i=0; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int k=0; k<V-1; k++){
            for(int i=0; i<V; i++){
                for(int j=0; j<graph[i].size(); j++){
                    Edge e = graph[i].get(j);
 
                    int u = e.src, v = e.dest;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+ " ");
        }
        System.out.println();
    }

    private static void dijkstra(ArrayList<Edge>[] graph, int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int[] dist = new int[V];
        for(int i=0; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] isVis = new boolean[V];
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            
            if(!isVis[curr.node]){
                isVis[curr.node] = true;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);

                    int u = e.src, v = e.dest;
                    if(dist[u]+e.wt < dist[v]){
                        dist[v] = dist[u]+e.wt;
                        pq.add(new Pair(v, dist[v])); 
                    }
                }
            }
        }

        for(int i=0; i<V; i++){
            System.out.print(dist[i]+ " ");
        }
        System.out.println();
    }

    private static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 2, 2));
        graph[1].add(new Edge(1, 0, 3));
        graph[1].add(new Edge(1, 4, 5));
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 3, 7));
        graph[2].add(new Edge(2, 5, 1));
        graph[3].add(new Edge(3, 2, 7));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 8));
        graph[4].add(new Edge(4, 1,5));
        graph[4].add(new Edge(4, 3, 1));
        graph[5].add(new Edge(5, 2, 1));
        graph[5].add(new Edge(5, 3, 8));
    }
}
