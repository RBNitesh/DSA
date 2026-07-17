#include<bits/stdc++.h>
using namespace std;

bool inBoundary(int r, int c, int n, int m){
    return r >= 1 && r <= n && c >= 1 && c <= m;
}

void dfs(int r, int c, int n, int m, vector<vector<char>> &grid){
    if(r < 1 || r > n ||  c < 1 || c > m)
        return;

    grid[r - 1][c - 1] = '#';

    int delr[] = {-1, 0, 1, 0};
    int delc[] = {0, 1, 0, -1};

    for (int i = 1; i <= 4; i++){
        int new_r = r + delr[i - 1];
        int new_c = c + delc[i - 1];

        if(inBoundary(new_r, new_c, n, m) && grid[new_r-1][new_c-1] == '.'){
            dfs(new_r, new_c, n, m, grid);
        }
    }
}

int countRooms(vector<vector<char>> &grid, int n, int m){
    int cnt = 0;

    for (int i = 1; i <= n; i++){
        for (int j = 1; j <= m; j++){
            if(grid[i-1][j-1] == '.'){
                cnt++;
                dfs(i, j, n, m, grid);
            }
        }
    }
    return cnt;
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<vector<char>> grid(n, vector<char>(m));
    for (int i = 1; i <= n; i++){
        for (int j = 1; j <= m; j++){
            cin >> grid[i - 1][j - 1];
        }
    }

    cout << countRooms(grid, n, m) << "\n";
}