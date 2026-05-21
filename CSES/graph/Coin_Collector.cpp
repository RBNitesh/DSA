#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

stack<int> st;
vector<int> coins;
vector<vector<int>> adj;
vector<bool> vis;
vector<ll> dp;

ll collect(int node, int n){
    vector<ll> collection(n + 1);
    priority_queue<pair<ll,int>> pq;
    pq.push({coins[node], node});

    while(!pq.empty()){
        auto curr = pq.top();
        pq.pop();

        ll du = curr.second;
        int u = curr.first;
    }
}

void dfs(int node){
    if(vis[node])
        return;

    vis[node] = true;

    for(int v : adj[node])
        dfs(v);

    st.push(node);
}

int main(){
    int n, m;
    cin >> n >> m;

    dp.assign(n + 1, 0);
    coins.assign(n + 1, 0);
    adj.resize(n + 1);
    vis.assign(n + 1, false);

    for (int i = 1; i <= n; i++)
        cin >> coins[i];

    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
    }

    for (int i = 1; i <= n; i++)
        if(!vis[i])
            dfs(i);


    vis.assign(n + 1, false);
    ll maxCoins = 0;

    while(!st.empty()){
        int top = st.top();
        if(!vis[top]){
            maxCoins = max(maxCoins, collect(top));
        }
        st.pop();
    }

    cout << maxCoins << "\n";
}