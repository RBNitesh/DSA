#include<bits/stdc++.h>
using namespace std;
int M = (int)1e9 + 7;

// using dfs because it is given that graph is directed acyclic
int cntPaths(int curr, int dest, vector<int> &dp, vector<vector<int>> &adj){
    if(curr == dest)
        return 1;

    if(dp[curr] != -1)
        return dp[curr];

    int paths = 0;

    for(int next : adj[curr]){
        paths += cntPaths(next, dest, dp, adj);
        paths %= M;
    }

    return dp[curr] = paths;
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n + 1);
    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
    }

    vector<int> dp(n + 1, -1);
    int res = cntPaths(1, n, dp, adj);
    cout << res << "\n";
}