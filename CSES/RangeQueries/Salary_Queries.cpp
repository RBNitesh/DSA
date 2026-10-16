/*
    Idea1: Index compression,
    But, for this first we have to get the all possible salary. Even those salary
    which appears after update query. Then only we can map each salary to an index
    in ascending order

    Idea2: Use PBDS
*/

#include<bits/stdc++.h>
using namespace std;

struct Node{
    char type;
    int first, sd;
};

const int N = 1 << 20;
int t[N << 1];
int p[N];

// update the value at index 'i' to 'x'
void add(int i, int delta){
    i += N;
    t[i] += delta;
    i >>= 1;
    while(i >= 1){
        t[i] = t[2 * i] + t[2 * i + 1];
        i >>= 1;
    }
}

int sum(int a, int b){
    a += N;
    b += N;
    int s = 0;
    while (a <= b)
    {
        if((a & 1) != 0)
            s += t[a++];
        if((b&1) == 0)
            s += t[b--];
        a >>= 1;
        b >>= 1;
    }
    return s;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;
    for (int i = 1; i <= n; ++i){
        cin >> p[i];
    }

    vector<int> salaries;
    salaries.reserve(600001);
    vector<Node> queries(q);
    int idx = 0;
    while(q-- > 0){
        char type;
        int first, sd;
        cin >> type >> first >> sd;
        queries[idx].type = type;
        queries[idx].first = first;
        queries[idx].sd = sd;
        // cout << queries[idx].type << " " << queries[idx].first << " " << queries[idx].sd << " "
        ++idx;
        if (type == '?')
            salaries.push_back(first);
        salaries.push_back(sd);
    }

    // insert the initial salaries
    for (int i = 1; i <= n; ++i)
        salaries.push_back(p[i]);
    // sort the salary in ascending order
    sort(begin(salaries), end(salaries));
    // find the index for the salary
    for (int i = 1; i <= n; ++i){
        p[i] = lower_bound(begin(salaries), end(salaries), p[i]) - begin(salaries);
    }

    // build the segment tree with initial val
    // segment tree is not build on the arr 'p'. It is build on an imaginary arr
    // in which imag_arr[i] = no. of salary that is mapped to 'i'
    for (int i = 1; i <= n; ++i)
    {
        int index = p[i];
        t[N + index] += 1;
    }
    for (int i = N - 1; i >= 1; --i){
        t[i] = t[2 * i] + t[2 * i + 1];
    }


    for (const auto &q : queries)
    {
        char type = q.type;
        // cout << q.type << " " << q.first << " " << q.sd << "\n";
        if (type == '!')
        {
            int k = q.first;
            int x = q.sd; // new salary
            add(p[k], -1); // remove the contribution from old salary of k-th employee
            int xx = lower_bound(begin(salaries), end(salaries), x) - begin(salaries); // mapped index for new salary
            // update the salary of employee 'k' to 'x'
            // this is same as add '1' to the index 'xx'
            add(xx, 1);
            p[k] = xx; // update the salary for the k-th employee as new salary
        }
        else{
            int a = q.first;
            int b = q.sd;
            int aa = lower_bound(begin(salaries), end(salaries), a) - begin(salaries);
            int bb = lower_bound(begin(salaries), end(salaries), b) - begin(salaries);
            // count the no. of employees with salary btw 'a' to 'b'
            // this is same as finding the sum of eles from 'aa' to 'bb'
            cout << sum(aa, bb) << "\n";
        }
    }
}