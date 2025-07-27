import java.util.*;

// This class implements a simple graph using an adjacency list
public class Implementation {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    // This function creates a graph with 4 vertices
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2, 5));
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 2,7));
        graph[2].add(new Edge(2, 0, 5));
        graph[2].add(new Edge(2, 1, 7));
        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 2, 0));
        graph[3].add(new Edge(3, 1, 3));
    }

    // This function performs BFS traversal on the graph
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

    // This function performs DFS traversal on the graph
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

    // This function prints all paths from source to target
    private static void printAll(ArrayList<Edge>[] graph, boolean[] isVisited, int curr, String path, int tar){
        if(curr==tar){
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!isVisited[e.dest]){
                isVisited[curr] = true;
                printAll(graph, isVisited, e.dest, path+e.dest, tar);
                isVisited[curr] = false;
            }
        }
    }

    // This function performs topological sorting on the graph
    // using Depth First Search (DFS) approach
    private static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, Stack<Integer> st){
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!isVisited[e.dest])
                topSortUtil(graph, e.dest, isVisited, st);
        }

        st.push(curr);
    }

    // This function initiates the topological sorting process
    private static void topSort(ArrayList<Edge>[] graph, int V) {
        boolean[] isVisited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++){
            if(!isVisited[i])
                topSortUtil(graph, i, isVisited, stack);
        }

        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }

    // function to check is Cycle exist in directed graph or not
    private static boolean isCycleDirected(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, boolean[] rec){
        isVisited[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);

            if(rec[e.dest])
                return true;

            if(!isVisited[e.dest])
                if(isCycleDirected(graph, e.dest, isVisited, rec))
                    return true;
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4; 

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        /*
            0
             \     3
              \  /   \
                2 --- 1 
        */

        // Print the graph edges
        // for(int i=0; i<graph[1].size(); i++){
        //     Edge e = graph[1].get(i);
        //     System.out.println(e.src+" "+e.dest+" "+e.wt);
        // }

        // It keeps track of visited nodes
        // for BFS and DFS traversal
        boolean[] isVisited = new boolean[V];

        // BFS traversal
        // for(int i=0; i<V; i++){
        //     if(!isVisited[i])
        //         bfsTraversal(graph, isVisited, i);
        // }

        // DFS traversal
        // for(int i=0; i<V; i++){
        //     if(!isVisited[i])
        //         dfsTraversal(graph, i, isVisited);
        // }

        // Print all paths from source to target
        // int src=0, tar=3;
        // printAll(graph, isVisited, src, "0", tar);
       
        // topological sorting
        // System.out.print("Topological Sort: ");
        // topSort(graph, V);

        // Cycle detection indirected graph
        boolean[] rec = new boolean[V];

        for(int i=0; i<V; i++){
            if(!isVisited[i]){
                boolean isCycle = isCycleDirected(graph, i, isVisited, rec);
                if(isCycle){
                    System.out.println("Cycle Detected");
                    break;
                }
                if(i== V-1) {
                    System.out.println("No Cycle Detected");
                }
            }
        }
    }
}