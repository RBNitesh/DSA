/*  
    Tag: Maximum tree matching
*/
#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> adj;

void dfs(int curr, int parent, vector<int> &dp0, vector<int> &dp1){
    dp0[curr] = 0;
    dp1[curr] = 0;

    for(int v : adj[curr]){
        if(v == parent)
            continue;
        dfs(v, curr, dp0, dp1);

        dp0[curr] += max(dp0[v], dp1[v]);
    }

    for(int v : adj[curr]){
        if(v == parent)
            continue;

        dp1[curr] = max(dp1[curr], 1 + (dp0[curr] - max(dp0[v], dp1[v])) + dp0[v]);
    }
}

int main(){
    int n;
    cin >> n;

    adj.resize(n + 1);

    for (int i = 1; i <= n - 1; i++){
        int a, b;
        cin >> a >> b;

        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    vector<int> dp0(n+1, 0), dp1(n + 1, 0);
    dfs(1, -1, dp0, dp1);

    cout << max(dp0[1], dp1[1]) << "\n";
}