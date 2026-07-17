#include<bits/stdc++.h>
using namespace std;

int dfs(int node, vector<int> &parent, vector<bool> &localVis, vector<bool> &vis, vector<vector<int>> &adj){

    vis[node] = true;
    localVis[node] = true;

    for(int v : adj[node]){
        parent[v] = node;

        if(!localVis[v]){
            if(vis[v])
                continue;

            int stPoint = dfs(v, parent, localVis, vis, adj);
            if(stPoint != -1)
                return stPoint;
        }
        else
            return v;
    }

    localVis[node] = false;
    return -1;
}

int main(){
    // fast io
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> adj(N + 1);
    for (int i = 1; i <= M; i++){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
    }

    vector<bool> vis(N + 1);
    vector<int> parent(N + 1, -1);
    int cycleStartPoint = -1;
    vector<bool> localVis(N + 1);

    for (int u = 1; u <= N; u++){
        if(!vis[u]){
            cycleStartPoint = dfs(u, parent, localVis, vis, adj);
            if(cycleStartPoint != -1)
                break;
        }
    }

    if(cycleStartPoint == -1)
        cout << "IMPOSSIBLE";

    else{
        vector<int> paths;
        int curr = cycleStartPoint;

        do{
            paths.push_back(curr);
            curr = parent[curr];
        } while (curr != cycleStartPoint);

        paths.push_back(cycleStartPoint);

        reverse(paths.begin(), paths.end());

        cout << paths.size() << "\n";
        for (int i = 0; i < paths.size(); i++){
            if(i > 0)
                cout << " ";
            cout << paths[i];
        }
        cout << "\n";
    }
}