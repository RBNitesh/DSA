#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int sum(int i, vector<int> &bit){
    int sum = 0;
    for (; i >= 1; i -= (i & -i)){
        sum += bit[i];
    }
    return sum;
}

void update(int i, int x, vector<int> &bit){
    int N = bit.size();
    for (; i < N; i+=(i & -i)){
        bit[i] += x;
    }
}

int main(){
    vector<int> vec = {1, 2, 4, 5,3,-2, 5};

    // bit array is 1-indexed
    // reason: if i becomes 0, then in that case (i & -i) will be zero, 
    // and that can lead to infinitely running for loop in update function
    vector<int> bit(vec.size()+1);

    for (int i = 0; i < vec.size(); i++){
        update(i + 1, vec[i], bit);
    }

    for (int i = 0; i < vec.size(); i++){
        cout << sum(i + 1, bit) << " ";
    }
}