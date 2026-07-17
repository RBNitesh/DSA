#include<bits/stdc++.h>
using namespace std;

void bfs(int node, vector<vector<int>> &adj, vector<bool> &vis){
    queue<int> q;
    q.push(node);
    vis[node] = true;

    while(!q.empty()){
        int u = q.front();
        q.pop();

        for(int neigh : adj[u]){
            if(!vis[neigh]){
                q.push(neigh);
                vis[neigh] = true;
            }
        }
    }
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n);

    for (int i = 0; i < m; i++){
        int u, v;
        cin >> u >> v;

        adj[u-1].push_back(v-1);
        adj[v-1].push_back(u-1);
    }

    vector<int> junctions;

    vector<bool> vis(n, false);
    for (int i = 0; i < n; i++){
        if(!vis[i]){
            bfs(i, adj, vis);
            junctions.push_back(i+1); // 1-indexed
        }
    }

    int noOfComponents = junctions.size();

    if(noOfComponents == 1){
        cout << 0 << "\n";
    }
    else{
        cout << noOfComponents-1 << "\n";

        for (int i = 0; i < noOfComponents-1; i++){
            cout << junctions[i] << " " << junctions[i + 1] << "\n";
        }
    }
}