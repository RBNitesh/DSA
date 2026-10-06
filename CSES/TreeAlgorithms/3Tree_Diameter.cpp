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

    // int dfs(int curr, int parent, int &res){
    //     int maxi = 0, secondMax = 0;
    //     for(int v : adj[curr]){
    //         if(v == parent) continue;

    //         int depth = dfs(v, curr, res);

    //         // find top two subtree with highest depth
    //         if(depth >= maxi){
    //             secondMax = maxi;
    //             maxi = depth;
    //         }
    //         else if(depth > secondMax){
    //             secondMax = depth;
    //         }
    //     }
    //     res = max(res, maxi + secondMax);
    //     return 1 + maxi;
    // }

    pair<int,int> bfs(int root){
        int totalNodes = adj.size();
        int farthestNode;

        vector<bool> vis(totalNodes + 1, false);

        vector<int> vec; // using as queue
        vec.reserve(totalNodes + 1);

        int tail = 0;
        vec.push_back(root);
        vis[root] = true;

        int level = 0;
        while(tail < vec.size()){
            int cnt = vec.size() - tail;

            while(cnt-- > 0){
                int u = vec[tail++];

                farthestNode = u;

                for(int v : adj[u]){
                    if(!vis[v]){
                        vec.push_back(v);
                        vis[v] = true;
                    }
                }
            }
            ++level;
        }

        return {farthestNode, level - 1};
    }

    void findDiameter(){
        int res = 0;
        // using dfs
        // dfs(1, -1, res); // root = 1

        // using bfs
        pair<int,int> farthestNodeAndDistance = bfs(1);
        pair<int,int> otherEndsNodeAndDistance =  bfs(farthestNodeAndDistance.first);
        res = otherEndsNodeAndDistance.second;

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

    td.findDiameter();
}