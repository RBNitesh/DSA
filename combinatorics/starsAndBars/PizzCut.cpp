#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
ll M = 1e9 + 7;

vector<vector<int>> prefixSum;

vector<vector<vector<ll>>> dp;

ll countWays(int sr, int sc, int k, int& rows, int& cols){
    if(k == 1){
        int cnt = prefixSum[rows - 1][cols - 1];
        if(sr > 0)
            cnt -= prefixSum[sr - 1][cols - 1];
        if(sc > 0)
            cnt -= prefixSum[rows - 1][sc - 1];
        if(sr > 0 && sc > 0)
            cnt += prefixSum[sr - 1][sc - 1];
        return cnt > 0; // valid ways
    }
    
    if(dp[sr][sc][k] != -1)
        return dp[sr][sc][k];

    ll ways = 0;
    // horizontal cut
    for (int cut = sr + 1; cut < rows; ++cut){
        int appleCnt = prefixSum[cut - 1][cols - 1];
        if(sc > 0)
            appleCnt -= prefixSum[cut - 1][sc - 1];
        if(sr > 0)
            appleCnt -= prefixSum[sr - 1][cols - 1];
        if(sr > 0 && sc > 0)
            appleCnt += prefixSum[sr - 1][sc - 1];

        if(appleCnt > 0){
            ways += countWays(cut, sc, k - 1, rows, cols);
            ways %= M;
        }
    }

    // vertical cut
    for (int cut = sc + 1; cut < cols; ++cut){
        int appleCnt = prefixSum[rows-1][cut-1];
        if(sr > 0)
            appleCnt -= prefixSum[sr-1][cut-1];
        if(sc > 0)
            appleCnt -= prefixSum[rows-1][sc-1];
        if(sr > 0 && sc > 0)
            appleCnt += prefixSum[sr-1][sc - 1];

        if(appleCnt > 0){
            ways += countWays(sr, cut, k - 1, rows, cols);
            ways %= M;
        }
    }
    return dp[sr][sc][k] = ways;
}

void solve(){
    int rows, cols, k;
    cin >> rows >> cols >> k;

    vector<vector<char>> pizza(rows);

    for (int i = 0; i < rows; ++i){
        vector<char> row(cols);
        for (int j = 0; j < cols; ++j){
            cin >> row[i];
        }
        pizza[i] = row;
    }

    prefixSum.assign(rows, vector<int>(cols, 0));

    for (int i = 0; i < rows; ++i){
        for (int j = 0; j < cols; ++j){
            prefixSum[i][j] = (pizza[i][j] == 'A') ? 1 : 0;
            if(i > 0)
                prefixSum[i][j] += prefixSum[i - 1][j];
            if(j > 0)
                prefixSum[i][j] += prefixSum[i][j - 1];
            if(i > 0 && j > 0)
                prefixSum[i][j] -= prefixSum[i - 1][j - 1];
        }
    }

    if(k == 0){
        cout << 0 << "\n";
        return;
    }

    dp.assign(rows, vector<vector<ll>>(cols, vector<ll>(k + 1, -1)));
    ll res = countWays(0, 0, k, rows, cols);
    cout << res << "\n";
}

int main(){
    int t;
    cin >> t;
    while(t-- > 0){
        solve();
    }
}