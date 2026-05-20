// Tag: Disjoint Set Union
#include<bits/stdc++.h>
using namespace std;

class DSU{
    public:
    vector<int> parent;
    vector<int> size;

    DSU(int n){
        parent.resize(n + 1);
        size.assign(n + 1, 1);

        for (int i = 1; i <= n; i++)
            parent[i] = i;
    }

    int find(int u){
        return parent[u] = (parent[u] == u) ? u : find(parent[u]);
    }

    void unite(int u, int v){
        int rootU = find(u), rootV = find(v);

        if(size[rootU] <= size[rootV]){
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        }
        else{
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }
};

int main(){
    int n, m;
    cin >> n >> m;

    DSU dsu(n);
    int components = n;
    int max_size = 0;

    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        if(dsu.find(u) != dsu.find(v)){ // if both node are the part of same component
            dsu.unite(u, v);
            components--;

            max_size = max(max_size, dsu.size[dsu.find(u)]);
        }

        cout << components << " " << max_size << "\n";
    }
}