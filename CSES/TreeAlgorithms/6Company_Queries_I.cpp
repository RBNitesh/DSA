#include<bits/stdc++.h>
using namespace std;

class BinaryLifting {
    vector<vector<int>> up;
    int LOG;
public:
    BinaryLifting(int &n, vector<int> &parent) {
        LOG = 0;
        while((1<<LOG) <= n)
            ++LOG;

        up.resize(n+1, vector<int>(LOG));

        for(int v = 1; v <= n; v++){
            up[v][0] = parent[v];
        }

        for(int j = 1; j < LOG; j++){
            for(int v = 1; v <= n; v++){
                if(up[v][j-1] != -1)
                    up[v][j] = up[ up[v][j-1] ][j-1];
                else
                    up[v][j] = -1;
            }
        }
    }
    
    int getKthAncestor(int node, int &k) {
        for(int i = LOG-1; i >= 0; i--){
            if((k & (1 << i)) != 0){
                if(node != -1)
                    node = up[node][i];
                else 
                    break;
            }
        }
        return node;
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<int> parent(n+1);
    parent[1] = -1;
    for (int i = 2; i <= n; i++){
        cin >> parent[i];
    }

    BinaryLifting obj(n, parent);

    while(q-- > 0){
        int x, k;
        cin >> x >> k;

        cout << obj.getKthAncestor(x, k) << "\n";
    }
}