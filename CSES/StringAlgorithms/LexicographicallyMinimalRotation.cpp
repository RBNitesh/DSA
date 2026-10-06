#include<bits/stdc++.h>
using namespace std;

void solve(){
    string s;
    cin >> s;

    int n = s.length();
    int i = 0;

    for (int j = 1; j < n; ++j)
    {
        for (int k = 0; k < n; ++k){
            if(s[(i+k)%n] > s[(j+k)%n]){
                i = j;
                break;
            }
            else if(s[(i+k)%n] < s[(j+k)%n]){
                break;
            }
        }
    }
    cout << s.substr(i, n - i) + s.substr(0, i) << "\n";
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}