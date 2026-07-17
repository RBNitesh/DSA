#include<bits/stdc++.h>
using namespace std;

class BinaryLifting {
    vector<vector<int>> up;
    int LOG;
public:
    BinaryLifting(int &n, vector<int> &parent) {
        LOG = 0;
        while((1<<LOG) < n)
            ++LOG;
 
        up.resize(n+1, vector<int>(LOG+1));
 
        for(int v = 1; v <= n; v++){
            up[v][0] = parent[v];
        }
 
        for(int j = 1; j <= LOG; j++){
            for(int v = 1; v <= n; v++){
                if(up[v][j-1] != -1)
                    up[v][j] = up[ up[v][j-1] ][j-1];
                else
                    up[v][j] = -1;
            }
        }
    }
    
    int jump(int node, int k) {
        for(int i = LOG; i >= 0; i--){
            if((k & (1 << i)) != 0){
                if(node != -1)
                    node = up[node][i];
                else 
                    break;
            }
        }
        return node;
    }
 
    int commonAncestor(int u, int v){
        if(u == v)
            return u;

        // Jump together, stopping just below the LCA
        for (int i = LOG; i >= 0; i--){
            if(up[u][i] != up[v][i]){
                u = up[u][i];
                v = up[v][i];
            }
        }
        // Return the direct parent of our stopping point
        return up[u][0];
    }
};

void bfs(int root, vector<int> &level, vector<int> &parent, vector<vector<int>> &adj){
    queue<int> q;
    q.push(root);

    parent[root] = -1;
    level[root] = 0;

    while(!q.empty()){
        int u = q.front();
        q.pop();

        for(int v : adj[u]){
            if(v != parent[u]){
                q.push(v);
                parent[v] = u;
                level[v] = 1 + level[u];
            }
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<vector<int>> adj(n + 1);
    for (int i = 2; i <= n; i++){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<int> parent(n+1);
    vector<int> level(n + 1, 0);
    bfs(1, level, parent, adj);

    // for(int it : parent)
    //     cout << it << " ";
    // cout << "\n";

    // instantiate BinaryLifting class
    BinaryLifting obj(n, parent);

    while(q-- > 0){
        int a, b;
        cin >> a >> b;

        int org_a = a;
        int org_b = b;

        if(level[a] < level[b])
            swap(a, b);

        int diff = level[a] - level[b];
        a = obj.jump(a, diff);

        // int dist = diff + (level[a] - level[obj.commonAncestor(a, b)]) * 2;

        int lca = obj.commonAncestor(a, b);
        int dist = level[org_a] + level[org_b] - 2 * level[lca];

        cout << dist << "\n";
    }
}