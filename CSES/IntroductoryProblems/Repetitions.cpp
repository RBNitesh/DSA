#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

void solve(){
    string s;
    cin >> s;

    int n = s.size();
    unordered_map<char, int> mp;

    int ans = 0;
    int cnt = 0;
    for (int i = 0; i < n; ++i)
    {
        if(i > 0 && s[i] == s[i-1])
            cnt++;
        else
            cnt = 1;

        ans = max(ans, cnt);
    }
    cout << ans << "\n";
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}