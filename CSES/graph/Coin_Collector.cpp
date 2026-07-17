/*
Steps:
1. Using Kosaraju Algorithm find all the strongly connected component.
2. Level each node with respective component they belong to.
4. Compute coins for each comp by adding the coins of all the nodes in that component.
3. Now treat each SCC as a single node. It will form a Directed Acyclic Graph.
4. Now, graph is converted into DAG. 
5. Now, we have two option either we can use dijkstra or perform topsort then use dp/dijkstra using queue.
*/

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<int> coins;
vector<vector<int>> adj, revAdj, dag;
stack<int> st, topo;
vector<bool> vis, seen;
vector<int> comp;

void toposort(int node){
    if(seen[node])
        return;

    seen[node] = true;

    for(int v : dag[node])
        toposort(v);

    topo.push(node);
}

void dfs(int node, int compId){
    if(comp[node] != 0)
        return;

    comp[node] = compId;
    
    for(int v : revAdj[node]){
        dfs(v, compId);
    }
}

// gets topological order 
void dfs(int node){
    if(vis[node])
        return;

    vis[node] = true;

    for(int v : adj[node])
        dfs(v);

    st.push(node);
}

int kosraju(int n){
    vis.assign(n + 1, false);

    for (int i = 1; i <= n; i++){
        if(!vis[i])
            dfs(i);
    }

    comp.assign(n + 1, 0);
    int compId = 0;
    while(!st.empty()){
        int top = st.top();
        
        if(comp[top] == 0){
            dfs(top, ++compId);
        }

        st.pop();
    }
    // since component is 1-indexed this is same as no. of components
    return compId; 
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, m;
    cin >> n >> m;

    coins.resize(n + 1);
    for (int i = 1; i <= n; i++){
        cin >> coins[i];
    }

    adj.resize(n + 1);
    revAdj.resize(n + 1);
    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        revAdj[v].push_back(u);
    }

    int comps = kosraju(n); // no. of components

    // computes the coins for each component
    vector<ll> compCoins(comps+1, 0L); // 1-indexed
    for (int u = 1; u <= n; u++){
        compCoins[comp[u]] += coins[u];
    }

    // construct the dag scc
    dag.resize(comps + 1); // 1-indexed
    for (int u = 1; u <= n; u++){
        for(int v : adj[u]){
            if(comp[u] != comp[v]){
                dag[comp[u]].push_back(comp[v]);
            }
        }
    }

    // performs topological sorting for dag of components
    seen.assign(comps + 1, false);
    for (int compId = 1; compId <= comps; compId++)
        if(!seen[compId])
            toposort(compId);

    // Dijkstra using queue
    // reason we can use dp is because graph is now DAG.
    vector<ll> dp(comps + 1);
    while(!topo.empty()){
        int u = topo.top();

        if(dp[u] == 0)
            dp[u] = compCoins[u];

        for(int v : dag[u]){
            dp[v] = max(dp[v], dp[u] + compCoins[v]);
        }

        topo.pop();
    }

    auto maxCoins = max_element(dp.begin(), dp.end());
    cout << *maxCoins << "\n";
}