/*
    Tag: Bipartite Matching, Divic's Algo
    Note: Directed edge are used in Bipartite Matching
*/
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
 
    void addEdge(int from, int to){ 
        adj[from].push_back(Edge{to, 1, (int)adj[to].size()});
        adj[to].push_back(Edge{from, 0, (int)adj[from].size()-1});
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
                }
            }
        }
        return level[t] != -1;
    }
 
    int dfs(int curr, int t){
        if(curr == t)
            return 1;
 
        for (int &i = ptr[curr]; i < adj[curr].size(); i++){
            Edge &e = adj[curr][i];
            int v = e.to;
 
            if(e.cnt > 0 && level[v] == level[curr] + 1){
                int push = dfs(v, t);
 
                if(push == 0)
                    continue;
 
                e.cnt -= 1;
                adj[e.to][e.revIdx].cnt += 1;
                return push;
            }
        }
        return 0;
    }
 
    void solveBipartiteMatching(int s, int t, int n){
        int max_flow = 0;
        
        while(bfs(s, t)){
            fill(ptr.begin(), ptr.end(), 0);
            while(dfs(s, t))
                max_flow++;
        }
        
        // Print total maximum pairs
        cout << max_flow << "\n";
 
        // Traversed the graph to find the saturated paths (pairs)
        for (int u = 1; u <= n; u++){
            for(const Edge &e : adj[u]){
                int v = e.to;
                
                // If the destination is a girl node and the capacity is exhausted (0)
                if(v > n && v != t && e.cnt == 0){
                    cout << u << " " << (v - n) << "\n"; 
                }
            }
        }
    }
};
 
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
 
    int n, m, k;
    cin >> n >> m >> k;
 
    int s = 0;
    int t = n + m + 1;
 
    Divic divic(t);
 
    // Connect Source to all Boys
    for(int i = 1; i <= n; i++){
        divic.addEdge(s, i);
    }
 
    // Connect all Girls to Sink
    for(int j = 1; j <= m; j++){
        divic.addEdge(n + j, t);
    }
 
    for (int i = 0; i < k; i++){
        int a, b;
        cin >> a >> b;
        divic.addEdge(a, n + b); // Boy 'a' to shifted Girl 'n + b'
    }
 
    divic.solveBipartiteMatching(s, t, n);
 
    return 0;
}