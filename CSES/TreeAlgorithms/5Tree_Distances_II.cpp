#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

class TreeDistanceII{
    vector<vector<int>> adj;
    vector<pair<ll, int>> dsum;
    vector<ll> ans;

public:
    // O(n)
    TreeDistanceII(int n){
        adj.resize(n + 1);
        dsum.assign(n + 1, {0, 0});
        ans.assign(n + 1, 0);
    }

    // O(1)
    void addEdge(int u, int v){
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    // O(n)
    void computeDistanceSum(int node, int parent){
        // sum of distances to all nodes, no. of nodes
        dsum[node] = {0, 0}; 

        for(int v : adj[node]){
            if(v == parent)
                continue;
            computeDistanceSum(v, node);
            dsum[node].first += dsum[v].first + dsum[v].second;
            dsum[node].second += dsum[v].second;
        }
        dsum[node].second += 1;
    }

    // O(n)
    void solve(int node, int parent, int &N){
        /*  
        steps:
            step1: Remove the contribution of curr subtree from parent ans
            step2: Add the no. of nodes in tree that are not present in curr subtree to the ans
                    because distance to those nodes from the curr node would be (1 + distance from parent node)
            step3: Add the sum of distance to the nodes present in curr subtree
        
        Recurrence Derivation:
            ans[node] = ans[parent] + N - 2*dsum[node].second

            N - 2*dsum[node].second = (N - dsum[node].second)
                                    -(dsum[node].first + dsum[node].second)
                                    + dsum[node].first 

            N - dsum[node].second = No. of nodes in the tree which are not part of current subtree
            dsum[node].first + dsum[node].second = Contribution of curr subtree in parent answer
            dsum[node].first = sum of distances to all nodes in the curr subtree from the node
        */
        ans[node] = ((parent != -1) ? ans[parent] : 0) + N - 2*dsum[node].second;

        for(int v : adj[node]){
            if(v == parent)
                continue;
            solve(v, node, N);
        }
    }

    // O(n)
    void findDistance(int n){
        // O(n)
        computeDistanceSum(1, -1); 
        // consider 0 as parent of 1
        // then sum of distances to all nodes from 0 to sum of distances to all node from 1 and no. of nodes
        ans[0] = dsum[1].first + dsum[1].second;
        // O(n)
        solve(1, 0, n);

        // O(n)
        for (int i = 1; i <= n; i++){
            if(i > 1)
                cout << " ";
            cout << ans[i];
        }
        cout << "\n";
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    // O(n)
    TreeDistanceII td2(n);

    // O(n)
    for (int i = 1; i < n; i++){
        int u, v;
        cin >> u >> v;

        td2.addEdge(u, v);
    }

    // O(n)
    td2.findDistance(n);
}