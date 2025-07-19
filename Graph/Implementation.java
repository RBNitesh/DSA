import java.util.*;
public class Implementation {
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

    static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2, 5));
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 2,10));
        graph[2].add(new Edge(2, 3, 0));
        graph[2].add(new Edge(2, 1, 7));
        graph[3].add(new Edge(3, 2, 4));
        graph[3].add(new Edge(3, 1, 9));
    }

    private static void bfsTraversal(ArrayList<Edge>[] graph, boolean isVisited[], int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.poll();
            // if the curr node is not visited
            if(!isVisited[curr]){
                System.out.print(curr + " ");
                // add all the neighbours to the queue
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
                // mark the node as visited
                isVisited[curr] = true;
            }
        }
    }


    private static void dfsTraversal(ArrayList<Edge>[] graph, int curr, boolean[] isVisited){
        System.out.print(curr+ " ");
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            
            if(!isVisited[e.dest]){
                dfsTraversal(graph, e.dest, isVisited);
            }
        }
    }


    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // for(int i=0; i<graph[1].size(); i++){
        //     Edge e = graph[1].get(i);
        //     System.out.println(e.src+" "+e.dest+" "+e.wt);
        // }

        boolean[] isVisited = new boolean[V];
        
        // for(int i=0; i<V; i++){
        //     bfsTraversal(graph, isVisited, i);
        // }

        dfsTraversal(graph, 0, isVisited);
    }
}