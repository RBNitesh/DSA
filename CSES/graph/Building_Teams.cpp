#include<bits/stdc++.h>
using namespace std;

// Bipartite graph: If nodes can be divided into two subsets such that there 
// is no two node u and v, where u and v belong to different subsets and their
// is an edge btw them. 
int main(){
    int n, m;
    cin >> n >> m;

    vector<set<int>> adj(n+1);

    for (int i = 0; i < m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].emplace(v);
        adj[v].emplace(u);
    }

    vector<int> team(n+1, -1);
    bool isImpossible = false;

    for (int i = 1; i <= n; i++){
        if(team[i] != -1) continue;

        queue<int> q;
        q.push(i);
        team[i] = 1;

        while(!q.empty()){
            int u = q.front();
            q.pop();
            
            for(int v : adj[u]){
                if(team[v] == -1){
                    team[v] = (team[u] == 1) ? 2 : 1;
                    q.push(v);
                }
                else if(team[v] != team[u])
                    continue;
                else{
                    isImpossible = true;
                    break;
                }
            }
        }
        if(isImpossible)
            break;
    }
    
    if(isImpossible){
        cout << "IMPOSSIBLE" << "\n";
    }
    else{
        for (int i = 1; i <= n; i++){
            if(i > 1)
                cout << " ";
            cout << team[i];
        }
        cout << "\n";
    }
}