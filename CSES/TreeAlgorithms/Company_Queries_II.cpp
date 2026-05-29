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

        for (int i = LOG; i >= 0; i--){
            if(up[u][i] != up[v][i]){
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }

    void computeDepth(int root, vector<int> &level, const vector<vector<int>> &adj){
        queue<int> q;
        q.push(root);
        level[root] = 0;
        
        while(!q.empty()){
            int u = q.front();
            q.pop();
            
            for(int v : adj[u]){
                level[v] = 1 + level[u];
                q.push(v);
            }
        }
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<int> parent(n + 1);
    parent[1] = -1;

    for (int i = 2; i <= n; i++){
        cin >> parent[i];
    }

    // build the adj
    vector<vector<int>> adj(n + 1);
    for (int i = 1; i <= n; i++){
        int pi = parent[i];
        if(pi != -1){
            adj[pi].push_back(i);
        }
    }

    BinaryLifting obj(n, parent);

    vector<int> level(n + 1, 0);
    obj.computeDepth(1, level, adj);

    // query processing
    while(q-- > 0){
        int a, b;
        cin >> a >> b;

        if(level[a] < level[b])
            swap(a, b);

        int diff = level[a] - level[b];
        a = obj.jump(a, diff);

        cout << obj.commonAncestor(a, b) << "\n";
    }
}