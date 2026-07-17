/* 
    Note: This is not a functional graph.
    Tag: Kosaraju's Algorithm
    Original question: Find the no. of strongly connected component.
*/

#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> adj;
vector<vector<int>> reverse_adj;
vector<bool> vis;
stack<int> st;
vector<int> kingdom;

void dfs(int node, int level){
    if(vis[node])
        return;

    vis[node] = true;
    kingdom[node] = level;

    for(int v : reverse_adj[node]){
        dfs(v, level);
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

    kingdom.resize(n + 1);
    adj.resize(n + 1);
    reverse_adj.resize(n + 1);
    vis.assign(n + 1, false);

    for (int i = 1; i <= m; i++){
        int a, b;
        cin >> a >> b;

        adj[a].push_back(b);
        reverse_adj[b].push_back(a);
    }

    for (int i = 1; i <= n; i++)
        if(!vis[i])
            dfs(i);


    vis.assign(n + 1, false);

    int level = 0;
    while(!st.empty()){
        int top = st.top();
        // cout << top << "\n";
        if(!vis[top]){
            dfs(top, ++level);
        }
        st.pop();
    }

    cout << level << "\n";

    for (int i = 1; i <= n; i++){
        if(i > 1)
            cout << " ";
        cout << kingdom[i];
    }
    cout << "\n";
}