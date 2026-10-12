#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int n;
int sz[];
int depth[];
int par[];
int bigchild[];
vector<int> adj[];
int label[];
int chain[];
int label_time = 0;

void initialize_chains(){
    for (int i = 1; i <= n; ++i){
        chain[i] = i;
    }
}

void dfs_chains(int u, int p){
    if(bigchild[u] != -1){
        chain[bigchild[u]] = chain[u];
    }

    for(int v : adj[u]){
        if(v != p){
            dfs_chains(v, u);
        }
    }
}

void seg_update_header(int a, int b, int c){

}

void dfs_labels(int* arr, int u, int p){
    label[u] = label_time++;
    seg_update_header(label[u], label[u], arr[u]);

    if(bigchild[u] != -1){
        dfs_labels(arr, bigchild[u], u);
    }

    for(int v : adj[u]){
        if(v != p && v != bigchild[u]){
            dfs_labels(arr, v, u);
        }
    }
}

void dfs_size(int u, int p, int d){
    sz[u] = 1;
    depth[u] = 1;
    par[u] = p;

    int bigc = -1, bigc_sz = -1;
    for(int v : adj[u]){
        if(v != p){
            dfs_size(v, u, d + 1);
            sz[u] += sz[v];

            if(sz[v] > bigc_sz){
                bigc = v;
                bigc_sz = sz[v];
            }
        }
    }

    bigchild[u] = bigc;
}

int main(){
    
}