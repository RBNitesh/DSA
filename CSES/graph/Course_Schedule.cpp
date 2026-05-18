// Tag: Topological Sorting
#include<bits/stdc++.h>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n + 1);
    vector<int> indegree(n + 1);

    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        indegree[v]++;
    }

    vector<int> eleInOrder;
    queue<int> q;
    for (int i = 1; i <= n; i++){
        if(indegree[i] == 0){
            eleInOrder.push_back(i);
            q.push(i);
        }
    }

    bool isCycle = false;
    while(!q.empty()){
        int u = q.front();
        q.pop();

        for(int v : adj[u]){
            // case: 1 -> 2 -> 1
            if(indegree[v] == 0){ 
                isCycle = true;
                break;
            }
            if(--indegree[v] == 0){
                q.push(v);
                eleInOrder.push_back(v);
            }
        }
        if(isCycle)
            break;
    }

    if(isCycle || (int)eleInOrder.size() < n){
        cout << "IMPOSSIBLE" << "\n";
    }
    else{
        for (int i = 0; i < (int)eleInOrder.size(); i++){
            if(i > 0)
                cout << " ";
            cout << eleInOrder[i];
        }
        cout << "\n";
    }
}