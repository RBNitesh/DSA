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

    void computeMaxDist(int curr, int parent, int longestTailOfParent){
        maxDist[curr] = max(depth[curr], 1 + longestTailOfParent); 

        int n = adj[curr].size(); // total brachs

        // stores length of longest branch in right
        vector<int> suffMax; 
        // stores length of longest brach in left
        vector<int> preMax;

        suffMax.reserve(n+1);
        preMax.reserve(n+1);

        int mx = -1;
        for (int i = 0; i < n; ++i){
            int v = adj[curr][i];

            if(v == parent)
                continue;

            preMax.push_back(mx);
            mx = max(mx, depth[v]);
        }

        mx = -1;
        for (int i = n - 1; i >= 0; --i){
            int v = adj[curr][i];

            if(v == parent)
                continue;

            suffMax.push_back(mx);
            mx = max(mx, depth[v]);
        }

        // reverse the suffMax to get the same ordering
        reverse(suffMax.begin(), suffMax.end());
        int idx = 0;

        // for every node except parent, find the maximum of 
        // longest branch in left and longest branch in right
        for (int i = 0; i < n; ++i){
            int v = adj[curr][i];

            if(v == parent)
                continue;

            int longestTailOfCurrNode = max({preMax[idx], suffMax[idx], longestTailOfParent}) + 1;

            computeMaxDist(v, curr, longestTailOfCurrNode);

            ++idx;
        }

        // for (int i = 0; i < n; i++)
        // {
        //     int v = adj[curr][i];
        //     if(v == parent){
        //         preMax[i + 1] = max(preMax[i], 0);
        //     }
        //     else{
        //         preMax[i + 1] = max(preMax[i], depth[v]);
        //     }
        // }

        // for(int i = n-1; i >= 0; --i){
        //     int v = adj[curr][i];
        //     if(v == parent){
        //         suffMax[i] = max(suffMax[i + 1], 0);
        //     }
        //     else{
        //         suffMax[i] = max(suffMax[i + 1], depth[v]);
        //     }
        // }

        // for (int i = 0; i < n; i++)
        // {
        //     int v = adj[curr][i];
        //     if (v == parent)
        //         continue;
        //     computeMaxDist(v, curr, 1 + max({preMax[i], suffMax[i + 1], partialAns}));
        // }
    }

    // compute depth and for nodes
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

    void maxDistanceToAnyNode(){
        computeDepth(1, -1);
        computeMaxDist(1, -1, -1); // node, parent, longestTailOfParent

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