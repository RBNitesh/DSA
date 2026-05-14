#include<bits/stdc++.h>
using namespace std;


bool inBoundary(int r, int c, int n, int m){
    return r >= 0 && r < n && c >= 0 && c < m;
}

pair<int,string> bfs(int r, int c, int end_r, int end_c, vector<vector<char>> &grid){
    int n = grid.size(), m = grid[0].size();

    vector<vector<char>> parent(n, vector<char>(m));

    queue<pair<pair<int,int>,int>> q;
    q.push({{r, c}, 0});
    grid[r][c] = '#'; // marking visited

    int minDist = -1;

    while(!q.empty()){
        pair<pair<int,int>,int> curr = q.front();
        q.pop();

        if(curr.first.first == end_r && curr.first.second == end_c){
            minDist = curr.second;
            break;
        }

        int delr[] = {-1, 0, 1, 0};
        int delc[] = {0, 1, 0, -1};

        vector<char> dir = {'U', 'R', 'D', 'L'};

        for (int i = 0; i < 4; i++){
            int new_r = curr.first.first + delr[i];
            int new_c = curr.first.second + delc[i];

            if(inBoundary(new_r, new_c, n, m) && (grid[new_r][new_c] == 'B' || grid[new_r][new_c] == '.')){
                q.push({{new_r, new_c}, curr.second + 1});
                grid[new_r][new_c] = '#'; // marking visited
                parent[new_r][new_c] = dir[i];
            }
        }
    }
    if(minDist == -1){
        return {minDist, ""};
    }

    unordered_map<char, pair<int, int>> dir_map;
    dir_map.insert({'U', {-1, 0}});
    dir_map.insert({'R', {0, 1}});
    dir_map.insert({'D', {1, 0}});
    dir_map.insert({'L', {0, -1}});


    string path = "";
    while(parent[end_r][end_c] != NULL){
        char sign = parent[end_r][end_c];
        path += sign;
        end_r -= dir_map[sign].first;
        end_c -= dir_map[sign].second;
    }
    reverse(path.begin(), path.end());
    return {minDist, path};
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<vector<char>> grid(n, vector<char>(m));
    int st_r = -1, st_c = -1;
    int end_r = -1, end_c = -1;

    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            cin >> grid[i][j];

            if(grid[i][j] == 'A'){
                st_r = i;
                st_c = j;
            }

            else if(grid[i][j] == 'B'){
                end_r = i;
                end_c = j;
            }
        }
    }

    pair<int,string> res = bfs(st_r, st_c, end_r, end_c, grid);
    
    if(res.first == -1){
        cout << "NO" << "\n";
    }
    else{
        cout << "YES" << "\n";
        cout << res.first << "\n";
        cout << res.second << "\n";
    }
}