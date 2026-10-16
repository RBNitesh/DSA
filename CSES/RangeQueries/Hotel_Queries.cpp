/*
    intution: Every time a group of tourists come for rooms in hotel,
            find the first hotel with the empty rooms more than the 
            tourists in the group. 
    
    * four this type of operation we can use the binary search on segment tree.
      where segment tree stores the maximum empty rooms among all the hotels in 
      the range.

    * once we assign the rooms to tourists, we will update the empty rooms for the hotel.
     (simple point update)
*/


#include<bits/stdc++.h>
using namespace std;

using ll = long long;

int t[1<<20] = {};
int h[1 << 19] = {};
int N = 1 << 19;

void build(){
    for (int i = 0; i < N; ++i){
        t[N + i] = h[i];
    }
    for (int i = N - 1; i >= 1; --i){
        t[i] = max(t[2 * i], t[2 * i + 1]);
    }
}

void add(int i, int delta){
    i += N;
    t[i] += delta;
    i >>= 1;
    while(i >= 1){
        t[i] = max(t[2 * i], t[2 * i + 1]);
        i >>= 1;
    }
}

// finds the maximum in the range from 'a' to 'b'
int maximum(int a, int b){
    a += N;
    b += N;
    int ans = 0;
    while (a <= b)
    {
        if((a & 1) != 0)
            ans = max(ans, t[a++]);
        if((b & 1) == 0)
            ans = max(ans, t[b--]);
        a >>= 1;
        b >>= 1;
    }
    return ans;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; ++i){
        cin >> h[i];
    }

    build(); // build the segment tree with initial eles

    for (int i = 1; i <= m; ++i){
        int rr; // rooms required
        cin >> rr;
        int lo = 1, hi = n;
        int ans = 0; // assigned hotel
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            // check if there any ele in left that is greater than or equal to rr
            if (maximum(1, mid) >= rr){
                ans = mid; // update the ans 
                hi = mid - 1; // move to left (try to find the left most valid ele)
            }
            else{
                lo = mid + 1; // move to right
            }
        }
        cout << ans << " ";
        // if ans = 0, means we didn't find any ele greater than or equal to rr
        // update the count of empty rooms
        if(ans != 0){
            add(ans, -rr);
        }
    }
}