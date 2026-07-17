#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

void compute(int i, int n, int sum, vector<int>& arr, vector<int>& vec, int x){
    if(sum > x)
        return;

    if(i > n){
        vec.push_back(sum);
        return;
    }

    compute(i + 1, n, sum + arr[i], arr, vec, x);
    compute(i + 1, n, sum, arr, vec, x);
}

void solve(){
    int n, x;
    cin >> n >> x;

    vector<int> arr(n + 1);
    for (int i = 1; i <= n; ++i){
        cin >> arr[i];
    }

    vector<int> vec1, vec2;
    vec1.reserve(1 << n / 2 + 1);
    vec2.reserve(1 << n / 2 + 1);
    compute(1, n / 2, 0, arr, vec1, x);
    compute(n/2+1, n, 0, arr, vec2, x);

    sort(vec1.begin(), vec1.end());
    sort(vec2.begin(), vec2.end());

    ll ans = 0;
    int l = 0, r = vec2.size() - 1;
    while(l < vec1.size() && r >= 0){
        int s1 = vec1[l], s2 = vec2[r];
        
        if(s1 + s2 > x){
            r--;
            continue;
        }
        else if(s1 + s2 < x){
            l++;
            continue;
        }

        int f1 = 0;
        while(l < vec1.size() && vec1[l] == s1){
            l++;
            f1++;
        }

        int f2 = 0;
        while(r >= 0 && vec2[r] == s2){
            r--;
            f2++;
        }

        ans += (ll)f1 * f2;
    }
    cout << ans << "\n";
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}