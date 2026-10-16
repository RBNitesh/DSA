/*
    p[k] + |a - b|  
*/

#include<iostream>
#include<limits.h>
using namespace std;

using ll = long long;

const int N = 1 << 18;
ll t1[N<<1];
ll t2[N<<1];
ll p[N];

// build the seg tree
void build(){
    for (int i = 0; i < N; ++i){
        t1[N + i] = p[i] - i;
        t2[N + i] = p[i] + i;
    }
    for (int i = N - 1; i >= 1; --i){
        t1[i] = min(t1[2 * i], t1[2 * i + 1]);
        t2[i] = min(t2[2 * i], t2[2 * i + 1]);
    }
}
// add the delta to the ele at index 'i'
void add(int i, int delta){
    i += N;
    t1[i] += delta;
    t2[i] += delta;
    i >>= 1;
    while(i >= 1){
        t1[i] = min(t1[2 * i], t1[2 * i + 1]);
        t2[i] = min(t2[2 * i], t2[2 * i + 1]);
        i >>= 1;
    }
}
// find the min value of p[i]-i, where a <= i <= b 
ll right_query(int a, int b){
    a += N;
    b += N;
    ll ans = LLONG_MAX;
    while (a <= b)
    {
        if((a&1) != 0){
            ans = min(ans, t2[a++]);
        }
        if((b & 1) == 0){
            ans = min(ans, t2[b--]);
        }
        a >>= 1;
        b >>= 1;
    }
    return ans;
}
// find the min value of p[i] + i, where a <= i <= b
ll left_query(int a, int b){
    a += N;
    b += N;
    ll ans = LLONG_MAX;
    while (a <= b)
    {
        if((a&1) != 0){
            ans = min(ans, t1[a++]);
        }
        if((b & 1) == 0){
            ans = min(ans, t1[b--]);
        }
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
        cin >> p[i];
    }

    build();

    while(q-- > 0){
        int type;
        cin >> type;
        if(type==1){
            int k, x;
            cin >> k >> x;
            int delta = x - p[k];
            add(k, delta);
            p[k] = x;
        }
        else{
            int k;
            cin >> k;
            // for left, cost  = min value of p[i] + (k - i) = (p[i] - i) + k = t1[i] + k, where a <= i <= b
            // for right, cost = min value of p[i] + (i - k) = (p[i] + i) - k = t2[i] - k, where a <= i <= b
            ll ans = min(left_query(1, k) + k, right_query(k, n) - k);
            cout << ans << "\n";
        }
    }
}