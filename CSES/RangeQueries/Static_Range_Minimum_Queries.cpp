#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int t[1 << 20];
int arr[1 << 19];
int N = 1 << 19;

void add(int i, int delta){
    i += N;
    t[i] += delta;
    i >>= 1;
    while(i >= 1){
        t[i] = min(t[2 * i], t[2 * i + 1]);
        i >>= 1;
    }
}

// void build(){
//     // copy the nodes of org arr into leaf node of seg tree
//     for (int i = 0; i < N; ++i){
//         t[N + i] = arr[i];
//     }
//     // update the nodes of seg tree in bottom-up fashion
//     for (int i = N - 1; i >= 1; --i){
//         t[i] = min(t[2 * i], t[2 * i + 1]);
//     }
// }

int query(int a, int b){
    a += N;
    b += N;
    int ans = INT_MAX;
    while (a <= b)
    {
        if((a & 1) != 0){
            ans = min(ans, t[a++]);
        }
        if((a & 1) == 0){
            ans = min(ans, t[b--]);
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
        cin >> arr[i];
    }

    // build();
    for (int i = 1; i <= n; ++i){
        add(i, arr[i]);
    }

    while (q-- > 0)
    {
        int a, b;
        cin >> a >> b;
        cout << query(a, b) << "\n";
    }
}