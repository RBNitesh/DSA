#include<bits/stdc++.h>
using namespace std;

void printPath(int node, vector<int> &parent){
    vector<int> path;
    while(node != -1){
        path.push_back(node);
        node = parent[node];
    }
    reverse(path.begin(), path.end());

    for (int i = 0; i < path.size(); i++){
        if(i > 0)
            cout << " ";
        cout << path[i];
    }
    cout << "\n";
}

void bfs(int src, int target, vector<set<int>> &adj){

    vector<int> parent(adj.size());

    vector<bool> vis(adj.size());
    queue<int> q;
    q.push(src);
    vis[src] = true;
    parent[src] = -1;

    int level = 1;

    while(!q.empty()){
        int N = q.size();

        for (int k = 0; k < N; k++){
            int u = q.front();
            q.pop();

            if(u == target){
                cout << level << "\n";
                printPath(target, parent);
                return;
            }

            for(int v : adj[u]){
                if(!vis[v]){
                    q.push(v);
                    vis[v] = true;
                    parent[v] = u;
                }
            }
        }
        ++level;
    }
    cout << "IMPOSSIBLE" << "\n";
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<set<int>> adj(n+1);

    for (int i = 0; i < m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].emplace(v);
        adj[v].emplace(u);
    }

    bfs(1, n, adj);
}