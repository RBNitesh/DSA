#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<vector<int>> adj;
vector<int> value;

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

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    adj.resize(n + 1);
   

    for (int i = 1; i <= n; i++)
        cin >> value[i];

    for (int i = 1; i < n; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }
}