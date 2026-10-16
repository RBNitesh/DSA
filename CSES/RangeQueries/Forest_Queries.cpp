#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int a[1001][1001] = {};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    for (int i = 1; i <= n; ++i){
        string s;
        cin >> s;
        for (int j = 1; j <= n; ++j)
        {
            char c = s[j-1];
            a[i][j] = c == '*' ? 1: 0;

            // transform the grid into prefix sum grid
            a[i][j] += a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1];
        }
    }
    
    while (q-- > 0)
    {
        // y corresponds to row and x corresponds to col, just visualize co-ordinate axis
        int y1, x1, y2, x2;
        cin >> y1 >> x1 >> y2 >> x2;
        int ans = a[y2][x2] - a[y1 - 1][x2] - a[y2][x1 - 1] + a[y1 - 1][x1 - 1];
        cout << ans << "\n";
    }
}