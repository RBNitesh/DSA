#include <bits/stdc++.h>
using namespace std;

// Types
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
using vi = vector<int>;
using vl = vector<ll>;
using vs = vector<string>;
using vpi = vector<pair<int, int>>;
using vpl = vector<pair<ll, ll>>;
using vvi = vector<vector<int>>;
using vvl = vector<vector<ll>>;
using vvpi = vector<vector<pair<int, int>>>;
using vvpl = vector<vector<pair<ll, ll>>>;

// Constants
const ll MOD = 1e9 + 7;
const ll INF = 1e9 + 7;
const ll LINF = 1e18 + 7;
const double EPS = 1e-9;

// Macros
#define pb push_back
#define eb emplace_back
#define mp make_pair
#define ff first
#define ss second
#define all(a) (a).begin(), (a).end()
#define rall(a) (a).rbegin(), (a).rend()
#define sz(x) static_cast<int>((x).size())

// Loops
#define f(i, a, b) for (int i = (a); i <= (b); ++i)
#define rf(i, a, b) for (int i = (a); i >= (b); --i)
#define F(i, a, b, k) for (int i = (a); i <= (b); i += (k))

// Vector & Pair I/O Overloads
template <typename T1, typename T2>
istream& operator>>(istream& in, pair<T1, T2>& p) {
    return in >> p.first >> p.second;
}

template <typename T1, typename T2>
ostream& operator<<(ostream& out, const pair<T1, T2>& p) {
    return out << p.first << " " << p.second;
}

template <typename T>
istream& operator>>(istream& in, vector<T>& v) {
    for (auto& x : v) in >> x;
    return in;
}

template <typename T>
ostream& operator<<(ostream& out, const vector<T>& v) {
    for (size_t i = 0; i < v.size(); ++i) {
        out << v[i] << (i + 1 == v.size() ? "" : " ");
    }
    return out;
}

// Common Utility Functions
ll gcd(ll a, ll b) { return b ? gcd(b, a % b) : a; }
ll lcm(ll a, ll b) { return (a / gcd(a, b)) * b; }

ll binpow(ll base, ll exp, ll mod = MOD) {
    ll res = 1;
    base %= mod;
    while (exp > 0) {
        if (exp % 2 == 1) res = (__int128)res * base % mod;
        base = (__int128)base * base % mod;
        exp /= 2;
    }
    return res;
}

ll ceil_div(ll a, ll b) {
    return (a + b - 1) / b;
}

void solve() {
    // Your code here
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--) {
        solve();
    }

    return 0;
}

