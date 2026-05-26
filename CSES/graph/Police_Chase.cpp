#include<bits/stdc++.h>
using namespace std;

vector<set<int>> adj;
vector<vector<int>> edges;

void dfs(int u, vector<bool> &reached){
    if(reached[u])
        return;
    reached[u] = true;

    for(int v : adj[u])
        if(edges[u][v] > 0)
            dfs(v, reached);
}

bool bfs(int s, int t, vector<int> &parent){
    int n = parent.size();
    vector<bool> vis(n);
    queue<int> q;
    q.push(s);
    vis[s] = true;

    while(!q.empty()){
        int u = q.front();
        q.pop();

        for(int v : adj[u]){
            if(!vis[v] && edges[u][v] > 0){
                q.push(v);
                parent[v] = u;
                vis[v] = true;

                if(v == t)
                    return true;
            }
        }
    }
    return vis[t];
}

int main(){
    int n, m;
    cin >> n >> m;

    adj.resize(n + 1);
    edges.resize(n + 1, vector<int>(n+1));

    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].emplace(v);
        adj[v].emplace(u);

        edges[u][v] += 1;
        edges[v][u] += 1;
    }

    vector<int> parent(n + 1, -1);
    
    while(bfs(1, n, parent)){
        for (int v = n; v != 1; v = parent[v]){
            int u = parent[v];

            edges[u][v] -= 1;
            edges[v][u] += 1;
        }
    }

    vector<bool> reached(n + 1, false);
    dfs(1, reached);

    vector<pair<int, int>> edgeCut;
    for (int u = 1; u <= n; u++){
        for(int v : adj[u]){
            if(reached[u] && !reached[v]){
                edgeCut.push_back({u, v});
            }
        }
    }

    cout << edgeCut.size() << "\n";
    for(auto &it : edgeCut){
        cout << it.first << " " << it.second << "\n";
    }
}