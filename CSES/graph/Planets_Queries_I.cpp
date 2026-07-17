// Tag: Binary Lifting
#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    cout.tie(NULL);

    int n, q;
    cin >> n >> q;

    vector<int> teleport(n + 1);
    for (int i = 1; i <= n; i++){
        cin >> teleport[i];
    }

    int LOG = 30;
    // next[u][j]: planet where you reach after taking (1 << j) flight starting from u.
    int next[n+1][LOG];

    for (int u = 1; u <= n; u++){
        next[u][0] = teleport[u];
    }

    // O(N*LOG)
    for (int j = 1; j < LOG; j++){
        for (int u = 1; u <= n; u++){
            next[u][j] = next[next[u][j-1]][j - 1];
        }
    }

    while(q-- > 0){ // O(q*LOG)
        int x, k;
        cin >> x >> k;

        int curr = x;
        while(k > 0){
            int bit = __builtin_ctz(k); // finds no. of trailing zeros
            curr = next[curr][bit];
            k &= k - 1;
        }
        cout << curr << "\n";
    }
}