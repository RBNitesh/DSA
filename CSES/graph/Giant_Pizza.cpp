/*
    Tag: Kosaraju Algorithm, 2-SAT
*/
#include<bits/stdc++.h>
using namespace std;

unordered_map<int, vector<int>> graph, revGraph;
unordered_map<int, bool> vis;
stack<int> st;
unordered_map<int,int> assignment;

void dfs(int node, int level){
    if(vis[node])
        return;

    vis[node] = true;

    assignment[node] = level;

    for(int v : revGraph[node])
        dfs(v, level);
}

void dfs(int node){
    if(vis[node])
        return;

    vis[node] = true;

    for(int v : graph[node]){
        dfs(v);
    }

    st.push(node);
}

int main(){
    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++){
        string sign1, sign2;
        int x, y;

        cin >> sign1 >> x >> sign2 >> y;

        if(sign1 == "-")
            x = -x;
        if(sign2 == "-")
            y = -y;

        graph[-x].push_back(y);
        graph[-y].push_back(x);
        revGraph[y].push_back(-x);
        revGraph[x].push_back(-y);
    }

    for (int i = 1; i <= m; i++){
        if(!vis[i])
            dfs(i);
        if(!vis[-i])
            dfs(-i);
    }

    vis.clear();
    int level = 0;
    while(!st.empty()){
        int top = st.top();
        if(!vis[top]){
            dfs(top, ++level);
        }
        st.pop();
    }

    for (int i = 1; i <= m; i++){
        if(assignment[i] == assignment[-i]){
            cout << "IMPOSSIBLE\n";
            return 0;
        }
    }

    for (int i = 1; i <= m; i++){
        if(i > 1)
            cout << " ";
        cout << ((assignment[i] > assignment[-i]) ? "+" : "-");
    }
    cout << "\n";
}