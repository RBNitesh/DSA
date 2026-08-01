#include<bits/stdc++.h>
using namespace std;

class manacher{
    public:
    // s is #c1#c2#c3#c4....cn#
    vector<int> manacher_odd(string s) {
        int n = s.size();
        s = "$" + s + "^";
        vector<int> p(n + 2);
        int l = 0, r = 1;
        for(int i = 1; i <= n; i++) {
            if(i <= r) {
                p[i] = min(r - i, p[l + (r - i)]);
            }
            while(s[i - p[i]] == s[i + p[i]]) {
                p[i]++;
            }
            if(i + p[i] > r) {
                l = i - p[i], r = i + p[i];
            }
        }
        return vector<int>(begin(p) + 1, end(p) - 1);
    }

    vector<int> run_manacher(string s) {
        string t;
        for(auto c: s) {
            t += string("#") + c;
        }
        auto res = manacher_odd(t + "#");
        return vector<int>(begin(res), end(res));
    }
};

void solve(){
    string s;
    cin >> s;

    manacher m;
    auto res = m.run_manacher(s);

    for (int i = 0; i < s.length(); ++i){
        int pos = 2 * i + 1;
        cout << "Longest Palindrome at index " << i << ": " << res[pos] - 1 << "\n";
    }
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while(t-- > 0){
        solve();
    }
}