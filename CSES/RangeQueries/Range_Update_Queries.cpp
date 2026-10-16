/*
    Approach1: Diff Arr + Point Update
    Approach2: Range Update 
*/

#include<bits/stdc++.h>
using namespace std;
using ll = long long;

/*
ll t[1<<20] = {};
ll a[1 << 19] = {};
int N = 1<<19;

void build(){
    for (int i = 0; i < N; ++i){
        t[N + i] = a[i];
    }
    for (int i = N-1; i >= 1; --i){
        t[i] = t[2 * i] + t[2 * i + 1];
    }
}

void add(int i, int delta){
    i += N;
    t[i] += delta;
    i >>= 1;
    while(i >= 1){
        t[i] = t[2 * i] + t[2 * i + 1];
        i >>= 1;
    }
}

ll sum(int a, int b){
    a += N;
    b += N;
    ll s = 0;
    while(a <= b){
        if((a&1) != 0)
            s += t[a++];
        if((b&1) == 0)
            s += t[b--];
        a >>= 1;
        b >>= 1;
    }
    return s;
}
*/

// using binary indexed tree
ll bit[(1<<19)+1];
ll a[1<<19];
int N = 1 << 19;

void add(int i, int delta){
    while(i <= N){
        bit[i] += delta;
        i += i & -i;
    }
}

// calculate sum from 0 to i
ll sum(int i){
    ll s = 0;
    while(i >= 1){
        s += bit[i];
        i -= i & -i;
    }
    return s;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    for (int i = 1; i <= n; ++i){
        cin >> a[i];
    }

    // transform the org arr into difference array
    for (int i = n; i >= 2; --i){
        a[i] = a[i] - a[i-1];
    }

    // build();

    // in bit we have only func add() and sum(). 
    // So, instead of build() we will do add() initially for all the arr eles.
    for (int i = 1; i <= n; ++i){
        add(i, a[i]);
    }

    while (q-- > 0)
    {
        int type;
        cin >> type;

        if (type == 1)
        {
            int a, b, u;
            cin >> a >> b >> u;
            add(a, u);
            add(b + 1, -u);
        }
        else{
            int k;
            cin >> k;
            // cout << sum(1, k) << "\n"; // this is for seg tree
            cout << sum(k) << "\n";       // this is for bit
        }
    }
}