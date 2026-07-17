#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> adj;

void dfs(int curr, vector<int> &dp){
    dp[curr] = 0;
    for(int v : adj[curr]){
        dfs(v, dp);
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
        if(i > 1)
            cout << " ";
        cout << dp[i];
    }
    cout << "\n";
}