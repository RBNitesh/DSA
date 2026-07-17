#include<bits/stdc++.h>
using namespace std;

struct Edge{
    int to;
    int cnt;
    int revIdx;
};

class Divic{
    vector<vector<Edge>> adj;
    vector<int> level;
    vector<int> ptr;

public:
    Divic(int n){
        adj.resize(n + 1);
        level.resize(n + 1);
        ptr.resize(n + 1);
    }

    void addEdge(int from, int to){ // undirected edge
        adj[from].push_back(Edge{to, 1, (int)adj[to].size()});
        adj[to].push_back(Edge{from, 1, (int)adj[from].size()-1});
    }

    bool bfs(int s, int t){
        fill(level.begin(), level.end(), -1);
        queue<int> q;
        q.push(s);
        level[s] = 0;

        while(!q.empty()){
            int u = q.front();
            q.pop();

            for(Edge &e : adj[u]){
                int v = e.to;

                if(e.cnt > 0 && level[v] == -1){
                    q.push(v);
                    level[v] = level[u] + 1;

                    if(v == t)
                        return true;
                }
            }
        }
        return level[t] != -1;
    }

    // Because every edge has an initial capacity of exactly 1, 
    // the bottleneck capacity of any augmenting path in the residual graph will always be exactly 1
    int dfs(int curr, int t){
        if(curr == t)
            return 1;

        for (int &i = ptr[curr]; i < adj[curr].size(); i++){
            Edge &e = adj[curr][i];
            int v = e.to;

            if(e.cnt > 0 && level[v] == level[curr] + 1){
                int push = dfs(v, t); // strictly returns <= 1

                if(push == 0)
                    continue;

                e.cnt -= 1;
                adj[e.to][e.revIdx].cnt += 1;
                return push;
            }
        }
        return 0;
    }

    void dfs(int curr, vector<bool> &reached){
        if(reached[curr])
            return;
        reached[curr] = true;

        for(Edge &e : adj[curr])
            if(e.cnt > 0)
                dfs(e.to, reached);
    }

    void minCut(int s, int t, int n){ // minimum no. of edge to cut for blocking the flow
        int cut = 0;
        while(bfs(s, t)){
            fill(ptr.begin(), ptr.end(), 0);
            while(dfs(s, t))
                cut++;
        }
        cout << cut << "\n";


        vector<bool> reached(n+1);
        dfs(s, reached);
        for (int u = 1; u <= n; u++){
            for(Edge &e : adj[u]){
                int v = e.to;
                // An edge is critical if it is from a node that can be reached to the node that cannot be reached
                if(reached[u] && !reached[v]){
                    cout << u << " " << v << "\n";
                }
            }
        }
    }
};

int main(){
    int n, m;
    cin >> n >> m;

    Divic divic(n);

    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        divic.addEdge(u, v);
    }

    divic.minCut(1, n, n);
}