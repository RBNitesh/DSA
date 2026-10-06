#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

class TreeDistanceII{
    int n;
    vector<vector<int>> adj;
    vector<int> nodesInBranch;
    vector<ll> ans;

public:
    TreeDistanceII(int n){
        this->n = n;
        adj.resize(n + 1);
        nodesInBranch.assign(n + 1, 0);
        ans.assign(n + 1, 0);
    }

    void addEdge(int u, int v){
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    /*  
    steps:
        step1: Remove the contribution of curr subtree from parent ans
        step2: Add the no. of nodes in tree that are not present in curr subtree to the ans
                because distance to those nodes from the curr node would be (1 + distance from parent node)
        step3: Add the sum of distance to the nodes present in curr subtree
    
    Recurrence Derivation:
        ans[node] = ans[parent] + N - 2 * nodesInBranch[node]

        N - 2 * nodesInBranch[node] = (N - nodesInBranch[node])
                                -(ans[node] + nodesInBranch[node])
                                + ans[node] 

        N - nodesInBranch[node] = No. of nodes in the tree which are not part of current subtree
        ans[node] + nodesInBranch[node] = Contribution of curr subtree in parent answer
        ans[node] = sum of distances to all nodes in the curr subtree from the node
    */

    void solve(int node, int parent){
        ans[node] = ans[parent] + n - 2 * nodesInBranch[node];
        
        for(int v : adj[node]){
            if(v != parent)
                solve(v, node);
        }
    }

    ll calculateDistanceSum(int node, int parent){
        ll dsum = 0;

        for(int v : adj[node])
            if(v != parent)
                dsum += calculateDistanceSum(v, node) + nodesInBranch[v];
        
        return dsum;
    }

    void countNodesInBranch(int node, int parent){
        nodesInBranch[node] = 1;
        for(int v : adj[node]){
            if(v == parent)
                continue;
            countNodesInBranch(v, node);
            nodesInBranch[node] += nodesInBranch[v];
        }
    }

    void findDistance(){
        countNodesInBranch(1, -1); // count nodes in each branch

        ans[1] = calculateDistanceSum(1, -1); // calculate the sum of distance to other nodes for root node

        for(int v : adj[1])
            solve(v, 1);

        for (int i = 1; i <= n; ++i)
            cout << ans[i] << " ";
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    TreeDistanceII td2(n);

    for (int i = 1; i < n; i++){
        int u, v;
        cin >> u >> v;

        td2.addEdge(u, v);
    }

    td2.findDistance();
}