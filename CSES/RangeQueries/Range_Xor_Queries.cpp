#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<ll> arr(n+1, 0);
    for (int i = 1; i <= n; ++i){
        cin >> arr[i];
    }

    for (int i = 2; i <= n; ++i){
        arr[i] ^= arr[i - 1];
    }

    while(q-- > 0){
        int a, b;
        cin >> a >> b;
        ll xor_sum = arr[b] ^ arr[a - 1];
        cout << xor_sum << "\n";
    }
    return 0;
}