#include<bits/stdc++.h>
using namespace std;

class BinaryLifting{
    vector<vector<int>> up;
    int LOG;

public:
    BinaryLifting(int n, vector<int> &parent){
        LOG = 0;
        while((1<<LOG) < n)
            ++LOG;

        up.resize(LOG + 1, vector<int>(n + 1, -1));

        for (int u = 1; u <= n; ++u){
            up[0][u] = parent[u];
        }

        for (int j = 1; j <= LOG; ++j){
            for (int u = 1; u <= n; ++u){
                if(up[j-1][u] != -1)
                    up[j][u] = up[j - 1][up[j - 1][u]];
                else continue;
            }
        }
    }

    int jump(int node, int k){
        for (int i = LOG; i >= 0; --i){
            if((k & (1 << i))){
                if(node == -1)
                    break;
                node = up[i][node];
            }
        }
        return node;
    }

    int lowestCommonAncestor(int u, int v){
        if(u == v)
            return u;

        // Jump together, stopping just below the LCA
        for (int i = LOG; i >= 0; --i){
            if(up[i][u] != up[i][v]){
                u = up[i][u];
                v = up[i][v];
            }
        }
        // Return the direct parent of stopping point
        return up[0][u];
    }
};

// computes level and parent for the nodes in tree
void bfs(int root, vector<int> &level, vector<int> &parent, vector<vector<int>> &adj){
    queue<int> q;
    q.push(root);

    level[root] = 0;
    parent[root] = -1;

    while(!q.empty()){
        int u = q.front();
        q.pop();

        for(int v : adj[u]){
            if(v != parent[u]){
                level[v] = 1 + level[u];
                parent[v] = u;
                q.push(v);
            }
        }
    }
}

// prefix sum in tree
void dfs(int node, int parent, vector<int> &pathCount, vector<vector<int>> &adj){
    for(int v : adj[node]){
        if(v != parent){
            dfs(v, node, pathCount, adj);
            pathCount[node] += pathCount[v];
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n + 1);
    for (int i = 1; i < n; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<int> level(n + 1, 0);
    vector<int> parent(n + 1);

    bfs(1, level, parent, adj);

    BinaryLifting obj(n, parent);

    vector<int> pathCount(n + 1, 0);
    while(m-- > 0){
        int a, b;
        cin >> a >> b;

        int org_a = a;
        int org_b = b;

        if(level[a] < level[b])
            swap(a, b);
        int diff = level[a] - level[b];
        a = obj.jump(a, diff);

        int lca = obj.lowestCommonAncestor(a, b);

        // using diff-array technique
        pathCount[org_a] += 1;
        pathCount[org_b] += 1;
        pathCount[lca] -= 1;
        if(parent[lca] != -1){
            pathCount[parent[lca]] -= 1;
        }
    }

    // for calculating prefix sum 
    dfs(1, parent[1], pathCount, adj);

    for (int i = 1; i <= n; i++){
        if(i > 1)
            cout << " ";
        cout << pathCount[i];
    }
    cout << "\n";
}