#include<bits/stdc++.h>
using namespace std;

int helper(int node, int prev, vector<bool> &vis, vector<int> &parent, vector<set<int>> &adj){
    vis[node] = true;

    for(int neigh : adj[node]){
        if(neigh == prev) continue;

        parent[neigh] = node;

        if(!vis[neigh]){
            int ans = helper(neigh, node, vis, parent, adj);
            if(ans != -1) return ans;
        }
        else
            return neigh;
    }

    return -1;
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

    vector<bool> vis(n + 1);
    vector<int> parent(n + 1);

    int startNode = -1;
    for (int i = 1; i <= n; i++){
        if(!vis[i]){
            parent[i] = -1;
            startNode = helper(i, -1, vis, parent, adj);

            if(startNode != -1)
                break;
        }
    }

    if(startNode == -1){
        cout << "IMPOSSIBLE" << "\n";
    }

    else{
        vector<int> path;
        path.push_back(startNode);
        int lastNode = parent[startNode];

        while(lastNode != startNode){
            path.push_back(lastNode);
            lastNode = parent[lastNode];
        }

        path.push_back(startNode);

        cout << path.size() << "\n";

        for (size_t i = 0; i < path.size(); i++){
            if(i > 0)
                cout << " ";
            cout << path[i];
        }
        cout << "\n";
    }
}
