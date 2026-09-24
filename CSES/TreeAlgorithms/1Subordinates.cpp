#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> adj;

// subordinate of a boss: number of employes works below the boss 

void dfs(int curr, vector<int> &dp){
    dp[curr] = 0;
    for(int v : adj[curr]){
        dfs(v, dp);
        // dp[v]: subordinate of node v
        // +1 is for node v. Because v will not be consider in subordinate of itself
        // but v is a subordinate of own parent
        dp[curr] += (1 + dp[v]);
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    adj.resize(n + 1);

    for (int i = 2; i <= n; i++){
        int boss;
        cin >> boss;

        adj[boss].push_back(i);
    }

    vector<int> dp(n + 1, -1);
    dfs(1, dp);

    for (int i = 1; i <= n; i++){
        cout << dp[i] << " ";
    }
    cout << "\n";
}