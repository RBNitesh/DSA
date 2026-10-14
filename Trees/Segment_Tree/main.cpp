#include<bits/stdc++.h>
using namespace std;

// range query with the help of difference array

/* segment tree */
int sgt[1 << 20] = {};
int N = 1 << 19;

// add delta to index i
void add(int i, int delta){
    i += N;
    while(i >= 1){
        sgt[i] += delta;
        i /= 2;
    }
}

// calculate the sum for the range [a, b] index
int sum(int a, int b){
    a += N;
    b += N;

    int s = 0;
    while(a <= b){
        if(a % 2 == 1)
            s += sgt[a++];
        if(b % 2 == 0)
            s += sgt[b--];

        a /= 2;
        b /= 2;
    }

    return s;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> arr = {1, 2, 3, 4, 5, 6};
    for (int i = 0; i < arr.size(); ++i)
        add(i, arr[i]);

    for (int i = 0; i < arr.size(); ++i){
        cout << sum(0, i) << " ";
    }
}