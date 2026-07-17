/*
    link: https://www.youtube.com/watch?v=soc05wkL28k&t=27s
*/

#include<bits/stdc++.h>
using namespace std;

typedef long long ll;

struct Edge{
    int to;
    ll flow;
    ll cap;
    int revIdx;
};

class DinicAlgo{
    vector<vector<Edge>> adj;
    vector<int> level;
    vector<int> ptr;

public:
    DinicAlgo(int n){
        adj.resize(n + 1);
        level.resize(n + 1);
        ptr.resize(n + 1);
    }

    void addEdge(int from, int to, ll cap){
        adj[from].push_back(Edge{to, 0, cap, (int)adj[to].size()}); // forward edge
        adj[to].push_back(Edge{from, 0, 0, (int)adj[from].size()-1}); // reverse edge
    }

    // build layered network
    bool bfs(int s, int t, ll capacity){
        fill(level.begin(), level.end(), -1);

        queue<int> q;
        q.push(s);
        level[s] = 0;

        while(!q.empty()){
            int u = q.front();
            q.pop();

            for(Edge &e : adj[u]){
                int v = e.to;

                if(e.cap-e.flow >= capacity && level[v] == -1){
                    q.push(v);
                    level[v] = level[u] + 1;

                    if(v == t)
                        return true; // early exit
                }
            }
        }
        return level[t] != -1;
    }

    // dfs to find the augmenting path and pushed flow
    ll dfs(int u, int t, ll pushed){
        if(pushed == 0)
            return 0;
        if(u == t)
            return pushed;

        // LAZY DELETION: ptr[v] simulates removing useless edges. 
        // We advance ptr[v] to skip dead ends without deleting from the vector.
        for (int &i = ptr[u]; i < adj[u].size(); i++){
            Edge &e = adj[u][i];
            int v = e.to;

            // only traverse edges that move to the next layer in the layered network
            // residual cap = e.cap - e.flow
            if(e.cap > e.flow && level[v] == level[u] + 1){
                ll push = dfs(v, t, min(pushed, e.cap-e.flow)); 

                if(push == 0) // reached the dead end
                    continue;

                e.flow += push;
                adj[v][e.revIdx].flow -= push;
                return push;
            }
        }
        return 0; // no augmenting path from this node
    }

    ll maxFlow(int s, int t, ll maxCap){
        ll maxFlow = 0;
        ll infinity = 1e18;

        ll delta = 1;
        while(delta * 2 <= maxCap)
            delta *= 2;

        // using scaling algo for further improvisation
        for (; delta >= 1; delta >>= 1){
            while(bfs(s, t, delta)){ // O(n)
                fill(ptr.begin(), ptr.end(), 0);

                while (ll pushed = dfs(s, t, infinity)){
                    maxFlow += pushed;
                }
            }
        }
        return maxFlow;
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    DinicAlgo dinic(n);
    ll maxCap = 0;

    for (int i = 1; i <= m; i++){
        int u, v;
        ll cap;
        cin >> u >> v >> cap;

        dinic.addEdge(u, v, cap);
        maxCap = max(maxCap, cap);
    }

    cout << dinic.maxFlow(1, n, maxCap) << "\n";
}