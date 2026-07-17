/*
    Tag: Hamiltonian Path
    Note: Determining a graph has hamiltonian path/cycle is a NP-Complete problem.
        As the no. of nodes grows it becomes hard to solve the problem. There is no
        known efficient formula to compute a solution in polynomial time.
        
*/

#include<bits/stdc++.h>
using namespace std;
int M = (int)1e9 + 7;

vector<vector<int>> adj;
vector<vector<int>> dp;

int cntHamiltonianPaths(int node, int mask, int dest, int n){
    if(node == dest){
        return mask == (1 << n) - 1;
    }

    if(dp[node][mask] != -1)
        return dp[node][mask];

    int paths = 0;
    for(int v : adj[node]){
        if(mask & (1 << (v-1)))
            continue;

        paths += cntHamiltonianPaths(v, mask | (1 << (v-1)), dest, n);
        paths %= M;
    }

    return dp[node][mask] = paths;
}

int main(){
    int n, m;
    cin >> n >> m;

    adj.resize(n + 1);
    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
    }

    dp.resize(n + 1, vector<int>(1<<n, -1));
    int mask = 0;
    int paths = cntHamiltonianPaths(1, mask | (1 << 0), n, n);
    cout << paths << "\n";
}