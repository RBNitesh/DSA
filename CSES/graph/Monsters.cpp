#include<bits/stdc++.h>
using namespace std;

int INF = (int)1e9;

bool inBoundary(int r, int c, int n, int m){
    return r >= 0 && r < n && c >= 0 && c < m;
}

void printPath(int r, int c, int st_r, int st_c, vector<vector<char>> &parent){
    cout << "YES" << "\n";

    vector<char> path;
    while(!(r == st_r && c == st_c)){
        path.push_back(parent[r][c]);
        
        if(parent[r][c] == 'U') r++;
        else if(parent[r][c] == 'R')
            c--;
        else if(parent[r][c] == 'D')
            r--;
        else
            c++;
    }

    reverse(path.begin(), path.end());
    int size = path.size();

    cout << size << "\n";

    for (int i = 0; i < size; i++){
        cout << path[i];
    }
    cout << "\n";
}

void printPathIfPossible(int st_r, int st_c, vector<vector<char>> &grid, vector<vector<int>> &t, vector<vector<char>> &parent){
    int n = grid.size(), m = grid[0].size();

    queue<pair<int, int>> q;
    q.push({st_r, st_c});
    if(t[st_r][st_c] == 0){
        cout << "NO" << "\n";
        return; // monster and you are sharing same square
    }

    t[st_r][st_c] = 0;

    int time = 1;
    while(!q.empty()){
        int N = q.size();

        for (int k = 0; k < N; k++){
            pair<int, int> curr = q.front();
            q.pop();

            int r = curr.first, c = curr.second;

            if(r == 0 || c == 0 || r == n-1 || c == m-1){
                printPath(r, c, st_r, st_c, parent);
                return;
            }

            int delr[] = {-1, 0, 1, 0};
            int delc[] = {0, 1, 0, -1};

            vector<char> dir = {'U', 'R', 'D', 'L'};

            for (int idx = 0; idx < 4; idx++){
                int new_r = r + delr[idx];
                int new_c = c + delc[idx];

                if(inBoundary(new_r, new_c, n, m) && grid[new_r][new_c] == '.' && time < t[new_r][new_c]){
                    q.push({new_r, new_c});
                    t[new_r][new_c] = time; // doing this so we can be saved from revisiting same node
                    parent[new_r][new_c] = dir[idx];
                }
            }
        }
        time++;
    }
    cout << "NO" << "\n";
}

void monstersWalk(vector<vector<char>> &grid, vector<vector<int>> &t){
    int n = grid.size(), m = grid[0].size();

    queue<pair<int,int>> q;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            if(grid[i][j] == 'M'){
                q.push({i, j});
                t[i][j] = 0;
            }
        }
    }

    int time = 1;
    while(!q.empty()){
        int N = q.size();

        for (int k = 0; k < N; k++){
            pair<int, int> curr = q.front();
            q.pop();

            int r = curr.first, c = curr.second;

            int delr[] = {-1, 0, 1, 0};
            int delc[] = {0, 1, 0, -1};

            for (int idx = 0; idx < 4; idx++){
                int new_r = r + delr[idx];
                int new_c = c + delc[idx];

                if(inBoundary(new_r, new_c, n, m) && (grid[new_r][new_c] == '.' || grid[new_r][new_c] == 'A') && time < t[new_r][new_c]){
                    q.push({new_r, new_c});
                    t[new_r][new_c] = time;
                }
            }
        }
        time++;
    }
}

int main(){
    int n, m;
    cin >> n >> m;

    pair<int, int> myPos;

    vector<vector<char>> grid(n, vector<char>(m));
    for (int i = 0; i < n;i++){
        for (int j = 0; j < m; j++){
            cin >> grid[i][j];

            if(grid[i][j] == 'A'){
                myPos = {i, j};
            }
        }
    }

    vector<vector<int>> t(n, vector<int>(m, INF));
    monstersWalk(grid, t);

    // for (int i = 0; i < n; i++){
    //     for (int j = 0; j < m; j++){
    //         cout << t[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    vector<vector<char>> parent(n, vector<char>(m));
    printPathIfPossible(myPos.first, myPos.second, grid, t, parent);

    // for (int i = 0; i < n; i++){
    //     for (int j = 0; j < m; j++){
    //         cout << t[i][j] << " ";
    //     }
    //     cout << "\n";
    // }
}