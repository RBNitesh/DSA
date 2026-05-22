#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<vector<pair<int,int>>> connections;
vector<ll> dp;

ll dfs(int node, int dest){
    if(node == dest){
        return (ll)1e9 + 1;
    }

    if(dp[node] != -1)
        return dp[node];

    ll ans = 0;
    for(auto& next : connections[node]){
        int v = next.first;

        ans += min((ll)next.second, dfs(v, dest));
    }

    return dp[node] = ans;
}

int main(){
    int n, m;
    cin >> n >> m;

    connections.resize(n + 1);
    for (int i = 1; i <= m; i++){
        int u, v, w;
        cin >> u >> v >> w;

        connections[u].push_back({v, w});
    }

    ll ans = dfs(1, n);

    cout << ans << "\n";
}