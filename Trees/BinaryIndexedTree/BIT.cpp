#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<int> bit;
int N;

int sum(int i){
    int sum = 0;
    while(i >= 1){
        sum += bit[i];
        i -= i & -i;
    }
}

void update(int i, int x){
    while(i <= N){
        bit[i] += x;
        i += i & -i;
    }
}

int main(){
    vector<int> vec = {1, 2, 4, 5,3,-2, 5};
    N = vec.size();

    // bit array is 1-indexed
    // reason: if i becomes 0, then in that case (i & -i) will be zero, 
    // and that can lead to infinitely running for loop in update function
    bit.resize(vec.size()+1);

    for (int i = 0; i < vec.size(); i++){
        update(i + 1, vec[i]);
    }

    for (int i = 0; i < vec.size(); i++){
        cout << sum(i + 1) << " ";
    }
}