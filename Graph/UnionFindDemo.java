import java.util.*;

class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int size){
        parent = new int[size];
        rank = new int[size];

        for(int i=0; i<size; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int u){
        if(parent[u] != u){
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public void union(int u, int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU != rootV){
            if(rank[rootU] < rank[rootV]){
                parent[rootU] = rootV;
            }
            else{
                parent[rootV] = rootU;

                if(rank[rootU] == rank[rootV]){
                    rank[rootU]++;
                }
            }
        }
    }
}

public class UnionFindDemo{
    public static void main(String[] args){
        UnionFind uf = new UnionFind(10);
    }
}