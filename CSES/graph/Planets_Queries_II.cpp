// Link: https://github.com/yash7xm/cp_notes/blob/master/cses/graphs/Planets%20Queries%20II.pdf
// Tag: Binary Lifting + DFS
#include<bits/stdc++.h>
using namespace std;

int LOG = 20; // 2^20 > 2*1e5

vector<vector<int>> up; // up[node][j]: node reached by taking (1<<j) jump from node
vector<int> teleporter; 
vector<int> dist; // dist[node]: distance to the cycle entry point from node
vector<bool> vis; // used for dfs

// return node reach after taking k jumps from a
int jump(int a, int k){
    while(k > 0){   
        int bit = __builtin_ctz(k);
        a = up[a][bit];
        k &= k - 1;
    }
    return a;
}

void dfs(int node){
    vis[node] = true;

    if(!vis[teleporter[node]])
        dfs(teleporter[node]); // call to next node

    // distance of cycle entry point from node
    dist[node] = dist[teleporter[node]] + 1;

    up[node][0] = teleporter[node];

    for (int j = 1; j < LOG; j++){ // binary lifting
        up[node][j] = up[up[node][j - 1]][j - 1];
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, q;
    cin >> n >> q;

    up.resize(n+1, vector<int>(20));
    teleporter.resize(n + 1);
    dist.assign(n + 1, 0); 
    vis.assign(n + 1, false); 

    for (int i = 1; i <= n; i++){
        cin >> teleporter[i];
    }

    for (int i = 1; i <= n; i++){
        if(!vis[i])
            dfs(i);
    }

    for (int i = 1; i <= q; i++){
        int a, b;
        cin >> a >> b;

        int cycle_entry_a = jump(a, dist[a]);
    
        int ans;
        // case1: b is coming a route from a to cycle_entry_a
        if(jump(a, dist[a] - dist[b]) == b){
            ans = dist[a] - dist[b];
        }
        // case2: b is in the cycle and reachable from a
        else if (jump(cycle_entry_a, dist[cycle_entry_a] - dist[b]) == b){
            // dist[a]: distance from a to cycle entry point
            // dist[cycle_entry_a] - dist[b]: distance from cycle entry point to b
            ans = dist[a] + (dist[cycle_entry_a] - dist[b]);
        }
        else
            ans = -1;

        cout << ans << "\n";
    }
}