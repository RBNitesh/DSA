/*
    1. Calculate dist to cycle entry point from all the nodes
    2. Find all the cycle entry point condition: jump(node, dist[node]) == node
    3. Traverse all the reachable node from cycle entry point that is nodes in the
        cycle and for them ans will same as cycle length
    4. For those outside the cycle ans will be dist[node]
*/  
 
#include<bits/stdc++.h>
using namespace std;
 
vector<int> dist;
vector<int> vis;
vector<int> teleporter;
 
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    int n;
    cin >> n;

    dist.assign(n + 1, 0);
    vis.assign(n + 1, 0);
    teleporter.resize(n + 1);
 
    for (int i = 1; i <= n; i++){
        cin >> teleporter[i];
    }

    for (int i = 1; i <= n; i++){
        if(vis[i] != 0)
            continue;

        int curr = i;

        vector<int> arr;
        int cycle_entry;

        while(vis[curr] == 0){ 
            vis[curr] = 1;
            arr.push_back(curr);
            curr = teleporter[curr];
            cycle_entry = curr;
        }

        if(vis[curr] == 1){
            int cycle_start;

            for (size_t i = 0; i < arr.size(); i++){
                if(arr[i] == cycle_entry){
                    cycle_start = i;
                    break;
                }
            }

            int cycle_len = (int)arr.size() - cycle_start;

            for (size_t i = cycle_start; i < arr.size(); i++){
                dist[arr[i]] = cycle_len;
            }

            for (int i = cycle_start - 1; i >= 0; i--){
                dist[arr[i]] = ++cycle_len;
            }
        }
        else{ // vis[curr] == 2
            int cycle_len = dist[cycle_entry];

            for (int i = arr.size() - 1; i >= 0; i--){
                dist[arr[i]] = ++cycle_len;
            }
        }

        for(int node : arr){
            vis[node] = 2; // marked fully processed
        }
    }

    for (int i = 1; i <= n; i++){
        if(i > 1)
            cout << " ";
        cout << dist[i];
    }

    cout << "\n";
}