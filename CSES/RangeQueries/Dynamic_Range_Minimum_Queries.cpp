#include<bits/stdc++.h>
using namespace std;
using ll = long long;

ll t[1 << 20] = {};
ll a[1 << 19] = {};
int N = 1 << 19;

// update the val at pos 'k' to 'u'
void update(int k, int u){
    k += N;
    t[k] = u;
    k >>= 1;
    while (k >= 1)
    {
        t[k] = min(t[2 * k], t[2 * k + 1]);
        k >>= 1;
    }
}

// calculates the sum in the range [a, b]
ll query(int a, int b){
    a += N;
    b += N;
    ll ans = INT_MAX;
    while (a <= b)
    {
        if((a & 1) != 0)
            ans = min(ans, t[a++]);
        if((b & 1) == 0)
            ans = min(ans, t[b--]);
        a >>= 1;
        b >>= 1;
    }
    return ans;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    for (int i = 1; i <= n; ++i){
        cin >> a[i];
        update(i, a[i]); // update initial val
    }

    while(q-- > 0){
        int type;
        cin >> type;

        if(type == 2){
            int a, b;
            cin >> a >> b;
            cout << query(a, b) << "\n";
        }
        else{
            int k, u;
            cin >> k >> u;
            update(k, u);
        }
    }
}