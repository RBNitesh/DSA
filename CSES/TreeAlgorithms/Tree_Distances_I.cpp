/*
    Tag: Tree Dp
*/

#include<bits/stdc++.h>
using namespace std;

class TreeDistanceI{
    vector<vector<int>> adj;
    vector<int> depth;
    vector<int> maxDist;

public:
    TreeDistanceI(int n){
        adj.resize(n + 1);
        depth.resize(n + 1);
        maxDist.resize(n + 1);
    }

    void addEdge(int u, int v){
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    void computeDepth(int curr, int parent){
        int d = 0;
        for(int v : adj[curr]){
            if(v == parent)
                continue;
            computeDepth(v, curr);
            d = max(d, 1 + depth[v]);
        }
        depth[curr] = d;
    }

    void computeMaxDist(int curr, int parent, int partialAns){
        maxDist[curr] = max(depth[curr], 1 + partialAns);

        int n = adj[curr].size();
        vector<int> suffMax(n+1, -1);
        vector<int> preMax(n+1, -1);

        for (int i = 0; i < n; i++)
        {
            int v = adj[curr][i];
            if(v == parent){
                preMax[i + 1] = max(preMax[i], -1);
            }
            else{
                preMax[i + 1] = max(preMax[i], depth[v]);
            }
        }

        for(int i = n-1; i >= 0; --i){
            int v = adj[curr][i];
            if(v == parent){
                suffMax[i] = max(suffMax[i + 1], -1);
            }
            else{
                suffMax[i] = max(suffMax[i + 1], depth[v]);
            }
        }

        for (int i = 0; i < n; i++)
        {
            int v = adj[curr][i];
            if(v == parent)
                continue;
            computeMaxDist(v, curr, 1 + max({preMax[i], suffMax[i + 1], partialAns}));
        }
    }

    void maxDistanceToAnyNode(){
        computeDepth(1, -1);
        computeMaxDist(1, -1, -1);

        for (int i = 1; i < (int)maxDist.size(); i++){
            if(i > 1)
                cout << " ";
            cout << maxDist[i];
        }
        cout << "\n";
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    TreeDistanceI td1(n);
    for (int i = 1; i < n; i++){
        int u, v;
        cin >> u >> v;

        td1.addEdge(u, v);
    }

    td1.maxDistanceToAnyNode();
}