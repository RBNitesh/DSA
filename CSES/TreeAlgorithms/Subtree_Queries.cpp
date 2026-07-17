#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<vector<int>> adj;
vector<int> value, lt, start, endtime;
int timer = 1;

class BIT{
    vector<ll> bit; // binary indexed tree
    int n;

public:
    BIT(int n): n(n){
        bit.resize(n + 1);
    }

    ll sum(int i){
        ll sum = 0;
        for (; i > 0; i -= (i & -i)){
            sum += bit[i];
        }
        return sum;
    }
    
    void update(int i, int x){
        for (; i <= n; i+=(i & -i)){
            bit[i] += x;
        }
    }
};

void dfs(int node, int parent){
    lt[timer] = node;
    start[node] = timer++;

    for(int v : adj[node]){
        if(v != parent){
            dfs(v, node);
        }
    }
    lt[timer] = node;
    endtime[node] = timer;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    adj.resize(n + 1);
    value.resize(n + 1);
    lt.resize(2*n + 1);
    start.resize(n + 1);
    endtime.resize(n + 1);

    for (int i = 1; i <= n; i++)
        cin >> value[i];

    for (int i = 1; i < n; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(1, -1);

    BIT obj(timer);

    for (int i = 1; i <= timer; i++){
        obj.update(i, value[lt[i]]);
    }

    while(q-- > 0){
        int type;
        cin >> type;

        if(type == 1){
            int s, x;
            cin >> s >> x;
            int change = x - value[s];

            value[s] = x;

            obj.update(start[s], change);
            obj.update(endtime[s], change);
        }
        else{
            int s;
            cin >> s;
            ll res = obj.sum(endtime[s]) - obj.sum(start[s] - 1);
            res /= 2;
            cout << res << "\n";
        }
    }
}