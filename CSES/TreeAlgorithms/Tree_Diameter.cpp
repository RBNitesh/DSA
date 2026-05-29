#include<bits/stdc++.h>
using namespace std;

class TreeDiameter{
    vector<vector<int>> adj;

    public:
    TreeDiameter(int n){
        adj.resize(n + 1);
    }

    void addEdge(int u, int v){
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int dfs(int curr, int parent, int &res){
        int maxi = 0, secondMax = 0;
        for(int v : adj[curr]){
            if(v == parent) continue;

            int depth = dfs(v, curr, res);

            // find top two subtree with highest depth
            if(depth >= maxi){
                secondMax = maxi;
                maxi = depth;
            }
            else if(depth > secondMax){
                secondMax = depth;
            }
        }
        res = max(res, maxi + secondMax);
        return 1 + maxi;
    }

    void findDiameter(int root){
        int res = 0;
        dfs(root, -1, res);
        cout << res << "\n";
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n;
    if(!(cin >> n)) return 0;

    TreeDiameter td(n);

    for (int i = 1; i < n; i++){
        int u, v;
        cin >> u >> v;

        td.addEdge(u, v);
    }

    td.findDiameter(1);
}