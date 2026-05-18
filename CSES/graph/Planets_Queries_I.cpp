#include<bits/stdc++.h>
using namespace std;

bool dfs(int i, int curr, vector<int> &cycleLen, vector<bool> &vis, vector<bool> &vis1, vector<int> &teleport){
    vis[curr] = true;
    vis1[curr] = true;

    int next = teleport[curr];

    if(vis[next])
        return;

    if(!vis1[next]){
        dfs(i + 1, next, cycleLen, vis, vis1, teleport);
        if(cycleLen[next] != 0)
            cycleLen[curr] = cycleLen[next];
    }

    vis1[curr] = false;
    return false;
}

int main(){
    int n, q;
    cin >> n >> q;

    vector<int> teleport(n + 1);
    for (int i = 1; i <= n; i++){
        cin >> teleport[i];
    }

    vector<int> cycleLen(n + 1);
    vector<bool> vis(n + 1);
    vector<bool> vis1(n + 1);

    for (int i = 1; i <= n; i++){
        if(!vis[i]){
            dfs(1, i, cycleLen, vis, vis1, teleport);
        }
    }

    for(int it : cycleLen)
        cout << it << " ";
    cout << "\n";

    for (int i = 1; i <= q; i++){
        int x, k;
        cin >> x >> k;

        int curr = x;
        while(k > 0){
            if(cycleLen[curr] > 0){
                k %= cycleLen[curr];
            }
            if(k > 0){
                curr = teleport[curr];
                k--;
            }
        }

        cout << curr << "\n";
    }
}