#include<iostream>
#include<algorithm>
#include<limits.h>
#include<cstring>
using namespace std;
using ll = long long;

const ll INF = LLONG_MAX;
const int N = 1 << 18;
ll t[N << 1];
ll lazy[N << 1];
ll a[N];

void propogate(int i, int L, int R){
    t[i] += lazy[i];
    if(L != R){
        lazy[2 * i] += lazy[i];
        lazy[2 * i + 1] += lazy[i];
    }
    lazy[i] = 0;
}

void build(){
    for (int i = 0; i < N; ++i){
        t[N + i] = a[i];
    }
    for (int i = N - 1; i >= 1; --i){
        t[i] = max(t[2 * i], t[2 * i + 1]);
    }
}

// range update
void update(int ql, int qr, int delta, int i, int L, int R){
    if(lazy[i] != 0)
        propogate(i, L, R);
    if(ql > R || qr < L)
        return;
    if(ql <= L && qr >= R){
        lazy[i] += delta;
        propogate(i, L, R);
        return;
    }
    int mid = L + (R - L) / 2;
    update(ql, qr, delta, 2 * i, L, mid);
    update(ql, qr, delta, 2 * i + 1, mid + 1, R);
    t[i] = max(t[2 * i], t[2 * i + 1]);
}

void add(int ql, int qr, int delta){
    update(ql, qr, delta, 1, 0, N - 1);
}

// query to find the maximum in a range
ll query(int ql, int qr, int i, int L, int R){
    if(ql > R || qr < L)
        return -INF; 
    if(lazy[i] != 0)
        propogate(i, L, R);
    if(ql <= L && qr >= R)
        return t[i];
    int mid = L + (R - L) / 2;
    return max(query(ql, qr, 2 * i, L, mid), query(ql, qr, 2 * i + 1, mid + 1, R));
}

ll findMax(int ql, int qr){
    return query(ql, qr, 1, 0, N - 1);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    for (int i = 1; i <= n; ++i)
    {
        cin >> a[i];
        a[i] += a[i - 1];
        // cout << a[i] << " ";
    }

    build();

    // cout << "\n";

    // recover the arr
    for (int i = n; i > 1; --i){
        a[i] -= a[i - 1];
        // cout << a[i] << " ";
    }

    while (q-- > 0)
    {
        int type;
        cin >> type;
        if (type == 1)
        {
            int k, u;
            cin >> k >> u;
            add(k, n, u - a[k]);
            a[k] = u;
        }
        else{
            int a, b;
            cin >> a >> b;
            ll ans = findMax(a, b) - findMax(a - 1, a - 1);
            // empty prefix is allowed. so, ans would always be greater than or equal to zero
            cout << max(1ll * 0, ans) << "\n"; 
        }
    }
}