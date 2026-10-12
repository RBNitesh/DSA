#include<bits/stdc++.h>
using namespace std;

using ll = long long;
#define sz 200005;

vector<int> adj[sz];
int n, q, u, v;
int value[sz];


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> q;

    for (int i = 1; i <= n; ++i){
        cin >> value[i];
    }

    // build the adjacency list
    for (int i = 1; i <= n - 1; ++i){
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

        
}