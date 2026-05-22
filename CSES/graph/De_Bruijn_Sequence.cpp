/*
    Tag: De Brujin's Graph, Euler's Path, Heirholzer's Algo
*/

#include<bits/stdc++.h>
using namespace std;

vector<vector<pair<int,int>>> adj;
stack<int> st;

void heirholzersAlgorithm(int node){
    while(adj[node].size()){
        auto next = adj[node].back();
        adj[node].pop_back(); // directed edge

        heirholzersAlgorithm(next.first);

        st.push(next.second); // push the edge
    }
}

int main(){
    int n;
    cin >> n;

    int mask = (1 << (n-1)) - 1;

    adj.resize(1 << (n-1));
    for (int i = 0; i < (1 << (n-1)); i++){
        int u = i;

        // doing and operation with mask to keep node as n-1 bit.
        int v1 = (u << 1) & mask;       
        int v2 = ((u << 1) + 1) & mask; 

        // Store the target node and the bit we appended to get there
        adj[u].push_back({v1, 0});
        adj[u].push_back({v2, 1});
    }

    heirholzersAlgorithm(0);

    // prepend the starting state of n-1 zeros
    string base = "";
    for (int i = 1; i < n; i++)
        base += "0";

    // concatenate the edges of eulerian path in base string to get the final string
    while(!st.empty()){
        int top = st.top();
        base += to_string(top);
        st.pop();   
    }

    cout << base << "\n";
}