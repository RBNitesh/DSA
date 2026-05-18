// find the longest path to reach dest from a source in a directed acyclic graph
#include<bits/stdc++.h>
using namespace std;

int longestPathToDest(int curr, int dest, vector<int> &dp, vector<int> &child, vector<vector<int>> &adj){
    if(curr == dest)
        return 1;

    if(dp[curr] != -2)
        return dp[curr];

    int ans = -1;

    for(int next : adj[curr]){
        int localAns = longestPathToDest(next, dest, dp, child, adj);
        if(localAns != -1 && 1 + localAns > ans){
            child[curr] = next;
            ans = localAns + 1;
        }
    }

    return dp[curr] = ans;
}

int main(){
    // fast io
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n + 1);
    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
    }

    vector<int> child(n + 1, -1);
    vector<int> dp(n + 1, -2);

    int pathLen = longestPathToDest(1, n, dp, child, adj);

    if(pathLen == -1){
        cout << "IMPOSSIBLE" << "\n";
    }
    else{
        cout << pathLen << "\n";
        int curr = 1;
        while(curr != n){
            cout << curr << " ";
            curr = child[curr];
        }
        cout << n << "\n";
    }
}