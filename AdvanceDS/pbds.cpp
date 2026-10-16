#include<iostream>
using namespace std;

// Header file for pbds
#include<ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;

// It provides two useful methods find_by_order(e) and order_of_key(e)  
typedef tree<int,null_type,less<int>,rb_tree_tag,tree_order_statistics_node_update> indexed_set;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    indexed_set s;
    s.insert(1);
    s.insert(10);
    s.insert(5);
    s.insert(7);

    for(int it : s) cout << it << endl;

    cout << "second smallest ele: " << *s.find_by_order(1) << "\n";
    cout << "index of 7 in the set: " << s.order_of_key(7) << "\n";
}
