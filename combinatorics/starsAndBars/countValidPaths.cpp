#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
ll M = 1e9 + 7;

vector<vector<ll>> dp;

// locations[i] -- locations[j] : abs(locations[j] - locations[i])
ll countValidPaths(int curr, int dest, int fuel, vector<int>& locations){
    if(curr == dest) return fuel >= 0;

    if (dp[curr][fuel] != -1)
        return dp[curr][fuel];

    ll paths = 0;
    for (int i = 0; i < locations.size(); ++i){
        if(curr == i)
            continue;

        ll cost = abs(locations[curr] - locations[i]);

        if(fuel >= cost){
            paths += countValidPaths(i, dest, fuel - cost, locations);
            paths %= M;
        }
    }

    return dp[curr][fuel] = paths;
}

void solve(){
    int n, start, finish, fuel;
    cin >> n >> start >> finish >> fuel;

    cout << "Enter the element of locations array" << "\n";
    vector<int> locations(n);
    for (int i = 0; i < n; ++i){
        cin >> locations[i];
    }

    dp.assign(n, vector<ll>(fuel + 1, -1));
    ll res = countValidPaths(start, finish, fuel, locations);
    cout << res << "\n";
}

int main(){
    cout << "Enter the no. of test cases" << "\n";
    int t;
    cin >> t;

    while(t-- > 0){
        solve();
    }
}