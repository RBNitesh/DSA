/*
    [2, 4, 6, 8, 10]
    [1, 2, 3, 4, 5]

    ans = {1, 3, 5, 7, 9}
*/

#include<bits/stdc++.h>
using namespace std;
using ll = long long;

// stores the actual elements
int a[200001];
// stores the info if the ele at index 'i' is present or not
// adding -1 to the ele at index 'i' in b arr means removing the ele
int b[200001]; 
int bit[200001];
int N = 200000;

// add delta to ele present at index 'i'
void add(int i, int delta){
    while (i <= N){
        bit[i] += delta;
        i += i & -i;
    }
}

// calculates the sum of all eles from index '0' to 'i'
int sum(int i){
    int s = 0;
    while(i >= 1){
        s += bit[i];
        i -= i & -i;
    }
    return s;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 1; i <= n; ++i){
        cin >> a[i];
        b[i] = 1; // contribution
        add(i, b[i]); // build the BIT on b arr
    }

    for (int i = 1; i <= n; ++i){
        int pos; // ele position to be removed
        cin >> pos;
        int lo = 1, hi = n;
        int ans = 0; // actual position of the ele to be removed 
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            // check if no. of eles in the left is greater than or equal to pos
            if(sum(mid) >= pos){ 
                ans = mid;
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        cout << a[ans] << " ";
        add(ans, -1);
    }
}